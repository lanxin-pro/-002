package com.ruoyi.bigtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.bigtian.domain.Parks;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 停车场Redis数据初始化器
 * 在项目启动时自动将审核通过的停车场信息加载到Redis中
 */
@Component
public class ParkRedisInitializer implements CommandLineRunner {

    @Autowired
    private ParksServiceImpl parksService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) {
        // 清除旧的GEO数据
        redisTemplate.delete(RedisConstants.PARK_GEO);
        
        // 查询所有审核通过的停车场
        LambdaQueryWrapper<Parks> wrapper = Wrappers.<Parks>lambdaQuery()
                .eq(Parks::getState, Constants.PARK_STATUS);
        List<Parks> parksList = parksService.list(wrapper);
        
        if (!parksList.isEmpty()) {
            GeoOperations<String, Long> geo = redisTemplate.opsForGeo();
            
            // 将停车场信息添加到Redis GEO中
            for (Parks park : parksList) {
                try {
                    geo.add(RedisConstants.PARK_GEO,
                            new Point(Double.parseDouble(park.getLongitude()),
                                    Double.parseDouble(park.getLatitude())),
                            park.getId());
                } catch (Exception e) {
                    System.err.println("初始化停车场[" + park.getName() + "]GEO数据失败: " + e.getMessage());
                }
            }
            
            System.out.println("成功初始化 " + parksList.size() + " 个停车场的GEO数据到Redis");
        }
    }
} 
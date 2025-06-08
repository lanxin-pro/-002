package com.ruoyi.bigtian.mapper;

import java.util.List;
import com.ruoyi.bigtian.domain.Parks;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;
/**
 * 停车场Mapper接口
 * 
 * @author bigtian
 * @Date 2023-04-27
 */
public interface ParksMapper   extends BaseMapper<Parks>
{
    /**
     * 查询停车场
     * 
     * @param id 停车场主键
     * @return 停车场
     */
    public Parks selectParksById(Long id);

    /**
     * 查询停车场列表
     * 
     * @param parks 停车场
     * @return 停车场集合
     */
    public List<Parks> selectParksList(Parks parks);

    /**
     * 新增停车场
     * 
     * @param parks 停车场
     * @return 结果
     */
    public int insertParks(Parks parks);

    /**
     * 修改停车场
     * 
     * @param parks 停车场
     * @return 结果
     */
    public int updateParks(Parks parks);

    /**
     * 删除停车场
     * 
     * @param id 停车场主键
     * @return 结果
     */
    public int deleteParksById(Long id);

    /**
     * 批量删除停车场
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParksByIds(Long[] ids);

    /**
     * 减少可用车辆数量
     *
     * @param parkId 停车场ID
     * @return 结果
     */
    @Update("UPDATE t_parks SET available_bikes = available_bikes - 1 WHERE id = #{parkId} AND available_bikes > 0")
    public int decrementAvailableBikes(Long parkId);
}

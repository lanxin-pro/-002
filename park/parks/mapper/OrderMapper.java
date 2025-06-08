package parks.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import parks.entity.Order;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO t_order (park_id, user_id, destination, duration, total_cost, status, create_time, update_time) " +
            "VALUES (#{parkId}, #{userId}, #{destination}, #{duration}, #{totalCost}, #{status}, #{createTime}, #{updateTime})")
    int insert(Order order);
} 
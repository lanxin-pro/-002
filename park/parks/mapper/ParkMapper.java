package parks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import parks.entity.Park;

@Mapper
public interface ParkMapper {
    @Select("SELECT * FROM t_park WHERE id = #{id}")
    Park selectById(Long id);

    @Update("UPDATE t_park SET available_bikes = available_bikes - 1 WHERE id = #{parkId} AND available_bikes > 0")
    int decrementAvailableBikes(Long parkId);
} 
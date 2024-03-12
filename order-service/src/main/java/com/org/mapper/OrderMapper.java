package com.org.mapper;

import com.org.entity.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Select("select * from order1 where order_id = #{id}")
    Order selectById(@Param("id") int id);
}

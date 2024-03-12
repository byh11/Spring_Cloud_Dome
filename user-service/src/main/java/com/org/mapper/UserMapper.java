package com.org.mapper;

import com.org.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User selectById(@Param("id")int id);

}

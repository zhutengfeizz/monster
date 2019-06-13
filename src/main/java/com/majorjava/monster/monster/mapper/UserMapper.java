package com.majorjava.monster.monster.mapper;


import com.majorjava.monster.monster.entity.user.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time")
    })
    List<User> getAll();


    @Select("select * from t_user  where state = 0  order by create_time desc")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "sex",  column = "sex"),
            @Result(property = "email",  column = "email"),
            @Result(property = "age",  column = "age"),
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time")
    })
    List<User> findAll();



    @Select("select * from t_user  where state = 1  order by create_time desc")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "sex",  column = "sex"),
            @Result(property = "email",  column = "email"),
            @Result(property = "age",  column = "age"),
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time")
    })
    List<User> findBydelete();
}

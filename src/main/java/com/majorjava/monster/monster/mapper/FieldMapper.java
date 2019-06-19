package com.majorjava.monster.monster.mapper;

import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-17 15:24
 **/
@Repository
public interface FieldMapper {

    @Select("select * from t_field  where state = 0  order by create_time desc")
    @Results({
            @Result(property = "createTime", column = "create_time"),

    })
    List<PartitionField> findAll();
}

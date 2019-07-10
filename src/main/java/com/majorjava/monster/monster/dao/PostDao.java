package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import javafx.geometry.Pos;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-17 16:32
 **/
@Repository
public interface PostDao extends CrudRepository<Post, Integer>, JpaRepository<Post, Integer> {
  /**
   * 2019/7/10
   * 没有分页查询
   * @author ztf
   * @return java.util.List<com.majorjava.monster.monster.entity.user.Post>
   */
    List<Post> findByStateOrderByCreateTimeDesc(int state);
    List<Post>findByNameLikeAndStateOrderByCreateTimeDesc(String pname,int state);
    List<Post>findByFieldIdAndStateOrderByCreateTimeDesc(Integer id,int state);
    List<Post>findByPartitionIdAndStateOrderByCreateTimeDesc(Integer id,int state);
    List<Post>findAllByStateOrderByViewsDesc(int state);
    Post findByName(String pname);
    Post findByNameLike(String pname);

    /**
     * 2019/7/10
     * 分页查询
     * @author ztf
     * @return org.springframework.data.domain.Page<com.majorjava.monster.monster.entity.user.Post>
     */
    @Query(value = "select * from t_post limit ?,?",nativeQuery = true)
    List<Post> postAll(Integer page,Integer limit);
}

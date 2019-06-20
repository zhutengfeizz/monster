package com.majorjava.monster.monster.entity.FollowersAndFans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *用户关系：粉丝与被关注者
 * @author : ztf
 * @date : 2019-06-20 10:15
 **/
@Entity
@IdClass(RelationshipPK.class)
public class Relationship {
    private Integer fromUserId;
    private Integer toUserId;
    public Relationship() {
    }
    public Relationship(Integer fromUserId, Integer toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }
    @Id
    @Column(name = "from_user_id", nullable = false)
    public Integer getFromUserId() {
        return fromUserId;
    }
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }
    @Id
    @Column(name = "to_user_id", nullable = false)
    public Integer getToUserId() {
        return toUserId;
    }
    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationship that = (Relationship) o;
        if (fromUserId != null ? !fromUserId.equals(that.fromUserId) : that.fromUserId != null) return false;
        if (toUserId != null ? !toUserId.equals(that.toUserId) : that.toUserId != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = fromUserId != null ? fromUserId.hashCode() : 0;
        result = 31 * result + (toUserId != null ? toUserId.hashCode() : 0);
        return result;
    }
}

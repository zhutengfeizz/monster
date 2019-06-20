package com.majorjava.monster.monster.entity.FollowersAndFans;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-20 10:19
 **/
public class RelationshipPK implements Serializable {
    private Integer fromUserId;
    private Integer toUserId;

    @Column(name = "from_user_id", nullable = false)
    @Id
    public Integer getFromUserId() {
        return fromUserId;
    }
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }
    @Column(name = "to_user_id", nullable = false)
    @Id
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
        RelationshipPK that = (RelationshipPK) o;
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

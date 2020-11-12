package com.codecool.dogmate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FriendsKey implements Serializable {

    @Column(nullable = false, name = "relating_user_id")
    Long relatingUserId;

    @Column(nullable = false, name = "related_user_id")
    Long relatedUserId;

    public FriendsKey(Long relatingUserId, Long relatedUserId) {
        this.relatingUserId = relatingUserId;
        this.relatedUserId = relatedUserId;
    }

    public FriendsKey() {
    }

    public Long getRelatingUserId() {
        return relatingUserId;
    }

    public void setRelatingUserId(Long relatingUserId) {
        this.relatingUserId = relatingUserId;
    }

    public Long getRelatedUserId() {
        return relatedUserId;
    }

    public void setRelatedUserId(Long relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsKey that = (FriendsKey) o;
        return getRelatingUserId().equals(that.getRelatingUserId()) &&
                getRelatedUserId().equals(that.getRelatedUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRelatingUserId(), getRelatedUserId());
    }
}

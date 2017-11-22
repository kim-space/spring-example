package com.kimtd.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntityListener {

    @PrePersist
    public void prePerist(BaseEntity<?> entity) {
        entity.setCreateDate(new Date());
        entity.setModifyDate(new Date());
        entity.setVersion(null);
    }

    @PreUpdate
    public void preUpdate(BaseEntity<?> entity) {
        entity.setModifyDate(new Date());
    }
}

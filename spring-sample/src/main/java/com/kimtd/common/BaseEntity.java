package com.kimtd.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    public static final String ID_PROPERTY_NAME = "id";

    public static final String CREATE_DATE_PROPERTY_NAME = "createDate";

    public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";

    public static final String VERSION_PROPERTY_NAME = "version";


    private ID id;
    private Date createDate;
    private Date modifyDate;
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Column(nullable = false)
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(nullable = false)
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Version
    @Column(nullable = false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(createDate, that.createDate) &&
                Objects.equal(modifyDate, that.modifyDate) &&
                Objects.equal(version, that.version);
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += getId() != null ? getId().hashCode() * 31 : 0;
        return hashCode;
//        return Objects.hashCode(id, createDate, modifyDate, version);
    }
}

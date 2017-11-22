package com.kimtd.entity;

import com.kimtd.common.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_BLOG")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "seq_blog")
@Data
@ToString
public class Blog extends BaseEntity<Long> {

    private String title;
    private String author;
    private String content;
}

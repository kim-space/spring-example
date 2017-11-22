package com.kimtd.dao;

import com.kimtd.common.BaseDaoImpl;
import com.kimtd.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository("blogDaoImpl")
public class BlogDaoImpl extends BaseDaoImpl<Blog,Long> implements BlogDao{
}

package com.kimtd.service;

import com.kimtd.common.BaseServiceImpl;
import com.kimtd.entity.Blog;
import org.springframework.stereotype.Service;

@Service(value = "blogServiceImpl")
public class BlogServiceImpl extends BaseServiceImpl<Blog, Long> implements BlogService{
}

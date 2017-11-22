package com.kimtd.controller;

import com.kimtd.common.RestResponse;
import com.kimtd.entity.Blog;
import com.kimtd.service.BlogService;
import com.mchange.lang.LongUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    @PostMapping
    public RestResponse publish(@RequestBody Blog blog){
        ModelMap modelMap = new ModelMap();
        logger.debug("发布博客："+blog);
        Blog save = blogService.save(blog);
        modelMap.addAttribute(save);
        return RestResponse.success(modelMap);
    }

    @GetMapping("/{id}")
    public RestResponse lookUp(@PathVariable("id") Long id){
        ModelMap modelMap = new ModelMap();
        Blog blog = blogService.find(id);
        logger.debug("查看博客: "+blog);
        modelMap.addAttribute(blog);
        return RestResponse.success(modelMap);
    }

    @PutMapping
    public RestResponse update(@RequestBody Blog blog){
        ModelMap modelMap = new ModelMap();
        if (blog.getId() == null) {
            logger.error("更新错误，必需带上标志ID");
            return RestResponse.error("更新错误，必需带上标志ID");
        }
        Blog update = blogService.update(blog);
        logger.debug("更新博客: "+update);
        modelMap.addAttribute(blog);
        return RestResponse.success(modelMap);
    }

    @DeleteMapping("/{id}")
    public RestResponse delete(@PathVariable("id") Long id){
        blogService.delete(id);
        logger.debug("删除博客："+ id);
        return RestResponse.success(new ModelMap());
    }



}

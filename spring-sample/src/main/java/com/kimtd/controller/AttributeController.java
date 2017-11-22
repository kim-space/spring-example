package com.kimtd.controller;

import com.kimtd.common.RestResponse;
import com.kimtd.entity.Attribute;
import com.kimtd.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public RestResponse addAttribute(@RequestBody Attribute attribute){
        ModelMap modelMap = new ModelMap();
        logger.debug("添加属性："+attribute);
        Attribute save = attributeService.save(attribute);
        modelMap.addAttribute(save);
        return RestResponse.success(modelMap);
    }

    @GetMapping("/{id}")
    public RestResponse getAttribute(@PathVariable("id") Long id){
        ModelMap modelMap = new ModelMap();
        Attribute attribute = attributeService.find(id);
        logger.debug("获取属性："+attribute);
        modelMap.addAttribute(attribute);
        return RestResponse.success(modelMap);
    }


}

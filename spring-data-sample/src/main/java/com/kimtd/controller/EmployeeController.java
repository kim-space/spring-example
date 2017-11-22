package com.kimtd.controller;

import com.kimtd.common.RestResponse;
import com.kimtd.entity.Employee;
import com.kimtd.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping
    public RestResponse save(@RequestBody Employee employee){
        ModelMap modelMap = new ModelMap();
        Employee save = employeeService.save(employee);
        logger.debug("employee  : "+save);
        modelMap.addAttribute(save);
        return RestResponse.success(modelMap);
    }

    @GetMapping("/{id}")
    public RestResponse get(@PathVariable("id") Integer id){
        ModelMap modelMap = new ModelMap();
        Employee employee = employeeService.get(id);
        logger.debug("employee info : "+employee);
        modelMap.addAttribute(employee);
        return RestResponse.success(modelMap);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody String name){
        employeeService.changeEmployeeInfo(id,name);
    }
}

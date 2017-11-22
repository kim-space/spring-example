package com.kimtd.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * 自定义接口
 */
@NoRepositoryBean
public interface EmployeeRepositoryCustom {

    void sayHello();

}

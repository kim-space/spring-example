package com.kimtd.repository;

/**
 * Employee自定义接口实现 Impl后缀
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @Override
    public void sayHello() {
        System.out.println("hello jpa ");
    }
}

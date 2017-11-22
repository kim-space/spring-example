package com.kimtd.repository;

import com.kimtd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 继承自jpa实现以及自定义的接口实现，在service层既可以用jpa提供的方法，又能用自定义的实现
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>,EmployeeRepositoryCustom {


    @Modifying
    @Query("update Employee employee set employee.name = :name where employee.id=:id")
    void changeEmployeeInfo(@Param("id") Integer id, @Param("name") String name);

    Employee findByName(String name);

}

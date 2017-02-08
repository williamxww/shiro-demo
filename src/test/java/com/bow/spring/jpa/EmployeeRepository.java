package com.bow.spring.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author vv
 * @since 2017/2/8.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select e from Employee e where e.name = :name")
    Employee findByName(@Param("name")String name);
}

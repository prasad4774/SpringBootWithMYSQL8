package com.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

	public Employee findByName(String name);

}

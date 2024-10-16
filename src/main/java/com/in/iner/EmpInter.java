package com.in.iner;

import java.util.List;

import com.in.entity.Employee;

public interface EmpInter {

	void saveEmp(Employee e);

	public List<Employee> getEmp();

	void deteleEmp(Integer id);

	public Employee updateEmp(String name, Employee emp);

}

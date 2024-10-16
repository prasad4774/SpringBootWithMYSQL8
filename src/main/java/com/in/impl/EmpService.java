package com.in.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.Employee;
import com.in.iner.EmpInter;
import com.in.repo.EmpRepo;

@Service
public class EmpService implements EmpInter {

	@Autowired
	EmpRepo empRepo;

	@Override
	public void saveEmp(Employee e) {

		Optional<Employee> id = empRepo.findById(e.getId());

		if (!id.isPresent()) {
			empRepo.save(e);
		}

		else {
			Employee employee = id.get();
			employee.setName(e.getName());
//			add filed according to requirement
//			setAdr
//			setAge ect....
			empRepo.save(employee);

		}

	}

	@Override
	public List<Employee> getEmp() {

		return empRepo.findAll();
	}

	@Override
	public void deteleEmp(Integer id) {
		empRepo.deleteById(id);

	}

	@Override
	public Employee updateEmp(String name, Employee emp) {
		Employee employee = empRepo.findByName(name);
		employee.setId(emp.getId());
		employee.setName(emp.getName());
		return employee;
	}

}

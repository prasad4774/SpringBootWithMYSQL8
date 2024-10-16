package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Employee;
import com.in.iner.EmpInter;

@RestController
public class Controller {

	@Autowired
	EmpInter empInter;

	@PostMapping("/save")
	public ResponseEntity<?> saveE(@RequestBody Employee e) {

		empInter.saveEmp(e);

		return new ResponseEntity<>("Employee Save", HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<?> get() {

		List<Employee> list = empInter.getEmp();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable("id") Integer id) {

		empInter.deteleEmp(id);

		return new ResponseEntity<>("DELETE EMPLOYEE", HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{name}")
	public ResponseEntity<?> update(@PathVariable("name") String name, @RequestBody Employee emp) {

		Employee employee = empInter.updateEmp(name, emp);

		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}

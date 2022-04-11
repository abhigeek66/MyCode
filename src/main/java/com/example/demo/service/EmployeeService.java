package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.vo.FilterVO;

public interface EmployeeService {

	public List<Employee> findByName(String name);

	public List<Employee> filterEmployee(FilterVO filterVO);

}

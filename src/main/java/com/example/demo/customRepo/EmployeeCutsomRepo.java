package com.example.demo.customRepo;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.vo.FilterVO;

public interface EmployeeCutsomRepo {

	public List<Employee> filterCustomEmployee(FilterVO filterVO);

}

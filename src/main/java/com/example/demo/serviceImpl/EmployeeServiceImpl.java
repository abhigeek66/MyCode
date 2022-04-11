package com.example.demo.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.customRepo.EmployeeCutsomRepo;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.vo.FilterVO;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	//@Autowired
	//private EmployeeCutsomRepo employeeCutsomRepo;

	@Override
	public List<Employee> findByName(String name) {

		return null;
	}

	@Override
	public List<Employee> filterEmployee(FilterVO filterVO) {
		//List<Employee> employees = employeeCutsomRepo.filterCustomEmployee(filterVO);
		Pageable paging = PageRequest.of(filterVO.getPageNo()-1, filterVO.getPageSize(), Sort.by(filterVO.getSortBy()));

		Page<Employee> pagedResult = employeeRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}

}

package com.example.demo.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

public class EmployeeControllerTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@BeforeEach
	public void set() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Rollback(false)
	public void should_search_employee() {
		List<Employee> employee = Arrays.asList(new Employee(2L, "Ram Shah", "Developer"));
		Optional<List<Employee>> employees = Optional.of(employee);
		when(employeeRepository.findByName(anyString())).thenReturn(employees);
	}

	@Test
	@Rollback(false)
	public void should_find_no_employees_if_repository_is_empty() {
		Iterable employees = employeeRepository.findAll();
		assertThat(employees).isEmpty();
	}

	@Test
	@Rollback(false)
	public void should_store_a_employee() {
		Employee emp = new Employee(1L, "Sanjay Shah", "Manager");
		when(employeeRepository.save(any(Employee.class))).thenReturn(emp);
	}

}

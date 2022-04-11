package com.example.demo.customRepoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.customRepo.EmployeeCutsomRepo;
import com.example.demo.model.Employee;
import com.example.demo.vo.FilterVO;

public class EmployeeCutsomRepoImpl implements EmployeeCutsomRepo {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Employee> filterCustomEmployee(FilterVO filterVO) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		final Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

		List<Predicate> criteriaList = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(filterVO.getFirstName())) {

			Predicate predicateSearch = criteriaBuilder.like(
					criteriaBuilder.upper(employeeRoot.get("name").as(String.class)),
					"%" + filterVO.getFirstName() + "%");
			criteriaList.add(predicateSearch);

		}

		criteriaQuery.where(criteriaBuilder.and(criteriaList.toArray(new Predicate[0])));

		final TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

		query.setFirstResult(0);
		query.setMaxResults(10);

		return query.getResultList();

	}

}

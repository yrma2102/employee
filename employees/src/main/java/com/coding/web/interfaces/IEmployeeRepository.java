package com.coding.web.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Employee;


public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	 List<Employee> findByGerente(Optional<Employee> gerente);
	 List<Employee> findAll();
	//List<Employee> findByEmployee(Optional<Employee> gerente);
}

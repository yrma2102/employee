package com.coding.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.interfaces.IEmployeeRepository;
import com.coding.web.models.Employee;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepository emploRepo;
	
	//obtener todos los empleados de un gerente
	public List<Employee> getEmployees(long idGerente){
		Optional<Employee> gerente = emploRepo.findById(idGerente);
		return emploRepo.findByGerente(gerente);
	}
	
	public List<Employee> getAll(){
		return emploRepo.findAll();
	}
	
	public void guardarEmpleado(Employee em) {
		emploRepo.save(em);
	}
	public Optional<Employee> getEmpleado(Long id) {
		return emploRepo.findById(id);
	}

	
}

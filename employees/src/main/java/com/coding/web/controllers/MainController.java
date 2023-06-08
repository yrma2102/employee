package com.coding.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.Employee;
import com.coding.web.services.EmployeeService;

import jakarta.validation.Valid;


@Controller
public class MainController {
	@Autowired
	private EmployeeService emploService;

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("employees", emploService.getAll());
		viewModel.addAttribute("employee", new Employee());
		return "Register.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult resultado, Model viewModel) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("employee", new Employee());
			return "Register.jsp";
		}
		
		emploService.guardarEmpleado(employee);
		
		return "redirect:/detail";
	}
	@GetMapping("/detail")
	public String showAll(Model viewModel) {
		viewModel.addAttribute("employees", emploService.getAll());
		return "Detail.jsp";
	}
	
	@GetMapping("/lista/{idGerente}")
	public String elimianrUsuario(@PathVariable("idGerente") Long idGerente, 
			Model viewModel) {
		Optional<Employee> gerente = emploService.getEmpleado(idGerente);
		viewModel.addAttribute("employees", emploService.getEmployees(idGerente));
		viewModel.addAttribute("gerente", gerente);
		return "Lista_empleados.jsp"; 
	}
}

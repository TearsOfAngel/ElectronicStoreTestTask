package ru.isands.test.estore.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.isands.test.estore.dto.EmployeeDTO;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dto.EmployeeSales;
import ru.isands.test.estore.rest.service.EmployeeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Tag(name = "Employee", description = "Сервис для выполнения операций над сотрудниками магазина")
@Validated
@RequestMapping("/estore/api/employee")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping
	public Page<Employee> getEmployees(@RequestParam(value = "page", defaultValue = "0") Integer page,
									   @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
		return employeeService.getAllEmployees(page, limit);
	}

	@GetMapping("/{id}")
	public EmployeeDTO getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
		EmployeeDTO createdEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,
													  @Valid @RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
		return ResponseEntity.ok(updatedEmployee);
	}
}

package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.EmployeeDTO;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dto.EmployeeSales;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    Page<Employee> getAllEmployees(Integer page, Integer limit);

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}

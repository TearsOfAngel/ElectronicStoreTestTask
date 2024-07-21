package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.test.estore.dao.entity.ElectroEmployee;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dao.repo.ElectroEmployeeRepository;
import ru.isands.test.estore.dao.repo.ElectroTypeRepository;
import ru.isands.test.estore.dao.repo.EmployeeRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class ElectroEmployeeCSVParser implements CSVParserService {

    private final ElectroEmployeeRepository electroEmployeeRepository;
    private final ElectroTypeRepository electronicTypeRepository;
    private final EmployeeRepository employeeRepository;

    public ElectroEmployeeCSVParser(ElectroEmployeeRepository electroEmployeeRepository,
                                    ElectroTypeRepository electronicTypeRepository,
                                    EmployeeRepository employeeRepository) {
        this.electroEmployeeRepository = electroEmployeeRepository;
        this.electronicTypeRepository = electronicTypeRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public void parseAndSave(CSVRecord record) {
        Long employeeId = Long.parseLong(record.get(0));
        Long electronicTypeId = Long.parseLong(record.get(1));


        ElectronicType electronicType = electronicTypeRepository.findById(electronicTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid electronicType ID: " + electronicTypeId));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + employeeId));

        ElectroEmployee electroEmployee = new ElectroEmployee();
        electroEmployee.setElectronicType(electronicType);
        electroEmployee.setEmployee(employee);

        electroEmployeeRepository.save(electroEmployee);
    }
}

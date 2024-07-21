package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;
import ru.isands.test.estore.dao.entity.Employee;

@Getter
@Setter
public class EmployeeSales {
    private Employee employee;
    private Long totalSales;

    public EmployeeSales(Employee employee, Long totalSales) {
        this.employee = employee;
        this.totalSales = totalSales;
    }
}

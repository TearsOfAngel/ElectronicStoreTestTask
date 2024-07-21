package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@IdClass(ElectroEmployeePK.class)
@Entity(name = "electronic_type_employee")
public class ElectroEmployee {

    @Id
    @ManyToOne
    @JoinColumn(name = "electronic_type_id", nullable = false)
    private ElectronicType electronicType;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}

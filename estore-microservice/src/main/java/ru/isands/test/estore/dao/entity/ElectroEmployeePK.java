package ru.isands.test.estore.dao.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class ElectroEmployeePK implements Serializable {

    private Long electronicType;

    private Long employee;

}

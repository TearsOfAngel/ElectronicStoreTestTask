package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class ElectronicTypeDTO {
    @Size(min = 1, max = 150, message = "Type of electronic must be between 1 and 150 characters")
    private String name;
}

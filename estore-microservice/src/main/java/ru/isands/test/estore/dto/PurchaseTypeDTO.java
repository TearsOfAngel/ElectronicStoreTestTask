package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PurchaseTypeDTO {
    @NotNull(message = "Purchase type name cannot be null")
    @Size(min = 1, max = 150, message = "Purchase type name must be between 1 and 150 characters")
    private String name;
}

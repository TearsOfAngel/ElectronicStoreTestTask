package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ElectroItemDTO {
    @NotNull(message = "Name of electronic item cannot be null")
    @Size(min = 1, max = 150, message = "Item name must be between 1 and 150 characters")
    private String name;
    @NotNull(message = "Type of electronic cannot be null")
    private Long electronicTypeId;
    @NotNull(message = "Price cannot be null")
    @Positive
    private Long price;
    @NotNull(message = "Count cannot be null")
    private int count;
    private boolean archive;
    @NotNull(message = "Description cannot be null")
    private String description;
}

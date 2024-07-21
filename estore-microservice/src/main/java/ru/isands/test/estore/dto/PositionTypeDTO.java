package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PositionTypeDTO {
    @NotNull(message = "Position name cannot be null")
    @Size(min = 1, max = 50, message = "Position type name must be between 1 and 50 characters")
    private String name;
}

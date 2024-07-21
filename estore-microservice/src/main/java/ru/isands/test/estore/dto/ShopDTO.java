package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ShopDTO {
    @NotNull(message = "Shop name cannot be null")
    @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
    private String name;
    @NotNull(message = "Shop address cannot be null")
    private String address;
}

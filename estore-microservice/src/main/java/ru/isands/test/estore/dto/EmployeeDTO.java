package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dao.entity.Shop;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {
    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @Size(max = 50, message = "Middle name must be between 1 and 50 characters")
    private String patronymic;

    @Past(message = "Birth date must be a past date")
    private Date birthDate;

    @NotNull(message = "Position ID cannot be null")
    private PositionType positionId;

    @NotNull(message = "Shop ID cannot be null")
    private Shop shopId;

    private boolean gender;
}

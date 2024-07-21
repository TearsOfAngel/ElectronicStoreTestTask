package ru.isands.test.estore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
public class PurchaseDTO {
    @NotNull(message = "Electronic Id cannot be null")
    private Long electroId;
    @NotNull(message = "Employee Id cannot be null")
    private Long employeeId;
    @NotNull(message = "Shop Id cannot be null")
    private Long shopId;
    @PastOrPresent(message = "Purchase date cannot be in the future")
    private Date purchaseDate;
    @NotNull(message = "Id of payment type cannot be null")
    private Long typeId;
}

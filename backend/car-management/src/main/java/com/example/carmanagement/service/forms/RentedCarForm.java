package com.example.carmanagement.service.forms;

import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.domain.valueobjects.CarId;
import com.example.sharedkernel.domain.money.Currency;
import com.example.sharedkernel.domain.user.UserId;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

// klasa so getteri i setteri
@Data
public class RentedCarForm {

    @NotNull
    private CarId carId;

    @NotNull
    private RentedCarId rentedCarId;

    @NotNull
    UserId userId;

    @Min(1)
    private int days;

    @NotNull
    private LocalDateTime from;

    @NotNull
    private LocalDateTime to;

    private Currency currency;
}

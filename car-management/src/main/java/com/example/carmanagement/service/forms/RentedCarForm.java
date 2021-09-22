package com.example.carmanagement.service.forms;

import com.example.carmanagement.domain.valueobjects.Car;
import com.example.carmanagement.domain.valueobjects.User;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

// klasa so getteri i setteri
@Data
public class RentedCarForm {

    @NotNull
    private Car car;

    @NotNull
    User user;

    @Min(1)
    private int days;

    private LocalDateTime from;
    private LocalDateTime to;
}

package com.example.carmanagement.service.forms;

import com.example.carmanagement.domain.valueobjects.User;
import com.example.sharedkernel.domain.financial.Currency;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
public class RentForm {

    @NotNull
    private Currency currency;

    @NotNull
    private User user;

    @Valid
    @NotEmpty
    private List<RentedCarForm> items = new ArrayList<>();
}

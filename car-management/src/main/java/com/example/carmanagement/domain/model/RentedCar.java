package com.example.carmanagement.domain.model;

import com.example.carmanagement.domain.valueobjects.CarId;
import com.example.carmanagement.domain.valueobjects.UserId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "rented_car")
public class RentedCar extends AbstractEntity<RentedCarId> {

    private Money carPrice;

    @Column(name = "dateFrom", nullable = false)
    private LocalDateTime from;

    @Column(name = "dateTo", nullable = false)
    private LocalDateTime to;

//    private int days;

    @AttributeOverride(name="id", column = @Column(name = "car_id", nullable = false))
    private CarId carId;

    @AttributeOverride(name="id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;
}

package com.example.carmanagement.domain.model;

import com.example.carmanagement.domain.valueobjects.CarId;
import com.example.carmanagement.domain.valueobjects.UserId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObject;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "rented_car")
@Getter
public class RentedCar extends AbstractEntity<RentedCarId> {

    private Money carPrice;

    @Column(name = "dateFrom", nullable = false)
    private LocalDateTime from;

    @Column(name = "dateTo", nullable = false)
    private LocalDateTime to;

    private int days;

    @AttributeOverride(name="id", column = @Column(name = "car_id", nullable = false))
    private CarId carId;

    @AttributeOverride(name="id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    public RentedCar(@NonNull CarId carId, @NonNull Money price, @NonNull UserId userId, LocalDateTime from, LocalDateTime to, int days) {
        super(DomainObjectId.randomId(RentedCarId.class));
        this.carId = carId;
        this.carPrice = price;
        this.from = from;
        this.to = to;
        this.userId = userId;
        this.days = days;
    }

    public Money subtotal() {
        return carPrice.multiply(days);
    }
}

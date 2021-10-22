package com.example.carmanagement.domain.model;

import com.example.carmanagement.domain.valueobjects.CarId;
import com.example.carmanagement.domain.valueobjects.RentStatus;
import com.example.carmanagement.domain.valueobjects.ReservationPeriod;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.example.sharedkernel.domain.user.UserId;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rented_car")
@Getter
public class RentedCar extends AbstractEntity<RentedCarId> {

    private Money carPrice;

    private ReservationPeriod reservationPeriod;

    private int days;

    @AttributeOverride(name="id", column = @Column(name = "car_id", nullable = false))
    private CarId carId;

    @AttributeOverride(name="id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    private RentStatus rentStatus;


    public RentedCar(@NonNull CarId carId, @NonNull UserId userId, @NotNull ReservationPeriod reservationPeriod, @NotNull Money carPrice) {
        super(DomainObjectId.randomId(RentedCarId.class));
        this.carId = carId;
        this.reservationPeriod = reservationPeriod;
        this.userId = userId;
        this.days = reservationPeriod.calculateDays();
        this.carPrice = carPrice;
        this.rentStatus = RentStatus.RENTED;

    }

    public void removeRent() {
        rentStatus = RentStatus.DONE;
    }

    public Money subtotal() {
        return carPrice.multiply(days);
    }

}

package com.example.carmanagement.domain.model;

import com.example.carmanagement.domain.valueobjects.UserId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntity<RentId> {

    private LocalDateTime rentTime;
    private Money total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentedCar> rentedCarSet;

    @AttributeOverride(name="id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    public Rent() {}
}

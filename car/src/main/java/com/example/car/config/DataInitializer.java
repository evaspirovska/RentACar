package com.example.car.config;

import com.example.car.domain.models.Car;
import com.example.car.domain.repository.CarRepository;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final CarRepository carRepository;

    @PostConstruct
    public void initData() {
        Car car1 = Car.build("car 1", "description 1", "location 1",   Money.valueOf(Currency.MKD, 2000.0));
        Car car2 = Car.build("car 2", "description 2", "location 2", Money.valueOf(Currency.MKD, 3000.0));
        if(carRepository.findAll().isEmpty()) {
            List<Car> lista = new ArrayList<>();
            carRepository.saveAll(Arrays.asList(car1, car2));
        }
    }
}

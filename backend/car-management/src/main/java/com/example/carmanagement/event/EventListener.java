package com.example.carmanagement.event;

import com.example.carmanagement.service.RentService;
import org.springframework.stereotype.Service;

@Service
public class EventListener {

    private final RentService rentService;

    public EventListener(RentService rentService) {
        this.rentService = rentService;
    }


}

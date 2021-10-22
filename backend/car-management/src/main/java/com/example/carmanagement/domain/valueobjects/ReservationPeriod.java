package com.example.carmanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import org.apache.tomcat.jni.Local;
import java.time.temporal.ChronoUnit;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Embeddable
@Getter
public class ReservationPeriod implements ValueObject {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public ReservationPeriod() {
        start = null;
        end = null;
    }

    public ReservationPeriod(LocalDateTime start, LocalDateTime end) {

        if (start.isAfter(end))
            throw new IllegalArgumentException("end date is before start date");

        this.start = start;
        this.end = end;
    }

    public int calculateDays() {

        return (int)start.until(end, ChronoUnit.DAYS);
    }
}

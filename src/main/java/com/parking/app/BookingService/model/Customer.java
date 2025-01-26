package com.parking.app.BookingService.model;

import com.parking.app.BookingService.entity.Booking;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;

    @Transient
    private Booking booking;
}

package com.parking.app.BookingService.service;

import com.parking.app.BookingService.entity.Booking;
import com.parking.app.BookingService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingService {

    public List<Booking> listAllBooking();
    public Booking getBooking(Long id);
    public Booking createBooking(Booking booking);
    public Booking updateBooking(Booking booking);
    public  void deleteBooking(Long id);
    public List<Booking> findByCustomerId(Long customerId);
}

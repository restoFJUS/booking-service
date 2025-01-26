package com.parking.app.BookingService.service;

import com.parking.app.BookingService.entity.Booking;

import java.util.List;

public interface BookingService {

    public Booking createBooking(Booking booking);
    public List<Booking> getAllBookings();
    public Booking getBooking(Long id);
    public Booking updateBooking(Booking booking);
    public  void deleteBooking(Long id);
    public List<Booking> findByClientId(Long clientId);
    public List<Booking> findByRestaurantId(Long restaurantId);
}

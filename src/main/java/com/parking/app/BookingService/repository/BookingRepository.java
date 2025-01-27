package com.parking.app.BookingService.repository;

import com.parking.app.BookingService.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM tbl_booking b WHERE b.booking_client_id = :clientId" , nativeQuery = true)
    public List<Booking> getBookingByClient(Long clientId);

    @Query(value = "SELECT * FROM tbl_booking b WHERE b.booking_restaurant_id = :restaurantId" , nativeQuery = true)
    public List<Booking> getBookingByRestaurant(Long restaurantId);
}

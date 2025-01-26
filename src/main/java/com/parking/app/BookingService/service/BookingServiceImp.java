package com.parking.app.BookingService.service;

import com.parking.app.BookingService.entity.Booking;
import com.parking.app.BookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }


    @Override
    public Booking updateBooking(Booking booking) {
        Booking bookingDB = getBooking(booking.getId());
        if (null == bookingDB){
            return null;
        }
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking bookingDB = getBooking(id);
        if (null != bookingDB){
            bookingRepository.delete(bookingDB);
        }
    }

    @Override
    public List<Booking> findByClientId(Long clientId) {
        return bookingRepository.getBookingByClient(clientId);
    }

    @Override
    public  List<Booking> findByRestaurantId(Long restaurantId){
        return bookingRepository.getBookingByRestaurant(restaurantId);
    }


}

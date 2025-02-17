package com.parking.app.BookingService.controller;


import com.parking.app.BookingService.entity.Booking;
import com.parking.app.BookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //--> ABM de Reservas
    //--> POSTs
    @PostMapping("/create-booking")
    public ResponseEntity<Booking> createBooking( @RequestBody Booking booking){
        Booking bookingCreated =  bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingCreated);
    }

    //--> GETs
    @GetMapping("/get-all-bookings")
    public ResponseEntity<List<Booking>> getListBooking(){
        List<Booking> booking = new ArrayList<>();
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping(value = "/get-booking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
        Booking booking =  bookingService.getBooking(id);
        if (null==booking){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping( "/search-by-client/{clientId}")
    public ResponseEntity<List<Booking>> findByClientId(@PathVariable Long clientId){
        List<Booking> resultado = bookingService.findByClientId(clientId);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping( "/search-by-restaurant/{restaurantId}")
    public ResponseEntity<List<Booking>> findByRestaurantId(@PathVariable Long restaurantId){
        List<Booking> resultado = bookingService.findByRestaurantId(restaurantId);
        return ResponseEntity.ok(resultado);
    }


    //--> PUTs
    @PutMapping("/update-booking")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        Booking bookingUpdated =  bookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookingUpdated);
    }

    //--> DELETEs
    @DeleteMapping("/delete-booking/{bookingId}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok().body(bookingService.getBooking(bookingId));
    }


}

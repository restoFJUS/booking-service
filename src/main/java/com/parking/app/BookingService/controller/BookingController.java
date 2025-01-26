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

    @GetMapping
    public ResponseEntity<List<Booking>> getListBooking(){
        List<Booking> booking = new ArrayList<>();
        return ResponseEntity.ok(bookingService.listAllBooking());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
        Booking booking =  bookingService.getBooking(id);
        if (null==booking){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking( @RequestBody Booking booking){
        Booking bookingCreated =  bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingCreated);
    }

    @GetMapping( "/search-by-customer/{idCustomer}")
    public ResponseEntity<List<Booking>> findByCustomerId(@PathVariable Long idCustomer){
        List<Booking> resultado = bookingService.findByCustomerId(idCustomer);
        return ResponseEntity.ok(resultado);

    }
}

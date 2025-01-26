package com.parking.app.BookingService.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_Booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long garageId;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaateDate;

    @Column(name = "reservation_date")
    @Temporal(TemporalType.TIMESTAMP)//fecha y hora
    private Date reservationDate;

}

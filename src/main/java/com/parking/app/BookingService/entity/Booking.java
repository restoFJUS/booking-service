package com.parking.app.BookingService.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_Booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_client_id", nullable = false)
    private Long clientId;

    @Column(name = "booking_restaurant_id", nullable = false)
    private Long restaurantId;

    @Column(name = "people_number", nullable = false)
    private Short peopleNumber;

    //--> COLUMN DEFINITION = DATE, idem que el TIME, para guardado de base de datos
    //--> LocalDATE para que solo almacene los 10 dígitos necesarios y para los cálculos de fechas tiene muchas opciones
    @Column(name = "reservation_date", nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate reservationDate;

    //--> SE deja el columnDefinition TIME para que en la base solo se guarde el formato HH:MM:SS
    //--> SE deja el private TIME para poder realizar cálculos de horas de una manera más fácil. java.sql.Time
    @Column(name = "reservation_hour", nullable = false, columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Time reservationHour;

    //--> IDEM Para la fecha
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column (name = "creation_user")
    private String creationUser;

    @Column (name = "modification_date")
    private Date modificationDate;

    @Column (name = "modification_user")
    private String modificationUser;

    @Column (name = "leaving_date")
    private Date leavingDate;

    @Column (name = "leaving_user")
    private String leavingUser;

}

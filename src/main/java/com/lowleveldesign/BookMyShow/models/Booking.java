package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    @JoinColumn(name = "bookingId")
    private List<Payment> payments;

    @OneToMany
    @JoinColumn(name = "bookingId")
    private List<ShowSeat> showSeats;

    private Date booked_at;

}

/*
Booking : User (M:1)
Booking : ShowSeat (1:M)
Booking : payments (1:M)

We have to only define cardinality between non-primitive attributes
 */

package com.lowleveldesign.BookMyShow.controllers;

import com.lowleveldesign.BookMyShow.dtos.CreateBookingRequestDto;
import com.lowleveldesign.BookMyShow.dtos.CreateBookingResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto){
        return null;
    }
}

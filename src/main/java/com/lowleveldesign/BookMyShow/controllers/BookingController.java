package com.lowleveldesign.BookMyShow.controllers;

import com.lowleveldesign.BookMyShow.dtos.CreateBookingRequestDto;
import com.lowleveldesign.BookMyShow.dtos.CreateBookingResponseDto;
import com.lowleveldesign.BookMyShow.dtos.ResponseStatus;
import com.lowleveldesign.BookMyShow.exceptions.ShowSeatNotFoundException;
import com.lowleveldesign.BookMyShow.exceptions.UserNotFoundException;
import com.lowleveldesign.BookMyShow.models.Booking;
import com.lowleveldesign.BookMyShow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) throws UserNotFoundException, ShowSeatNotFoundException {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();
        Booking booking = null;

        booking = bookingService.createBooking(requestDto.getShowSeatIds(), requestDto.getUserId());

        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESSFUL);

        if(booking == null){
            responseDto.setResponseStatus(ResponseStatus.FAILED);
        }

        return  responseDto;
    }
}

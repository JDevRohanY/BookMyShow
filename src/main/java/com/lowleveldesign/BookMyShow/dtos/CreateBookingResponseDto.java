package com.lowleveldesign.BookMyShow.dtos;

import com.lowleveldesign.BookMyShow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}

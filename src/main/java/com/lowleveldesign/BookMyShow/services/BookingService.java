package com.lowleveldesign.BookMyShow.services;

import com.lowleveldesign.BookMyShow.exceptions.ShowSeatNotFoundException;
import com.lowleveldesign.BookMyShow.exceptions.UserNotFoundException;
import com.lowleveldesign.BookMyShow.models.*;
import com.lowleveldesign.BookMyShow.repositories.BookingRepository;
import com.lowleveldesign.BookMyShow.repositories.ShowSeatRepository;
import com.lowleveldesign.BookMyShow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    public Booking createBooking(List<Long> showSeatIds, Long userId) throws UserNotFoundException, ShowSeatNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with Id : " + userId + " not found.");
        }

        User user = optionalUser.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotFoundException("ShowSeat with showId: " + showSeat.getShow().getId() +
                        " and seatId: " + showSeat.getSeat().getId() + " isn't available.");
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(priceCalculatorService.calculatePrice(savedShowSeats));

        return bookingRepository.save(booking);
    }
}

/*
        1. Fetch the user from userId.
        2. if user not found, then throw an exception.
        3. Fetch the ShowSeat objects from the Database.
        4. Check if showSeats are available.
        5. If NOT, throw an exception.
        ----------------TAKE A LOCK---------------
        6. Check the showSeat status again.
        7. Change the showSeat status to BLOCKED.
        ----------------RELEASE THE LOCK-----------
        8. Create the booking with PENDING status.
        9. Move to the payment page.
*/

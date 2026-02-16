package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private ShowSeatStatus showSeatStatus;
}

/*
ShowSeat : Show (M:1)
ShowSeat : Seat (M:1) (One seat can belong to multiple shows)

 */
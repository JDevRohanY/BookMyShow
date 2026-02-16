package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*
ShowSeat : Show (M:1)
ShowSeat : Seat (M:1) (One seat can belong to multiple shows)

 */
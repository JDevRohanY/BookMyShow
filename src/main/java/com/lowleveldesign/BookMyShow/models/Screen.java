package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @OneToMany
    @JoinColumn(name = "screenId")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;
}

/*
Screen : Seat (1:M)
 */

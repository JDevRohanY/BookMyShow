package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    private List<Feature> features;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;
}

/*
Screen : Seat (1:M)
 */

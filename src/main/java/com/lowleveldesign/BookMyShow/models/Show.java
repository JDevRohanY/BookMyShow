package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;
    private List<Feature> features;
}

/*
Show : Movie (M:1)
Show : Screen (M:1)
 */

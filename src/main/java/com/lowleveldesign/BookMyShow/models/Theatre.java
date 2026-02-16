package com.lowleveldesign.BookMyShow.models;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private String address;

    @OneToMany
    private List<Screen> screens;
}

/*
Theatre -- screen (1:M)
 */
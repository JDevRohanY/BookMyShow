package com.lowleveldesign.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private String address;
    private List<Screen> screens;
}

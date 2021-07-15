package com.alexanhb.footballmanagement.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "stadiums")
public class Stadium extends BaseEntity{

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column(name = "stadium_capacity")
    private int capacity;

    @Column(name = "stadium_location")
    private String location;

    @Column(name = "stadium_fieldsize")
    private String fieldSize;

    public Stadium(String stadiumName, int capacity, String location, String fieldSize) {
        this.stadiumName = stadiumName;
        this.capacity = capacity;
        this.location = location;
        this.fieldSize = fieldSize;
    }

    @OneToOne
    private Club club;

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(String fieldSize) {
        this.fieldSize = fieldSize;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
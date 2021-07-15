package com.alexanhb.footballmanagement.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player extends Person{

    @Column(name = "position")
    private String position;

    @OneToOne
    private Club club;

    @Column(name = "shirtnumber")
    private int shirtNumber;

    public Player(String firstName, String lastName, LocalDate birthDate, String position, int shirtNumber) {
        super(firstName, lastName, birthDate);
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    public Player(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }
}

package com.alexanhb.footballmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player extends Person{

    public Player(Long id, String firstName, String lastName, LocalDate birthDate, String position, Club club, int shirtNumber) {
        super(id, firstName, lastName, birthDate);
        this.position = position;
        this.club = club;
        this.shirtNumber = shirtNumber;
    }

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(name = "shirtnumber")
    private int shirtNumber;


    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}

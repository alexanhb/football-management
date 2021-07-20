package com.alexanhb.footballmanagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "managers")
public class Manager extends Person{

    //VET

    @Builder
    public Manager(Long id, String firstName, String lastName, LocalDate birthDate, Club club) {
        super(id, firstName, lastName, birthDate);
        this.club = club;
    }

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;
}

package com.alexanhb.footballmanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "managers")
public class Manager extends Person{

    @Builder
    public Manager(Long id, String firstName, String lastName, String birthDate, Club club) {
        super(id, firstName, lastName, birthDate);
        this.club = club;
    }

    @OneToOne(mappedBy = "manager")
    private Club club;

    @Column(nullable = false)
    private String managerImg;


    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}

package com.alexanhb.footballmanagement.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stadiums")
public class Stadium extends BaseEntity{

    //VISIT

    @Builder
    public Stadium(Long id, String stadiumName, int capacity, String location, String fieldSize, Club club) {
        super(id);
        this.stadiumName = stadiumName;
        this.capacity = capacity;
        this.location = location;
        this.fieldSize = fieldSize;
        this.club = club;
    }


    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "stadium_capacity", nullable = false)
    private int capacity;

    @Column(name = "stadium_location", nullable = false)
    private String location;

    @Column(name = "stadium_fieldsize", nullable = false)
    private String fieldSize;

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(nullable = false)
    private String stadiumImage;



    @Override
    public String toString() {
        return stadiumName;
    }
}
package com.alexanhb.footballmanagement.model;

import com.alexanhb.footballmanagement.services.LeagueService;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "leagues")
public class League extends BaseEntity{

    @Builder
    public League(Long id, String leagueName, String country, Set<Club> clubs, int numberOfTeams, String websiteUrl) {
        super(id);
        this.leagueName = leagueName;
        this.country = country;
        this.clubs = clubs;
        this.numberOfTeams = numberOfTeams;
        this.websiteUrl = websiteUrl;
    }

    @Column(name = "league_name")
    private String leagueName;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "league")
    private Set<Club> clubs = new HashSet<>();

    @Column(name = "numberofteams")
    private int numberOfTeams;

    @Column(name = "websiteurl")
    private String websiteUrl;
}

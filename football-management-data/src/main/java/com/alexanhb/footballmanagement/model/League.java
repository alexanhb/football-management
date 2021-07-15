package com.alexanhb.footballmanagement.model;

import com.alexanhb.footballmanagement.services.LeagueService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "leagues")
public class League extends BaseEntity{

    @Column(name = "league_name")
    private String leagueName;
    @Column(name = "country")
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private Set<Club> clubs = new HashSet<>();

    @Column(name = "numberofteams")
    private int numberOfTeams;

    @Column(name = "websiteurl")
    private String websiteUrl;


    public League(String leagueName, String country, Set<Club> clubs, int numberOfTeams, String websiteUrl) {
        this.leagueName = leagueName;
        this.country = country;
        this.clubs = clubs;
        this.numberOfTeams = numberOfTeams;
        this.websiteUrl = websiteUrl;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}

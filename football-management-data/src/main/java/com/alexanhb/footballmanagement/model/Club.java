package com.alexanhb.footballmanagement.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clubs")
public class Club extends BaseEntity{

    @Column(name = "club_name")
    private String clubName;

    @OneToOne(cascade = CascadeType.ALL)
    private Stadium stadium;

    @OneToOne(cascade = CascadeType.ALL)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Set<Player> squad = new HashSet<>();

    public Club(String clubName, Stadium stadium, Manager manager, Set<Player> squad) {
        this.clubName = clubName;
        this.stadium = stadium;
        this.manager = manager;
        this.squad = squad;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Set<Player> getSquad() {
        return squad;
    }

    public void setSquad(Set<Player> squad) {
        this.squad = squad;
    }
}

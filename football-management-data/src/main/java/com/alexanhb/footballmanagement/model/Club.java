package com.alexanhb.footballmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Club extends BaseEntity{

    @Builder
    public Club(Long id, String clubName, Stadium stadium, Manager manager, Set<Player> squad) {
        super(id);
        this.clubName = clubName;
        this.stadium = stadium;
        this.manager = manager;
        this.squad = squad;
    }

    //OWNER

    @Column(name = "club_name")
    private String clubName;

    @OneToOne
    private Stadium stadium;

    @OneToOne
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "club")
    private Set<Player> squad = new HashSet<>();
}

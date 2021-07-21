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

    @Column(name = "club_name")
    private String clubName;

    @OneToOne
    private Stadium stadium;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "club")
    private Set<Player> squad = new HashSet<>();

    private String clubLogo;

    @Override
    public String toString() {
        return clubName + " " + stadium + " " + manager + " " + " " + squad;
    }
}

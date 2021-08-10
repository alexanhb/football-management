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
public class Club extends BaseEntity implements Comparable<Club>{

    @Builder
    public Club(Long id, String clubName, String clubColor, Set<Player> squad) {
        super(id);
        this.clubName = clubName;
        this.clubColor = clubColor;

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

    @Column(nullable = false)
    private String clubLogo;

    @Column(nullable = false)
    private String clubColor;


    public Manager getManager(String name) {
        return getManager(name, false);
    }

    public Manager getManager(String name, boolean ignoreNew) {
        name = name.toLowerCase();
            if (!ignoreNew || !manager.isNew()) {
                String compName = manager.getFirstName() + manager.getLastName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return manager;
                }
            }
        return null;
    }


    public Stadium getStadium(String name) {
        return getStadium(name, false);
    }

    public Stadium getStadium(String name, boolean ignoreNew) {
        name = name.toLowerCase();
            if (!ignoreNew || !stadium.isNew()) {
                String compName = stadium.getStadiumName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return stadium;
                }
            }
        return null;
    }



    @Override
    public String toString() {
        return clubName + " " + stadium + " " + manager + " " + " " + squad;
    }

    @Override
    public int compareTo(Club o) {
        return this.clubName.compareTo(o.getClubName());
    }
}

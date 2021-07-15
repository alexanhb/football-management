package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByLastName(String lastName);

    Set<Player> findAllByLastNameLike(String lastName);
}

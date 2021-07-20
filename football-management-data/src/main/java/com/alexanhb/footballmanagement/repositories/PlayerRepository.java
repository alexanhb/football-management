package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByLastName(String lastName);

    List<Player> findAllByLastNameLike(String lastName);
}

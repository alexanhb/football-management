package com.alexanhb.footballmanagement.services;

import com.alexanhb.footballmanagement.model.Player;

import java.util.List;
import java.util.Set;

public interface PlayerService extends CrudService<Player, Long>{

    Player findByLastName(String lastName);

    List<Player> findAllByLastNameLike(String lastName);
}

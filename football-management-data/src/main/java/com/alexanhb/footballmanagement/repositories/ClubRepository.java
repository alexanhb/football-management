package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.Club;
import com.alexanhb.footballmanagement.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClubRepository extends CrudRepository<Club, Long> {

    Club findByClubName(String clubName);

    List<Club> findAllByClubNameLike(String clubName);
}

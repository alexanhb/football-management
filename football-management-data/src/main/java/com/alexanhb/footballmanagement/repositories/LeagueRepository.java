package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League, Long> {
}


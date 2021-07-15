package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.Club;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long> {
}

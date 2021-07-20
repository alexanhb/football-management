package com.alexanhb.footballmanagement.services;

import com.alexanhb.footballmanagement.model.Club;

import java.util.List;

public interface ClubService extends CrudService<Club, Long>{

    Club findByClubName(String clubName);

    List<Club> findAllByClubNameLike(String clubName);
}

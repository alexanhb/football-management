package com.alexanhb.footballmanagement.services.springdatajpa;

import com.alexanhb.footballmanagement.model.Club;
import com.alexanhb.footballmanagement.model.Player;
import com.alexanhb.footballmanagement.repositories.ClubRepository;
import com.alexanhb.footballmanagement.services.ClubService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ClubSDJpaService implements ClubService {

    private final ClubRepository clubRepository;

    public ClubSDJpaService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Set<Club> findAll() {
        Set<Club> clubs = new HashSet<>();
        clubRepository.findAll().forEach(clubs::add);
        return clubs;
    }

    @Override
    public Club findById(Long aLong) {
        return clubRepository.findById(aLong).orElse(null);
    }

    @Override
    public Club findByClubName(String clubName) {
        return clubRepository.findByClubName(clubName);
    }

    @Override
    public List<Club> findAllByClubNameLike(String clubName) {
        return clubRepository.findAllByClubNameLike(clubName);
    }


    @Override
    public Club save(Club object) {
        return clubRepository.save(object);
    }

    @Override
    public void delete(Club object) {
        clubRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        clubRepository.deleteById(aLong);
    }
}

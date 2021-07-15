package com.alexanhb.footballmanagement.services.springdatajpa;

import com.alexanhb.footballmanagement.model.League;
import com.alexanhb.footballmanagement.repositories.LeagueRepository;
import com.alexanhb.footballmanagement.services.LeagueService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class LeagueSDJpaService implements LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueSDJpaService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Set<League> findAll() {
        Set<League> leagues = new HashSet<>();
        leagueRepository.findAll().forEach(leagues::add);
        return leagues;
    }

    @Override
    public League findById(Long aLong) {
        return leagueRepository.findById(aLong).orElse(null);
    }

    @Override
    public League save(League object) {
        return leagueRepository.save(object);
    }

    @Override
    public void delete(League object) {
        leagueRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        leagueRepository.deleteById(aLong);
    }
}
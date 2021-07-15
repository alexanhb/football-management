package com.alexanhb.footballmanagement.services.springdatajpa;

import com.alexanhb.footballmanagement.model.Stadium;
import com.alexanhb.footballmanagement.repositories.StadiumRepository;
import com.alexanhb.footballmanagement.services.StadiumService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class StadiumSDJpaService implements StadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumSDJpaService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public Set<Stadium> findAll() {
        Set<Stadium> stadiums = new HashSet<>();
        stadiumRepository.findAll().forEach(stadiums::add);
        return stadiums;
    }

    @Override
    public Stadium findById(Long aLong) {
        return stadiumRepository.findById(aLong).orElse(null);
    }

    @Override
    public Stadium save(Stadium object) {
        return stadiumRepository.save(object);
    }

    @Override
    public void delete(Stadium object) {
        stadiumRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        stadiumRepository.deleteById(aLong);
    }
}
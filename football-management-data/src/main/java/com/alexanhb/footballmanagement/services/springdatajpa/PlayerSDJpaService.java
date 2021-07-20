package com.alexanhb.footballmanagement.services.springdatajpa;

import com.alexanhb.footballmanagement.model.Player;
import com.alexanhb.footballmanagement.repositories.PlayerRepository;
import com.alexanhb.footballmanagement.services.PlayerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PlayerSDJpaService implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerSDJpaService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findByLastName(String lastName) {
        return playerRepository.findByLastName(lastName);
    }

    @Override
    public List<Player> findAllByLastNameLike(String lastName) {
        return playerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Player> findAll() {
        Set<Player> players = new HashSet<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    @Override
    public Player findById(Long aLong) {
        return playerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Player save(Player object) {
        return playerRepository.save(object);
    }

    @Override
    public void delete(Player object) {
        playerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        playerRepository.deleteById(aLong);
    }
}

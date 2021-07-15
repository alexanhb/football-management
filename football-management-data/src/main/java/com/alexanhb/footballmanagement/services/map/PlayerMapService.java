package com.alexanhb.footballmanagement.services.map;

import com.alexanhb.footballmanagement.model.Player;
import com.alexanhb.footballmanagement.services.ClubService;
import com.alexanhb.footballmanagement.services.PlayerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PlayerMapService extends AbstractMapService<Player, Long> implements PlayerService {

    private final ClubService clubService;

    public PlayerMapService(ClubService clubService) {
        this.clubService = clubService;
    }

    @Override
    public Set<Player> findAll() {
        return super.findAll();
    }

    @Override
    public Player findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Player findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(player -> player.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Player> findAllByLastNameLike(String lastName) {
        return null;
    }

    @Override
    public Player save(Player object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Player object) {
        super.delete(object);
    }
}

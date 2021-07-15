package com.alexanhb.footballmanagement.services.map;

import com.alexanhb.footballmanagement.model.League;
import com.alexanhb.footballmanagement.services.LeagueService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class LeagueMapService extends AbstractMapService<League, Long> implements LeagueService {
    @Override
    public Set<League> findAll() {
        return super.findAll();
    }

    @Override
    public League findById(Long id) {
        return super.findById(id);
    }

    @Override
    public League save(League object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(League object) {
        super.delete(object);
    }
}

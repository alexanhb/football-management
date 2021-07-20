package com.alexanhb.footballmanagement.services.map;

import com.alexanhb.footballmanagement.model.Club;
import com.alexanhb.footballmanagement.services.ClubService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class ClubMapService extends AbstractMapService<Club, Long> implements ClubService {
    @Override
    public Set<Club> findAll() {
        return super.findAll();
    }

    @Override
    public Club findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Club findByClubName(String clubName) {
        return this.findAll()
                .stream()
                .filter(club -> club.getClubName().equalsIgnoreCase(clubName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Club> findAllByClubNameLike(String clubName) {
        return null;
    }

    @Override
    public Club save(Club object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Club object) {
        super.delete(object);
    }
}

package com.alexanhb.footballmanagement.services.map;

import com.alexanhb.footballmanagement.model.Stadium;
import com.alexanhb.footballmanagement.services.StadiumService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class StadiumMapService extends AbstractMapService<Stadium, Long> implements StadiumService {
    @Override
    public Set<Stadium> findAll() {
        return super.findAll();
    }

    @Override
    public Stadium findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Stadium save(Stadium object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Stadium object) {
        super.delete(object);
    }
}

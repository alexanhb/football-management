package com.alexanhb.footballmanagement.services.map;

import com.alexanhb.footballmanagement.model.Manager;
import com.alexanhb.footballmanagement.services.ManagerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class ManagerMapService extends AbstractMapService<Manager, Long> implements ManagerService {
    @Override
    public Set<Manager> findAll() {
        return super.findAll();
    }

    @Override
    public Manager findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Manager save(Manager object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Manager object) {

    }
}

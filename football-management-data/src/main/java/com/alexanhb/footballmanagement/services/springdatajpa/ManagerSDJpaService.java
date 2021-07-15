package com.alexanhb.footballmanagement.services.springdatajpa;

import com.alexanhb.footballmanagement.model.Manager;
import com.alexanhb.footballmanagement.repositories.ManagerRepository;
import com.alexanhb.footballmanagement.services.ManagerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ManagerSDJpaService implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerSDJpaService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Set<Manager> findAll() {
        Set<Manager> managers = new HashSet<>();
        managerRepository.findAll().forEach(managers::add);
        return managers;
    }

    @Override
    public Manager findById(Long aLong) {
        return managerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Manager save(Manager object) {
        return managerRepository.save(object);
    }

    @Override
    public void delete(Manager object) {
        managerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        managerRepository.deleteById(aLong);
    }
}

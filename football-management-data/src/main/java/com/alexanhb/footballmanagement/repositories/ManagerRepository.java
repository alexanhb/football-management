package com.alexanhb.footballmanagement.repositories;

import com.alexanhb.footballmanagement.model.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
}

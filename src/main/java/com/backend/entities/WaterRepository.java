package com.backend.entities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by masc on 02.12.2016.
 */

public interface WaterRepository extends Repository <WaterEntity, String> {
    Page<Repository> findAll(Pageable pageable);
}

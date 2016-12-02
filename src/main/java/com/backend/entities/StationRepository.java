package com.backend.entities;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;


public interface StationRepository extends CrudRepository<StationEntity, String> {
    Page<Repository> findAll(Pageable pageable);
}

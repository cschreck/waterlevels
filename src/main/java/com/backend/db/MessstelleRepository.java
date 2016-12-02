package com.backend.db;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface MessstelleRepository extends CrudRepository<Messstelle, String> {

    Page<Repository> findAll(Pageable pageable);

}

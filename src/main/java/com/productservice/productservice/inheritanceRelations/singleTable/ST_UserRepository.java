package com.productservice.productservice.inheritanceRelations.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ST_UserRepository")
public interface ST_UserRepository extends JpaRepository<User,Long> {

    @Override
    User save(User user);
}

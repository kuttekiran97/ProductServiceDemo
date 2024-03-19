package com.productservice.productservice.inheritanceRelations.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TBC_UserRepository")
public interface TBC_UserRepository extends JpaRepository<User,Long> {

    @Override
    User save(User user);
}

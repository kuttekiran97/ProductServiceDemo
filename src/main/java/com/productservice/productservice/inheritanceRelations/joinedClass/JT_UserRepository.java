package com.productservice.productservice.inheritanceRelations.joinedClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("JT_UserRepository")
public interface JT_UserRepository extends JpaRepository<User,Long> {

    @Override
    User save(User user);
}

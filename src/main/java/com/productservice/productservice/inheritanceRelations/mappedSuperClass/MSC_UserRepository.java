package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("msc_UserRepository")
public interface MSC_UserRepository extends JpaRepository<User,Long> {

    @Override
    User save( User user);
}

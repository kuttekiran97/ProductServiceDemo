package com.productservice.productservice.inheritanceRelations.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ST_mentorRepository")
public interface ST_MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    Mentor save(Mentor mentor);
}

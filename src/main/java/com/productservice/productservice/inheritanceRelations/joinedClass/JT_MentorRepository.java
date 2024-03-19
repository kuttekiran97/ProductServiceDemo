package com.productservice.productservice.inheritanceRelations.joinedClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("JT_mentorRepository")
public interface JT_MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    Mentor save(Mentor mentor);
}

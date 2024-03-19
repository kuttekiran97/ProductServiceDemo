package com.productservice.productservice.inheritanceRelations.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TBC_mentorRepository")
public interface TBC_MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    Mentor save(Mentor mentor);
}

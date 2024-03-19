package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.events.Event;

@Repository("msc_mentorRepository")
public interface MSC_MentorRepository extends JpaRepository<Mentor,Long> {

    @Override
    Mentor save(Mentor mentor);
}

package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("msc_StudentRepository")
public interface MSC_StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}

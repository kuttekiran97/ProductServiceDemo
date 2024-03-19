package com.productservice.productservice.inheritanceRelations.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ST_StudentRepository")
public interface ST_StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}

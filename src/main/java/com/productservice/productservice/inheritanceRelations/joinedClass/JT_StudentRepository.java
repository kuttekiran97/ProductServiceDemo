package com.productservice.productservice.inheritanceRelations.joinedClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("JT_StudentRepository")
public interface JT_StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}

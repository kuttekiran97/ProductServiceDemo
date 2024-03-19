package com.productservice.productservice.inheritanceRelations.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TBC_StudentRepository")
public interface TBC_StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}

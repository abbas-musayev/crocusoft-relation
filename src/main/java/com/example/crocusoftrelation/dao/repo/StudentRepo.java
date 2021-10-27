package com.example.crocusoftrelation.dao.repo;

import com.example.crocusoftrelation.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("select s from Student s join fetch s.courses c where c.id=:id")
    List<Student> findStudentsByCourseId(@Param("id") Long id);
}

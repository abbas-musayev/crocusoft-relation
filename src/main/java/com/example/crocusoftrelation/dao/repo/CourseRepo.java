package com.example.crocusoftrelation.dao.repo;

import com.example.crocusoftrelation.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
}

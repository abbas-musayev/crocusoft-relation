package com.example.crocusoftrelation.dao.repo;

import com.example.crocusoftrelation.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}

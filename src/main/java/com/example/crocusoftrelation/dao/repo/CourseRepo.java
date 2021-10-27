package com.example.crocusoftrelation.dao.repo;

import com.example.crocusoftrelation.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {

    @Query("select c from Course c join fetch c.students s where s.id=:id")
    List<Course> findCoursesByStudentId(@Param("id") Long id);
}

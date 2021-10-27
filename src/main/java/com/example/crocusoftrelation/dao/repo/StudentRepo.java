package com.example.crocusoftrelation.dao.repo;

import com.example.crocusoftrelation.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}

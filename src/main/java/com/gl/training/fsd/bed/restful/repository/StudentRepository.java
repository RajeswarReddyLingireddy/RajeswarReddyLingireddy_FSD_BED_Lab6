package com.gl.training.fsd.bed.restful.repository;

import com.gl.training.fsd.bed.restful.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

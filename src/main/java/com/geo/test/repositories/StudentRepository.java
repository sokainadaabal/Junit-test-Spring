package com.geo.test.repositories;

import com.geo.test.entites.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDto,Long> {
}

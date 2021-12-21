package com.example.student.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.Dto.StudentDto;
import com.example.student.Model.Student;



public interface StudentRepository extends JpaRepository<Student, Long>  {
	
    @Query(nativeQuery = true)
    List<StudentDto> getOnlyStudentInfo();
    
   
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO students(name,age) VALUE(?1,?2)" ,nativeQuery = true)
    void addStudentData(String name,int age);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET name = ?, age =? WHERE id = ? ", nativeQuery = true)
    void updateStudentData(String name, int age, Long id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM students WHERE id = ? ", nativeQuery = true)
    void deleteStudentData(Long id);
      
}

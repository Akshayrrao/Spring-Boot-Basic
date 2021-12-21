package com.example.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.student.Dto.SubjectDto;
import com.example.student.Model.Subject;



public interface SubjectRepository extends JpaRepository <Subject, Long>{
	
	List<Subject> findByStudentId(Long studentId);
	
	@Query(nativeQuery = true)
    List<SubjectDto> getOnlySubjectInfo();

}

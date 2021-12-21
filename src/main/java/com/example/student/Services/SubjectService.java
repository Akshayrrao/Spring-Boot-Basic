package com.example.student.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.student.Dto.SubjectDto;
import com.example.student.Exception.NotFoundException;
import com.example.student.Model.Subject;
import com.example.student.Repository.StudentRepository;
import com.example.student.Repository.SubjectRepository;



@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
    // Get Student address Details using jpa.
    public List<Subject> getContactByStudentId(Long studentId) {
    	
        if(!studentRepository.existsById(studentId)) {
            throw new NotFoundException("Student not found!");
        }
    	
    	return subjectRepository.findByStudentId(studentId);
    }
    
    //Add student Address Details
    public Subject addSubject(Long studentId,Subject subject) {
        return studentRepository.findById(studentId)
                .map(student -> {
                    subject.setStudent(student);
                    return subjectRepository.save(subject);
                }).orElseThrow(() -> new NotFoundException("Student not found!"));
    }
    
    //Update student subject Details using Jpa
    public Subject updateSubject(Long studentId,Long subjectId,Subject subjectUpdated) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return subjectRepository.findById(subjectId)
                .map(subject -> {
                    subject.setName(subjectUpdated.getName());
                    subject.setGrade(subjectUpdated.getGrade());
                    return subjectRepository.save(subject);
                }).orElseThrow(() -> new NotFoundException("Subject not found!"));
    }
    
   // Delete Student Subject using Jpa.
    public String deleteSubject( Long studentId,Long subjectId) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return subjectRepository.findById(subjectId)
                .map(subject -> {
                    subjectRepository.delete(subject);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }

    //List Student Address details using DTO.
    public List<SubjectDto> getOnlySubjectInfo(){
        return subjectRepository.getOnlySubjectInfo();
    }

}

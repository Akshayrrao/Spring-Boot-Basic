package com.example.student.Services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.student.Dto.StudentDto;
import com.example.student.Exception.NotFoundException;
import com.example.student.Model.Student;
import com.example.student.Repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
   //List all students Details using Jpa.
    public List<Student> getAllStudents() {
    	return studentRepository.findAll();
    }
    
   //Get student Details using Jpa.
    public Student getStudentByID(Long id) {
    	Optional<Student> optStudent = studentRepository.findById(id);
    	if(optStudent.isPresent()) {
    		return optStudent.get();
    	}else {
    		throw new NotFoundException("Student not found with id " + id);
    	}
    }

    //Add Student Details using jpa.
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    //Update Student Details using Jpa.
    public Student updateStudent(Long id, Student studentUpdated) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentUpdated.getName());
                    student.setAge(studentUpdated.getAge());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }
    
   // Delete student details using jpa.
    public String deleteStudent(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }

    //Get Student Details using DTO.
    public List<StudentDto> getOnlyStudentInfo(){
        return studentRepository.getOnlyStudentInfo();
    }
    
    // Add student Details using Native Query.
    public void addStudentData(String name,int age) {
    	
    		 studentRepository.addStudentData(name, age);
    }

    // Update student Details using Native Query.
    public void updateStudentData(Student student,Long id){
    		student.setId(id);
    		studentRepository.updateStudentData(student.getName(), student.getAge(), student.getId());
    }

    // Delete student Details using Native Query.
    public void deleteStudentData(Long id) {
    		studentRepository.deleteStudentData(id);
    }
    

}

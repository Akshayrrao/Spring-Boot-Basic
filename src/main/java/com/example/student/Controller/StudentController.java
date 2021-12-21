package com.example.student.Controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Dto.StudentDto;
import com.example.student.Model.Student;
import com.example.student.Services.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentServices;
	
    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	return studentServices.getAllStudents();
    }
    
    @GetMapping("/students/{id}")
    public Student getStudentByID(@PathVariable Long id) {
    	return studentServices.getStudentByID(id);
    }
    
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentServices.createStudent(student);
    }
    
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @Valid @RequestBody Student studentUpdated) {
        return studentServices.updateStudent(id, studentUpdated);
    }
    
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentServices.deleteStudent(id);
    }
    
    @GetMapping("/students/info")
    public List<StudentDto> getOnlyStudentInfo(){
        return studentServices.getOnlyStudentInfo();
    }
    
    @PostMapping("/addStudentData")
    public void addStudentData(@RequestBody Student student){
          studentServices.addStudentData(student.getName(),student.getAge());
     }
    
    @PutMapping("/updateStudentData/{id}")
    public void updateStudentData(@RequestBody Student student,@PathVariable Long id ){
    	student.setId(id);
    	studentServices.updateStudentData(student,id);
    }
    
    @DeleteMapping("/deleteStudentData/{id}")
    public void deleteStudentData(@PathVariable Long id ){
         studentServices.deleteStudentData(id);
     }
    
}

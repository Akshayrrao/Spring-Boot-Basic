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


import com.example.student.Dto.SubjectDto;
import com.example.student.Model.Subject;
import com.example.student.Services.SubjectService;



@RestController
@RequestMapping("/api")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectServices;
	
	
    @GetMapping("/students/{studentId}/subjects")
    public List<Subject> getContactByStudentId(@PathVariable Long studentId) {
   
    	return subjectServices.getContactByStudentId(studentId);
    }
    
    @PostMapping("/students/{studentId}/subjects")
    public Subject addSubject(@PathVariable Long studentId,
                              @Valid @RequestBody Subject subject) {
       return subjectServices.addSubject(studentId, subject);
    }
    
    @PutMapping("/students/{studentId}/subjects/{subjectId}")
    public Subject updateSubject(@PathVariable Long studentId,
    							 @PathVariable Long subjectId,
    							 @Valid @RequestBody Subject subjectUpdated) {
    	
    	return subjectServices.updateSubject(studentId, subjectId, subjectUpdated);
    	
    	
    }
    
    @DeleteMapping("/students/{studentId}/subjects/{subjectId}")
    public String deleteSubject(@PathVariable Long studentId,
    							@PathVariable Long subjectId) {
    	
    	return subjectServices.deleteSubject(studentId, subjectId);
    	
    }
    
    @GetMapping("/subjects/info")
    public List<SubjectDto> getOnlySubjectInfo(){
        return subjectServices.getOnlySubjectInfo();
    }

}

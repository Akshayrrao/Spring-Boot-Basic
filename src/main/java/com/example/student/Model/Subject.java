package com.example.student.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;


import com.example.student.Dto.SubjectDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SqlResultSetMapping(
        name="Subjectinfomapping",
        classes = {
                @ConstructorResult(
                        targetClass = SubjectDto.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "grade", type = Integer.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name="Subject.getOnlySubjectInfo",
        query="SELECT * FROM subjects",
        resultSetMapping="Subjectinfomapping"
)

@Entity
@Table(name = "subjects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Subject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "grade")
	private int grade;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;
	
	public Subject() {}
	
	public Subject(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return this.student;
	}

}

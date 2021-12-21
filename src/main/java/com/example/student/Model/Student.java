package com.example.student.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.student.Dto.StudentDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SqlResultSetMapping(
        name="studentinfomapping",
        classes = {
                @ConstructorResult(
                        targetClass = StudentDto.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "age", type = Integer.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name="Student.getOnlyStudentInfo",
        query="SELECT id, name, age FROM students",
        resultSetMapping="studentinfomapping"
)

@Entity
@Table(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Student implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Link Student and Subject Table using oneToMany.
    private Set<Subject> subjects;
    
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Link Student and Subject Table using oneToOne.
    private Address address;
	
	public Student() {}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setSubject(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public Set<Subject> getSubject(){
		return this.subjects;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}

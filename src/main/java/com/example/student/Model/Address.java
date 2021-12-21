package com.example.student.Model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.student.Dto.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SqlResultSetMapping(
        name="Addressinfomapping",
        classes = {
                @ConstructorResult(
                        targetClass = AddressDto.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "address", type = String.class),
                                @ColumnResult(name = "pincode", type = Integer.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name="Address.getOnlyAddressInfo",
        query="SELECT * FROM address",
        resultSetMapping="Addressinfomapping"
)

@Entity
@Table(name = "Address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Address {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Address")
	private String addr;
	
	@Column(name = "Pincode")
	private int pincode;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;
	
	public Address() {}
	
	public Address(String addr, int pincode) {
		this.addr = addr;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

}

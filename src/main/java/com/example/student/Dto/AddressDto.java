package com.example.student.Dto;

public class AddressDto {
	
	private Long id;
	private String addr;
	private int pincode;
	
	public AddressDto() {
	
	}
	public AddressDto(Long id, String addr, int pincode) {
		super();
		this.id = id;
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
	
}

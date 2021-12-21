package com.example.student.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.student.Dto.AddressDto;
import com.example.student.Exception.NotFoundException;
import com.example.student.Model.Address;
import com.example.student.Repository.AddressRepository;
import com.example.student.Repository.StudentRepository;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
    //Get Student Address Details using Jpa.
    public List<Address> getContactByStudentId(Long studentId) {
    	
        if(!studentRepository.existsById(studentId)) {
            throw new NotFoundException("Student not found!");
        }
    	
    	return addressRepository.findByStudentId(studentId);
    }
    
   //Add student address using jpa.
    public Address addAddress(Long studentId,Address address) {
        return studentRepository.findById(studentId)
                .map(student -> {
                    address.setStudent(student);
                    return addressRepository.save(address);
                }).orElseThrow(() -> new NotFoundException("Student not found!"));
    }
    
    //Update Student Address using Jpa.
    public Address updateAddress(Long studentId,Long addressId,Address addressUpdated) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return addressRepository.findById(addressId)
                .map(address -> {
                    address.setAddr(addressUpdated.getAddr());
                    address.setPincode(addressUpdated.getPincode());
                    return addressRepository.save(address);
                }).orElseThrow(() -> new NotFoundException("Address not found!"));
    }
    
   //Delete student Address using Jpa
    public String deleteAddress(Long studentId,Long addressId) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return addressRepository.findById(addressId)
                .map(address -> {
                    addressRepository.delete(address);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }

    //List student Address Details using DTO.
    public List<AddressDto> getOnlyAddressInfo(){
        return addressRepository.getOnlyAddressInfo();
    }

}

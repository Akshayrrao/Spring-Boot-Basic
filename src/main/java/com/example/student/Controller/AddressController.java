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

import com.example.student.Dto.AddressDto;
import com.example.student.Model.Address;
import com.example.student.Services.AddressService;


@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private AddressService addressServices;
	
	
    @GetMapping("/students/{studentId}/address")
    public List<Address> getContactByStudentId(@PathVariable Long studentId) {
   
    	return addressServices.getContactByStudentId(studentId);
    }
    
    @PostMapping("/students/{studentId}/address")
    public Address addAddress(@PathVariable Long studentId,
                              @Valid @RequestBody Address address) {
       return addressServices.addAddress(studentId, address);
    }
    
    @PutMapping("/students/{studentId}/address/{addressId}")
    public Address updateAddress(@PathVariable Long studentId,
    							@PathVariable Long addressId,
    							@Valid @RequestBody Address AddressUpdated) {
    	
    	return addressServices.updateAddress(studentId, addressId, AddressUpdated);
    	
    	
    }
    
    @DeleteMapping("/students/{studentId}/address/{addressId}")
    public String deleteSubject(@PathVariable Long studentId,
    							@PathVariable Long addressId) {
    	
    	return addressServices.deleteAddress(studentId, addressId);
    	
    }
    @GetMapping("/address/info")
    public List<AddressDto> getOnlyAddressInfo(){
        return addressServices.getOnlyAddressInfo();
    }

}

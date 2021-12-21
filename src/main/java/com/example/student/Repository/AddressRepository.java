package com.example.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student.Dto.AddressDto;
import com.example.student.Model.Address;



public interface AddressRepository extends JpaRepository <Address, Long>{
	List<Address> findByStudentId(Long studentId);
	
	@Query(nativeQuery = true)
    List<AddressDto> getOnlyAddressInfo();
}

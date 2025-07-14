package com.design.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.design.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByFirstNameContainsOrderByFirstNameAsc(String firstName);

	 @Query("FROM User WHERE firstName = :firstName AND lastName = :lastName")
	 List<User> searchByFullName(String firstName, String lastName); 

	List<User> findByFirstName(String firstName);

	List<User> findByFirstNameContains(String keyword);

	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	List<User> findByFirstNameOrLastName(String firstName, String lastName);

	List<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);       
	  
	 
	 
	 

}

package com.design.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.design.dto.UserDTO;
import com.design.entity.User;
import com.design.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	
	 private final UserService userService;

	    @PostMapping
	    public UserDTO create(@Valid @RequestBody UserDTO dto) {
	        return userService.create(dto);
	    }

	    @PutMapping("/{id}")
	    public UserDTO update(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
	        return userService.update(id, dto);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        userService.delete(id);
	    }

	    @GetMapping("/{id}")
	    public UserDTO getById(@PathVariable Long id) {
	        return userService.getById(id);
	    }

	    @GetMapping
	    public List<UserDTO> getAll() {
	        return userService.getAll();
	    }

	    @GetMapping("/paginated")
	    public Page<UserDTO> getPaginated(@RequestParam int page, @RequestParam int size) {
	        return userService.getAllPaginated(page, size);
	    }
	    
	    @GetMapping("/paginatedList")
	    public List<UserDTO> getPaginatedList(@RequestParam int page, @RequestParam int size) {
	        return userService.getPaginatedList(page, size);
	    }


	    @GetMapping("/custom")
	    public List<UserDTO> searchByFullName(@RequestParam String fn, @RequestParam String ln) {
	        return userService.getByCustomQuery(fn, ln);
	    }
	    
	    	    
	    	    
	    @GetMapping("/by-first-name")
	    public List<UserDTO> getByFirstName(@RequestParam String firstName) {
	        return userService.findByFirstName(firstName);
	    }
	    
	    @GetMapping("/by-first-name2")
	    public List<User> getByFirstName2(@RequestParam String firstName) {
	        return userService.findByFirstName2(firstName);
	    }

	    @GetMapping("/by-first-name-contains")
	    public List<UserDTO> getByFirstNameContains(@RequestParam String keyword) {
	        return userService.findByFirstNameContains(keyword);
	    }

	    @GetMapping("/by-first-name-asc")
	    public List<UserDTO> getByFirstNameContainsAsc(@RequestParam String keyword) {
	        return userService.findByFirstNameContainsOrderByFirstNameAsc(keyword);
	    }

	    @GetMapping("/by-first-last-name")
	    public List<UserDTO> getByFirstAndLastName(@RequestParam String firstName,
	                                               @RequestParam String lastName) {
	        return userService.findByFirstNameAndLastName(firstName, lastName);
	    }

	    @GetMapping("/by-first-or-last-name")
	    public List<UserDTO> getByFirstOrLastName(@RequestParam String firstName,
	                                              @RequestParam String lastName) {
	        return userService.findByFirstNameOrLastName(firstName, lastName);
	    }

	    @GetMapping("/by-name-contains")
	    public List<UserDTO> getByFirstOrLastNameContains(@RequestParam String firstName,
	                                                      @RequestParam String lastName) {
	        return userService.findByFirstNameContainsOrLastNameContains(firstName, lastName);
	    }
	    
	    
	    
	    

}

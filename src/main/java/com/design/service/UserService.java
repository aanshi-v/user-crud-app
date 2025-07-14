package com.design.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.design.dto.UserDTO;
import com.design.entity.User;
import com.design.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;
    private final ModelMapper mapper;

    public UserDTO create(UserDTO dto) {
        User saved = userRepo.save(mapper.map(dto, User.class));
        return mapper.map(saved, UserDTO.class);
    }

    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepo.findById(id).orElseThrow();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return mapper.map(userRepo.save(user), UserDTO.class);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public UserDTO getById(Long id) {
        return mapper.map(userRepo.findById(id).orElseThrow(), UserDTO.class);
    }

    public List<UserDTO> getAll() {
        return userRepo.findAll().stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    
    public Page<UserDTO> getAllPaginated(int page, int size) {
        Page<User> pageResult = userRepo.findAll(PageRequest.of(page, size));
        return pageResult.map(u -> mapper.map(u, UserDTO.class));
    }
    
  public List<UserDTO> getPaginatedList(int page, int size) {
  Page<User> pageResult = userRepo.findAll(PageRequest.of(page, size));
  return pageResult.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList()); 
}

    
    

    public List<UserDTO> getByCustomQuery(String fn, String ln) {
        return userRepo.searchByFullName(fn, ln)
                .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
    }

    
    
    
	public List<UserDTO> findByFirstName(String firstName) { 
		return userRepo.findByFirstName(firstName)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	} 
    
	public List<User> findByFirstName2(String firstName) { 
		List<User> users = userRepo.findByFirstName(firstName);
		return users; 
	}

	public List<UserDTO> findByFirstNameContains(String keyword) {
	    return userRepo.findByFirstNameContains(keyword)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	}

	public List<UserDTO> findByFirstNameContainsOrderByFirstNameAsc(String keyword) {
	    return userRepo.findByFirstNameContainsOrderByFirstNameAsc(keyword)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	}

	public List<UserDTO> findByFirstNameAndLastName(String firstName, String lastName) {
	    return userRepo.findByFirstNameAndLastName(firstName, lastName)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	}

	public List<UserDTO> findByFirstNameOrLastName(String firstName, String lastName) {
	    return userRepo.findByFirstNameOrLastName(firstName, lastName)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	}

	public List<UserDTO> findByFirstNameContainsOrLastNameContains(String firstName, String lastName) {
	    return userRepo.findByFirstNameContainsOrLastNameContains(firstName, lastName)
	            .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
	
	}

	
	
	
	
	
}











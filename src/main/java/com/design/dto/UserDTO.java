package com.design.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	
	 private Long id;

	    @NotBlank(message = "First name is mandatory")
	    private String firstName;

	    @NotBlank(message = "Last name is mandatory")
	    private String lastName;

	    @Email(message = "Invalid email format")
	    private String email;

}

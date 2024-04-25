package com.rungroup.webTest.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationDto {
    private Long id;
    @NotEmpty
    @Size(min = 3,max = 12,message = "От 3 до 12 символов")
    private String username;
    @NotEmpty
    private String email;
    @Size(min = 5, max =20, message = "От 5 до 20 символов")
    @NotEmpty
    private String password;
}

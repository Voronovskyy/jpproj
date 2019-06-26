package LITS.jpproj.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotEmpty
    @Size(max=64)
    private String login;

    @NotEmpty
    @Size(max=32)
    private String password;

    @NotEmpty
    @Size(max=32)
    private String role;


}

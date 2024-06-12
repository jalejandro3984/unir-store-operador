package com.unir.store_core.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message= "`username` cannot be null")
    @NotNull(message= "`username` cannot be empty")
    private String username;

    @NotNull(message= "`email` cannot be null")
    @NotNull(message= "`email` cannot be empty")
    private String email;

    @NotNull(message= "`first_name` cannot be null")
    @NotNull(message= "`first_name` cannot be empty")
    private String firstName;

    @NotNull(message= "`last_name` cannot be null")
    @NotNull(message= "`last_name` cannot be empty")
    private String lastName;

    @NotNull(message= "`password` cannot be null")
    @NotNull(message= "`password` cannot be empty")
    private String password;

    @Null
    private String phoneNumber;
}

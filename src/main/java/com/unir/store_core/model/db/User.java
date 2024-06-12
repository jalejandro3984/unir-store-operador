package com.unir.store_core.model.db;

import com.unir.store_core.model.dto.UserDto;
import com.unir.store_core.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    public void update(UserDto userDto) {
        this.username = (null != userDto.getUsername()) ? userDto.getUsername() : this.username;
        this.email = (null != userDto.getEmail()) ? userDto.getEmail() : this.email;
        this.firstName = (null != userDto.getFirstName()) ? userDto.getFirstName() : this.firstName;
        this.lastName = (null != userDto.getLastName()) ? userDto.getLastName() : this.lastName;
        this.password = (null != userDto.getPassword()) ? userDto.getPassword() : this.password;
        this.phoneNumber = (null != userDto.getPhoneNumber()) ? userDto.getPhoneNumber() : this.phoneNumber;
    }

    public static User fromRequest(UserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}

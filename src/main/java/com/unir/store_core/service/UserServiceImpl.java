package com.unir.store_core.service;

import com.unir.store_core.model.db.User;
import com.unir.store_core.model.dto.UserDto;
import com.unir.store_core.model.request.UserRequest;
import com.unir.store_core.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final BasicPasswordEncryptor passwordEncryptor;
    private final UserJpaRepository repository;

    @Override
    public User createUser(UserRequest request) {
        String encryptPassword = passwordEncryptor.encryptPassword(request.getPassword());

        request.setPassword(encryptPassword);

        User user = User.fromRequest(request);

        return repository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        User user = repository.getReferenceById(id);

        if (null != userDto.getPassword()) {
            String encryptPassword = passwordEncryptor.encryptPassword(userDto.getPassword());
            userDto.setPassword(encryptPassword);
        }

        user.update(userDto);

        return repository.save(user);
    }
}

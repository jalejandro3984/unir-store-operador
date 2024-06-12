package com.unir.store_core.service;

import com.unir.store_core.model.db.User;
import com.unir.store_core.model.dto.UserDto;
import com.unir.store_core.model.request.UserRequest;

public interface UserService {
    User createUser(UserRequest request);
    User updateUser(Long id, UserDto userDto);
}

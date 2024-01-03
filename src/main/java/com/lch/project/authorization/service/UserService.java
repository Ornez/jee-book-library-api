package com.lch.project.authorization.service;

import com.lch.project.authorization.model.UserDto;

public interface UserService {
    UserDto getCurrentUser(String token);
}

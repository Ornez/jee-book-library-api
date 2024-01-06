package com.lch.project.authorization.utils;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.authorization.model.UserDto;

public class AuthUtils {
    public static UserDto asDto(UserDao user) {
        return UserDto.builder()
                .username(user.getUsername())
                .build();
    }
}

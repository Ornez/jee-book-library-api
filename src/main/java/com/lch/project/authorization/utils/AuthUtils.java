package com.lch.project.authorization.utils;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.authorization.model.UserDto;

public class AuthUtils {
    public static UserDto asDto(UserDao user) {
        return UserDto.builder()
                .id((int)user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }
}

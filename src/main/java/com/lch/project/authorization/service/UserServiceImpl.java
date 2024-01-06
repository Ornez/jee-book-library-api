package com.lch.project.authorization.service;

import com.lch.project.authorization.config.JwtTokenUtil;
import com.lch.project.authorization.model.UserDao;
import com.lch.project.authorization.model.UserDto;
import com.lch.project.authorization.repository.UserRepository;
import com.lch.project.authorization.utils.AuthUtils;
import com.lch.project.rating.utils.RatingUtils;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@ExtensionMethod({AuthUtils.class})
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDao findByUsername(String username) {
        UserDao user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    @Override
    public UserDto getCurrentUser(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);

        UserDao user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user.asDto();
    }
}

package com.lch.project.authorization.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserDto {
    private String username;
    private String password;
}

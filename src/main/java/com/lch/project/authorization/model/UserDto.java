package com.lch.project.authorization.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
}


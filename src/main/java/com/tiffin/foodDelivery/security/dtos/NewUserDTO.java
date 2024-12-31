package com.tiffin.foodDelivery.security.dtos;

import com.tiffin.foodDelivery.security.utils.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class NewUserDTO {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String roles = UserRole.USER.toString();
    private String registerModule;
}

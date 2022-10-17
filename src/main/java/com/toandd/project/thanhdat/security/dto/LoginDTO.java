package com.toandd.project.thanhdat.security.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO implements Serializable {

    @Size(min = 5, max = 100, message = " Tên tài khoản phải có độ dài từ {min} đến {max}")
    @NotBlank
    @NotNull(message="Chưa nhập tên đăng nhập")
    private String username;
    @Size(min = 5, max = 10, message = "Mật khẩu phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên mật khẩu")
    private String password;
}

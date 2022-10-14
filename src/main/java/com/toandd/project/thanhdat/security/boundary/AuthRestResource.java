package com.toandd.project.thanhdat.security.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.security.service.AuthService;
import com.toandd.project.thanhdat.security.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthRestResource {

    private final AuthService authService;

    public AuthRestResource(  AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("register")
    public Object register(@RequestBody @Valid LoginDTO loginDTO)   {
        return ResponseUtils.get(authService.register(loginDTO),HttpStatus.CREATED);

    }
    @PostMapping("login")
    public Object login(@RequestBody @Valid LoginDTO loginDTO)  {
        return ResponseUtils.get(authService.login(loginDTO), HttpStatus.OK);

    }
}

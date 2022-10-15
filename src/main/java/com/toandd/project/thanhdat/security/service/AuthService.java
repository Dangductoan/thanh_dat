package com.toandd.project.thanhdat.security.service;


import com.toandd.project.thanhdat.common.exception.GiraBusinessException;
import com.toandd.project.thanhdat.security.dto.LoginDTO;
import com.toandd.project.thanhdat.security.jwt.TokenService;
import com.toandd.project.thanhdat.security.model.Admin;
import com.toandd.project.thanhdat.security.repository.AdminRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AuthService {
    String login(LoginDTO loginDTO);

    String register(LoginDTO loginDTO);
}

@Service
class AuthServiceImpl implements AuthService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    AuthServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @Override
    public String login(LoginDTO loginDTO) {
        Admin admin = adminRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(
                        () -> new GiraBusinessException("admin is not existed")
                );
        if (passwordEncoder.matches(loginDTO.getPassword(), admin.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return tokenService.generateToken(authentication);
        }

        throw new GiraBusinessException("password is incorrect");
    }

    @Override
    public String register(LoginDTO loginDTO) {
        Optional<Admin> admin = adminRepository.findByUsername(loginDTO.getUsername());
        if(admin.isEmpty()) {
            adminRepository.save(new Admin(loginDTO.getUsername(), passwordEncoder.encode(loginDTO.getPassword())));
            return "Register successfully";
        }

        throw new GiraBusinessException("admin is invalid");
    }


}


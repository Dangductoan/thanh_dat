package com.toandd.project.thanhdat.security.service;

import com.toandd.project.thanhdat.security.model.Admin;
import com.toandd.project.thanhdat.security.model.UserDetailsImpl;
import com.toandd.project.thanhdat.security.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepository adminRepository;

    public UserDetailsServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("admin is not existed")
        );

        return new UserDetailsImpl(admin.getUsername(),admin.getPassword());
    }
}

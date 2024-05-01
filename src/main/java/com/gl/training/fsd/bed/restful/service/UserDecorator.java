package com.gl.training.fsd.bed.restful.service;

import com.gl.training.fsd.bed.restful.entity.Role;
import com.gl.training.fsd.bed.restful.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDecorator implements UserDetails {

    User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        LocalDate acctExpiryDate = user.getAccountExpiryDate();
        LocalDate today = LocalDate.now();
        return acctExpiryDate.isAfter(today);

    }

    @Override
    public boolean isAccountNonLocked() {

        return user.getAccountLockedStatus() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        LocalDate credentialExpiryDate = user.getCredentialsExpiryDate();
        LocalDate today = LocalDate.now();
        return credentialExpiryDate.isAfter(today);
    }

    @Override
    public boolean isEnabled() {
        return user.getAccountEnabledStatus() == 1;
    }
}

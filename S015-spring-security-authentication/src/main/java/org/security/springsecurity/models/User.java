package org.security.springsecurity.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class User {
    private final String username;
    private final String password;
    private final String authorities;

    public User(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthorities() {
        return authorities;
    }
}

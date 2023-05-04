package com.playdata.springbootprojectre.config.auth;

import com.playdata.springbootprojectre.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    public String email;
    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}

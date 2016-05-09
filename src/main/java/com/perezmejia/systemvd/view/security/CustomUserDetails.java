package com.perezmejia.systemvd.view.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Guil on 5/7/2016.
 */
public class CustomUserDetails extends User {
    private UserView user;

    public CustomUserDetails(UserView user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserName(), user.getPassword(), authorities);

        this.user = user;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }
}

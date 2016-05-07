package com.perezmejia.systemvd.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Guil on 5/2/2016.
 */
public class UserSecurity extends User {
    private com.perezmejia.systemvd.domain.User user;

    public UserSecurity(com.perezmejia.systemvd.domain.User user,
                        Collection<? extends GrantedAuthority> authorities) {

        super(user.getUserName(), user.getPassword(), user.getEnabled() == 1, true, true, true, authorities);

        this.user = user;
    }

    public com.perezmejia.systemvd.domain.User getUser() {
        return user;
    }

    public void setUser(com.perezmejia.systemvd.domain.User user) {
        this.user = user;
    }
}

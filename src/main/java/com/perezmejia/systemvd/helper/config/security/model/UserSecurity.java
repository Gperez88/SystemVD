package com.perezmejia.systemvd.helper.config.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Guil on 5/2/2016.
 */
public class UserSecurity extends User {
    private com.perezmejia.systemvd.helper.config.security.model.User user;

    public UserSecurity(com.perezmejia.systemvd.helper.config.security.model.User user,
                        Collection<? extends GrantedAuthority> authorities) {

        super(user.getUserName(), user.getPassword(), user.getEnabled() == 1, true, true, true, authorities);

        this.user = user;
    }

    public com.perezmejia.systemvd.helper.config.security.model.User getUser() {
        return user;
    }

    public void setUser(com.perezmejia.systemvd.helper.config.security.model.User user) {
        this.user = user;
    }
}

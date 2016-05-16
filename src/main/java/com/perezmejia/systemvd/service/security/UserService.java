package com.perezmejia.systemvd.service.security;

import com.perezmejia.systemvd.view.security.UserView;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Guil on 5/15/2016.
 */
public interface UserService extends UserDetailsService {
    public UserView findUserByName(String userName);
}

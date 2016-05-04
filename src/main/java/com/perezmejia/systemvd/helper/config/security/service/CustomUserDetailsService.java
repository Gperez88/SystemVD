package com.perezmejia.systemvd.helper.config.security.service;

import com.perezmejia.systemvd.helper.config.security.model.Authorities;
import com.perezmejia.systemvd.helper.config.security.model.UserSecurity;
import com.perezmejia.systemvd.helper.config.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Guil on 5/1/2016.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {

        com.perezmejia.systemvd.helper.config.security.model.User user = userRepository.findByUserName(userName);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getAuthorities());

        return buildUserForAuthentication(user, authorities);
    }

    private UserSecurity buildUserForAuthentication(com.perezmejia.systemvd.helper.config.security.model.User user, List<GrantedAuthority> authorities) {
        return new UserSecurity(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Authorities> authorities) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        authorities.forEach(authority -> {
            setAuths.add(new SimpleGrantedAuthority(authority.getAuthority().getAuthority()));
        });

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}

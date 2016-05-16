package com.perezmejia.systemvd.service.security.impl;

import com.gp89developers.mapperobject.Mapper;
import com.gp89developers.mapperobject.MapperObject;
import com.perezmejia.systemvd.entity.security.Authorities;
import com.perezmejia.systemvd.entity.security.User;
import com.perezmejia.systemvd.service.security.UserService;
import com.perezmejia.systemvd.view.security.AuthorityView;
import com.perezmejia.systemvd.view.security.CustomUserDetails;
import com.perezmejia.systemvd.view.security.UserView;
import com.perezmejia.systemvd.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Guil on 5/1/2016.
 */

@Service("customUserDetailsService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper = MapperObject.getInstance();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {

        UserView user = findUserByName(userName);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getAuthorities());
        return buildUserForAuthentication(user, authorities);
    }

    private CustomUserDetails buildUserForAuthentication(UserView userView, List<GrantedAuthority> authorities) {
        return new CustomUserDetails(userView, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<AuthorityView> authorities) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        authorities.forEach(authority -> setAuths.add(new SimpleGrantedAuthority(authority.getAuthority())));

        return new ArrayList<>(setAuths);
    }

    @Override
    public UserView findUserByName(String userName) {
        UserView userView = new UserView(userRepository.findByUserName(userName));
        return userView;
    }
}

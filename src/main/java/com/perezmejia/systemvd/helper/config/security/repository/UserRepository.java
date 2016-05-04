package com.perezmejia.systemvd.helper.config.security.repository;

import com.perezmejia.systemvd.helper.config.security.model.User;
import org.springframework.data.repository.Repository;

/**
 * Created by Guil on 5/1/2016.
 */
public interface UserRepository extends Repository<User, Integer> {
    public User findByUserName(String userName);
}

package com.perezmejia.systemvd.repository.security;

import com.perezmejia.systemvd.entity.security.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Guil on 5/1/2016.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u inner join u.person where u.userName = ?1")
    public User findByUserName(String userName);
}

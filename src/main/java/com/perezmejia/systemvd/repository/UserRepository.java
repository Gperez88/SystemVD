package com.perezmejia.systemvd.repository;

import com.perezmejia.systemvd.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Guil on 5/1/2016.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u inner join u.person where u.userName = ?1")
    public User findByUserName(String userName);
}

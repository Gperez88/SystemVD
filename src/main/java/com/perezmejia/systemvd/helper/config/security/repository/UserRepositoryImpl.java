package com.perezmejia.systemvd.helper.config.security.repository;

import com.perezmejia.systemvd.helper.config.security.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Guil on 5/1/2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUserName(String userName) {
        List<User> users = entityManager.createNamedQuery("byUserName").setParameter("userName", userName).getResultList();

        if (users.size() > 0)
            return users.get(0);
        else
            return null;

    }
}

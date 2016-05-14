package com.perezmejia.systemvd.repository;

import com.perezmejia.systemvd.entity.Client;
import com.perezmejia.systemvd.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Guil on 5/8/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}

package com.perezmejia.systemvd.repository;

import com.perezmejia.systemvd.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("select concat(c.person.firstname,' ', c.person.lastname) from Client c where c.person.firstname like ?1")
    public List<String> findAllClientName(String value);

    @Query("select c from Client c where concat(c.person.firstname,' ', c.person.lastname) like ?1")
    public Client findClientByName(String name);
}
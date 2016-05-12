package com.perezmejia.systemvd.view;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.Person;

import java.sql.Date;

/**
 * Created by Guil on 5/7/2016.
 */

@EntityMapper
public class PersonView extends ParsableObject<Person, PersonView> {
    @Mapping
    private Long id;
    @Mapping
    private String firstname;
    @Mapping
    private String lastname;
    @Mapping
    private Date birthdate;
    @Mapping
    private String sex;
    @Mapping
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Class<Person> getDomainClass() {
        return Person.class;
    }
}

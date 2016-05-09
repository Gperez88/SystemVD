package com.perezmejia.systemvd.view.security;

import com.perezmejia.systemvd.entity.Person;
import com.perezmejia.systemvd.helper.mapperobject.EntityMapper;
import com.perezmejia.systemvd.helper.mapperobject.Mapping;
import com.perezmejia.systemvd.helper.mapperobject.ParsableObject;

import java.sql.Date;

/**
 * Created by Guil on 5/7/2016.
 */

@EntityMapper
public class PersonView extends ParsableObject<Person, PersonView> {
    @Mapping
    private int id;
    @Mapping
    private String firstName;
    @Mapping
    private String lastName;
    @Mapping
    private Date birthdate;
    @Mapping
    private String sex;
    @Mapping
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

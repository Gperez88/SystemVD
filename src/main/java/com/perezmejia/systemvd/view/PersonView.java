package com.perezmejia.systemvd.view;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.Person;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by Guil on 5/7/2016.
 */

@EntityMapper
public class PersonView extends ParsableObject<Person, PersonView> {
    @Mapping
    private Long id;
    @Mapping
    @NotBlank(message = "person.firstname.notnull.error")
    @Size(max = 100)
    private String firstname;
    @Mapping
    @NotBlank(message = "person.lastname.notnull.error")
    @Size(max = 100)
    private String lastname;
    @Mapping
    @NotBlank(message = "person.birthdate.notnull.error")
    @Past(message ="person.birthdate.past.error")
    private Date birthdate;
    @Mapping
    @NotBlank(message = "person.identify.notnull.error")
    private String identifyDocument;
    @Mapping
    @NotBlank(message = "person.sex.notnull.error")
    private String sex;
    @Mapping
    @NotBlank(message = "person.email.notnull.error")
    @Size(max = 100)
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

    public String getIdentifyDocument() {
        return identifyDocument;
    }

    public void setIdentifyDocument(String identifyDocument) {
        this.identifyDocument = identifyDocument;
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

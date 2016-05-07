package com.perezmejia.systemvd.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Guil on 5/1/2016.
 */
@Entity
@Table(name = "user", schema = "systemvd")
//@NamedQuery(name = "byUserName", query = "select u from User u inner join u.person where u.userName = :userName")
public class User {
    private int id;
    private String userName;
    private String password;
    private int enabled;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private Integer tracking;
    private List<Authorities> authorities;
    private Person person;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "tracking")
    public Integer getTracking() {
        return tracking;
    }

    public void setTracking(Integer tracking) {
        this.tracking = tracking;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "user_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (enabled != that.enabled) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (tracking != null ? !tracking.equals(that.tracking) : that.tracking != null) return false;
        if (authorities != null ? !authorities.equals(authorities) : that.authorities != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + enabled;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + tracking;
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        return result;
    }
}

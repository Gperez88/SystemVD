package com.perezmejia.systemvd.view.security;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.security.User;
import com.perezmejia.systemvd.view.PersonView;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guil on 5/2/2016.
 */
@EntityMapper
public class UserView extends ParsableObject<User, UserView> {
    @Mapping
    private int id;
    @Mapping
    private String userName;
    @Mapping
    private String password;
    @Mapping
    private int enabled;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;
    @Mapping
    private Integer tracking;
    //manual mapper
    private List<AuthorityView> authorities;
    @Mapping(otherType = true)
    private PersonView person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getTracking() {
        return tracking;
    }

    public void setTracking(Integer tracking) {
        this.tracking = tracking;
    }

    public List<AuthorityView> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityView> authorities) {
        this.authorities = authorities;
    }

    public PersonView getPerson() {
        return person;
    }

    public void setPerson(PersonView person) {
        this.person = person;
    }

    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }

    @Override
    public UserView load(User user) {
        UserView userView = super.load(user);

        if (!CollectionUtils.isEmpty(user.getAuthorities())) {
            List<AuthorityView> authorityViews = new ArrayList<>();
            user.getAuthorities().forEach(authorities -> authorityViews.add(new AuthorityView(authorities.getAuthority())));
        }

        return userView;
    }
}

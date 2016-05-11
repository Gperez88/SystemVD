package com.perezmejia.systemvd.view.security;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.security.Authority;

/**
 * Created by Guil on 5/7/2016.
 */
@EntityMapper
public class AuthorityView extends ParsableObject<Authority, AuthorityView> {
    @Mapping
    private int id;
    @Mapping
    private String authority;
    @Mapping
    private String description;

    public AuthorityView() {
    }

    public AuthorityView(Authority authority) {
        load(authority);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Class<Authority> getDomainClass() {
        return Authority.class;
    }
}

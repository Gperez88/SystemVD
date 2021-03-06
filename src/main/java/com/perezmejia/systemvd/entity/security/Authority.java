package com.perezmejia.systemvd.entity.security;

import javax.persistence.*;

/**
 * Created by Guil on 5/1/2016.
 */
@Entity
@Table(name = "authority", schema = "systemvd")
public class Authority {
    private Long id;
    private String authority;
    private String description;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority that = (Authority) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (authority != null ? !authority.equals(that.authority) : that.authority != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null ? id.hashCode() : 0);;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

package com.perezmejia.systemvd.view;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.Client;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by Guil on 5/8/2016.
 */
@EntityMapper
public class ClientView extends ParsableObject<Client, ClientView> {
    @Mapping
    private Long id;
    @Mapping
    @NotNull
    private int enabled;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;
    @Mapping(otherType = true)
    @NotNull
    private PersonView person;

    public ClientView() {
    }

    public ClientView(Client client) {
        load(client);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PersonView getPerson() {
        return person;
    }

    public void setPerson(PersonView person) {
        this.person = person;
    }

    @Override
    public Class<Client> getDomainClass() {
        return Client.class;
    }
}

package com.perezmejia.systemvd.view;

import com.perezmejia.systemvd.entity.Client;
import com.perezmejia.systemvd.helper.mapperobject.ParsableObject;
import com.perezmejia.systemvd.view.security.PersonView;

import java.sql.Timestamp;

/**
 * Created by Guil on 5/8/2016.
 */
public class ClientView extends ParsableObject<Client, ClientView> {
    private int id;
    private int enabled;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private PersonView person;

    public ClientView() {
    }

    public ClientView(Client client) {
        load(client);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

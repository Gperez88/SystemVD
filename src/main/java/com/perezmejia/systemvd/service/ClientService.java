package com.perezmejia.systemvd.service;

import com.perezmejia.systemvd.view.ClientView;

import java.util.List;

/**
 * Created by Guil on 5/10/2016.
 */
public interface ClientService extends BaseService<ClientView> {
    public List<String> findAllClientName(String value);

    public ClientView findClientByName(String name);
}

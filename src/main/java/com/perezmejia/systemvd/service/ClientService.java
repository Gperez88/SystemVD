package com.perezmejia.systemvd.service;

import com.perezmejia.systemvd.entity.Client;
import com.perezmejia.systemvd.helper.mapperobject.MapperObject;
import com.perezmejia.systemvd.helper.mapperobject.TypeToken;
import com.perezmejia.systemvd.repository.ClientRepository;
import com.perezmejia.systemvd.view.ClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class ClientService implements BaseService<ClientView> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientView> findAll() {
        Type categoryListType = new TypeToken<List<ClientView>>() {}.getType();
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return MapperObject.getInstance().map(clients, categoryListType);
    }

    @Override
    public ClientView findById(Integer id) {
        return new ClientView(clientRepository.findOne(id));
    }

    @Override
    public void save(ClientView clientView) {
        Client client = clientView.parse();
        clientRepository.save(client);
    }
}

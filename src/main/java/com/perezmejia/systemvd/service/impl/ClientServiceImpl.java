package com.perezmejia.systemvd.service.impl;

import com.perezmejia.systemvd.entity.Client;
import com.perezmejia.systemvd.repository.ClientRepository;
import com.perezmejia.systemvd.repository.PersonRepository;
import com.perezmejia.systemvd.service.ClientService;
import com.perezmejia.systemvd.view.ClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientView> findAll() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return new ClientView().convertViewList(clients);
    }

    @Override
    public ClientView findById(Long id) {
        return new ClientView(clientRepository.findOne(id));
    }

    @Override
    public void save(ClientView clientView) {
        Client client = clientView.parse();
        clientRepository.save(client);
    }

    @Override
    public List<String> findAllClientName(String value) {
        return clientRepository.findAllClientName(value);
    }

    @Override
    public ClientView findClientByName(String name) {
        return new ClientView(clientRepository.findClientByName(name));
    }
}

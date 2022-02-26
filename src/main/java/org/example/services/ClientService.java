package org.example.services;

import org.example.dao.ClientDAO;
import org.example.models.Client;

import java.util.List;

public class ClientService {
    private ClientDAO clientDao = new ClientDAO();

    public ClientService() {
    }

    public Client findClient(int id) {
        return clientDao.findById(id);
    }

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public void deleteClient(int id) {
        clientDao.delete(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public List<Client> findAllUsers() {
        return clientDao.findAll();
    }


}

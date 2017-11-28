package pl.akademiakodu.service;

import pl.akademiakodu.model.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);

    List<Client> getList();
}

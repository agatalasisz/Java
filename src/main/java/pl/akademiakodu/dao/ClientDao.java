package pl.akademiakodu.dao;

import pl.akademiakodu.model.Client;

import java.util.List;

public interface ClientDao {

    List<Client> getList();
    void save(Client client);

}

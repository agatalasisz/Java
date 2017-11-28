package pl.akademiakodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.dao.ClientDao;
import pl.akademiakodu.model.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;


    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public List<Client> getList() {
        return clientDao.getList();
    }
}

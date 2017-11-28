package pl.akademiakodu.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Primary
public class ClientRepositoryDaoImpl implements ClientDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Client> getList() {
        Query query = entityManager.createQuery("FROM Client client");
        List<Client> resultList = (List<Client>) query.getResultList();
        return resultList;
    }


    @Override
    public void save(Client client) {
        entityManager.persist(client);
    }

}

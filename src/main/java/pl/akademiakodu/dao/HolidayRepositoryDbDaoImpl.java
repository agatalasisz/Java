package pl.akademiakodu.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Holiday;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Primary
public class HolidayRepositoryDbDaoImpl implements HolidayDao {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Holiday> getList() {
        Query query = entityManager.createQuery("FROM Holiday holiday");
        List<Holiday> resultList = (List<Holiday>) query.getResultList();
        return resultList;
    }

    @Override
    public void save(Holiday holiday) {
        entityManager.persist(holiday);
    }

    @Override
    public void update(Holiday holiday) {
        entityManager.merge(holiday);
    }

    @Override
    public Holiday find(int id) {
        return entityManager.find(Holiday.class, id);
    }

    @Override
    public void remove(int id) {
        Holiday holiday = find(id);
        entityManager.remove(holiday);
    }

    @Override
    public void reserve(int id) {
        Holiday holiday = find(id);
        holiday.setFreeRooms(holiday.getFreeRooms() - 1);
        holiday.setBookedRooms(holiday.getBookedRooms() + 1);
    }

    @Override
    public List<Holiday> findByQuery(String queryString) {
        Query dbQuery = entityManager.createQuery("FROM Holiday holiday WHERE LOWER(holiday.country) " +
                "LIKE :country");
        dbQuery.setParameter("country", '%' + queryString.toLowerCase() + '%');
        List<Holiday> resultList = (List<Holiday>) dbQuery.getResultList();
        return resultList;
    }


}

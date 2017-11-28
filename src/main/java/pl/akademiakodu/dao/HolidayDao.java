package pl.akademiakodu.dao;

import pl.akademiakodu.model.Holiday;

import java.util.List;

public interface HolidayDao {

    List<Holiday> getList();
    void save(Holiday holiday);
    void update(Holiday holiday);
    Holiday find(int id);
    void remove(int id);
    void reserve(int id);
    List<Holiday> findByQuery(String query);

}

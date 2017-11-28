package pl.akademiakodu.service;

import pl.akademiakodu.model.Holiday;

import java.util.List;

public interface HolidayService {


    Holiday save(Holiday holiday);

    List<Holiday> getList();

    Holiday read(int id);

    void remove(int id);

    void reserve(int id);

    List<Holiday> findByQuery(String query);
}

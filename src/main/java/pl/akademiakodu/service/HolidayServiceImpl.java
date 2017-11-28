package pl.akademiakodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.dao.HolidayDao;
import pl.akademiakodu.model.Holiday;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {


    @Autowired
    private HolidayDao holidayDao;

    @Override
    public Holiday save(Holiday holiday) {
        if (holiday.getId() == 0) {
            holidayDao.save(holiday);
        } else {
            holidayDao.update(holiday);
        }
        return holiday;
    }

    @Override
    public List<Holiday> getList() {
        return holidayDao.getList();
    }

    @Override
    public Holiday read(int id) {
        return holidayDao.find(id);
    }

    @Override
    public void remove(int id) {
        holidayDao.remove(id);
    }

    @Override
    public void reserve(int id) {
        holidayDao.reserve(id);
    }

    @Override
    public List<Holiday> findByQuery(String query) {
        return holidayDao.findByQuery(query);
    }
}

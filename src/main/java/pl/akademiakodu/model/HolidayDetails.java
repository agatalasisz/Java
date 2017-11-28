package pl.akademiakodu.model;

import javax.persistence.Embeddable;


@Embeddable
public class HolidayDetails {

    private String hotelDesc;

    private String location;

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

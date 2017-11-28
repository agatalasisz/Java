package pl.akademiakodu.model;

import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "HOLIDAY")
public class Holiday {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "COUNTRY")
    @NotNull
    @NotEmpty(message = "Podaj nazwę kraju")
    private String country;

    @Column(name = "HOTEL")
    @NotNull
    @NotEmpty(message = "Podaj nazwę hotelu")
    private String hotel;

    @Column(name = "STARS")
    private String stars;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "hotelDesc", column =
            @Column(name = "HOTELDESC", columnDefinition = "TEXT")),
            @AttributeOverride(name = "location", column =
            @Column(name = "LOCATION", columnDefinition = "TEXT"))
    })
    private HolidayDetails holidayDetails;

    @Column(name = "OPINIONS")
    @NotNull
    @NotEmpty(message = "Podaj link do Tripadvisor")
    private String opinions;

    @Column(name = "DAYS")
    @Digits(integer = 2, fraction = 0)
    @Min(7)
    @Max(14)
    private int days;

    @Column(name = "PRICE")
    @Digits(integer = 4, fraction = 0)
    @Min(1000)
    private int price;

    @Column(name = "FREEROOMS")
    @Digits(integer = 2, fraction = 0)
    @Min(1)
    private int freeRooms;

    @Column(name = "BOOKEDROOMS")
    private int bookedRooms;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holiday")
    private List<Client> clients;


    public Holiday() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getOpinions() {
        return opinions;
    }

    public void setOpinions(String opinions) {
        this.opinions = opinions;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFreeRooms() {
        return freeRooms;
    }

    public void setFreeRooms(int freeRooms) {
        this.freeRooms = freeRooms;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(int bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public HolidayDetails getHolidayDetails() {
        return holidayDetails;
    }

    public void setHolidayDetails(HolidayDetails holidayDetails) {
        this.holidayDetails = holidayDetails;
    }
}


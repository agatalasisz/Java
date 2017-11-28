package pl.akademiakodu.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    @NotNull
    @NotEmpty(message = "Wprowadź imię")
    private String name;

    @Column(name = "SURNAME")
    @NotNull
    @NotEmpty(message = "Wprowadź nazwisko")
    private String surname;

    @Column(name = "NUMBER")
    @NotNull
    @NotEmpty(message = "Wprowadź numer telefonu")
    @Pattern(regexp = "[0-9]{9}", message = "Wymagane: 9-cyfr")
    private String phoneNumber;

    @Column(name = "EMAIL")
    @NotNull
    @NotEmpty(message = "Wprowadź adres email")
    private String email;


    @ManyToOne(cascade = CascadeType.ALL)
    private Holiday holiday;

    private int sum;

    public Client() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

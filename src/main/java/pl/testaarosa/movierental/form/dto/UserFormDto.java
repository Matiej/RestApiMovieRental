package pl.testaarosa.movierental.form.dto;

import pl.testaarosa.movierental.domain.UserGender;

import java.time.LocalDateTime;

public class UserFormDto {

    private String name;
    private String surname;
    private String email;
    private LocalDateTime registerDate;
    private String brithday;
    private String city;
    private String street;
    private UserGender userGender;

    public UserFormDto() {
    }

    public UserFormDto(String name, String surname, String email,
                       LocalDateTime registerDate, String brithday,
                       String city, String street, UserGender userGender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registerDate = registerDate;
        this.brithday = brithday;
        this.city = city;
        this.street = street;
        this.userGender = userGender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public UserGender getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "UserFormDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", brithday=" + brithday +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", userGender=" + userGender +
                '}';
    }
}

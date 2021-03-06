package pl.testaarosa.movierental.form;

import pl.testaarosa.movierental.domain.UserGender;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserForm {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String matchingPassword;
    private LocalDateTime registerDate;
    private String birthday;
    private String city;
    private String street;
    private UserGender userGender;

    public UserForm(String name, String surname, String email, String password, String matchingPassword,
                    LocalDateTime registerDate, String birthday,
                    String city, String street, UserGender userGender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.registerDate = registerDate;
        this.birthday = birthday;
        this.city = city;
        this.street = street;
        this.userGender = userGender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return LocalDateTime.now().withNano(0);
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", userGender=" + userGender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserForm userForm = (UserForm) o;
        return Objects.equals(name, userForm.name) &&
                Objects.equals(surname, userForm.surname) &&
                Objects.equals(email, userForm.email) &&
                Objects.equals(password, userForm.password) &&
                Objects.equals(matchingPassword, userForm.matchingPassword) &&
                Objects.equals(registerDate, userForm.registerDate) &&
                Objects.equals(birthday, userForm.birthday) &&
                Objects.equals(city, userForm.city) &&
                Objects.equals(street, userForm.street) &&
                userGender == userForm.userGender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password, matchingPassword, registerDate, birthday, city, street, userGender);
    }
}

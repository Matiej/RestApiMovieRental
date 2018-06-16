package pl.testaarosa.movierental.form.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserGender;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UserFormDto {

    @NotEmpty
    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String name;
    @NotEmpty
    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String surname;
    @Email
    @NotEmpty
    @Size(min = 5, message = "Yours email address is expected here")
    private String email;
    @NotEmpty
    @Size(min = 4, message = "just type password")
    private String password;
    private LocalDateTime registerDate;
    @Size(min = 10, max = 10, message = "The year must entered in this way (yyyy-MM-dd)")
    @NotEmpty
    private String brithday;
    private String city;
    private String street;
    private UserGender userGender;

    public UserFormDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

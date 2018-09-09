package pl.testaarosa.movierental.form.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.validator.PasswordMatches;
import pl.testaarosa.movierental.validator.ValidEmail;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@PasswordMatches()
public class UserFormDto {

    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String name;
    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String surname;
    @ValidEmail
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @Size(min = 4, message = "password min size is 4")
    private String matchingPassword;
    private LocalDateTime registerDate;
    @Size(min = 10, max = 10, message = "The year must entered in this way (yyyy-MM-dd)")
    private String brithday;
    @NotEmpty
    private String city;
    @NotEmpty
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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
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

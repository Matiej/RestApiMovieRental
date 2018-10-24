package pl.testaarosa.movierental.form.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.validator.ValidEmail;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class UpdateUserFormDto {

    private Long id;
    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String name;
    @Size(min = 2, message = "I'm sorry dear user, name size must by min 2 chars here")
    private String surname;
    @ValidEmail
    @NotEmpty
    private String email;
    @JsonIgnore
    private LocalDateTime registerDate;
    @JsonIgnore
    private LocalDateTime lastUpdateDate;
    @JsonFormat(pattern = "date")
    @Size(min = 10, max = 10, message = "The year must entered in this way (yyyy-MM-dd)")
    private String birthday;
//    @NotEmpty
    private String zip;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    private UserGender userGender;

    public UpdateUserFormDto() {
    }

    public UpdateUserFormDto(Long id, String name, String surname, String email, LocalDateTime registerDate,
                             LocalDateTime lastUpdateDate, String birthday, String zip, String city, String street, UserGender userGender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registerDate = registerDate;
        this.lastUpdateDate = lastUpdateDate;
        this.birthday = birthday;
        this.zip = zip;
        this.city = city;
        this.street = street;
        this.userGender = userGender;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
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
        return registerDate;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserFormDto that = (UpdateUserFormDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(registerDate, that.registerDate) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                userGender == that.userGender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, registerDate, lastUpdateDate, birthday, zip, city, street, userGender);
    }

    @Override
    public String toString() {
        return "UpdateUserFormDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", birthday='" + birthday + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", userGender=" + userGender +
                '}';
    }
}

package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.UserDetails;

import java.time.LocalDateTime;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime registerDate;
    private UserDetails userDetails;

    public UserDto(Long id, String name, String surname, String email, LocalDateTime registerDate,
                   UserDetails userDetails) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registerDate = registerDate;
        this.userDetails = userDetails;
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
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}

package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate brithday;
    private String city;
    private String street;
    @Enumerated(EnumType.STRING)
    private UserGender userGender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserDetails() {
    }

    private UserDetails(UserDetailsBuilder userDetailsBuilder) {
        this.brithday = userDetailsBuilder.brithday;
        this.city = userDetailsBuilder.city;
        this.street = userDetailsBuilder.street;
        this.userGender = userDetailsBuilder.userGender;
        this.user = userDetailsBuilder.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public UserGender getUserGender() {
        return userGender;
    }

    public User getUser() {
        return user;
    }

    public static class UserDetailsBuilder {
        private LocalDate brithday;
        private String city;
        private String street;
        private UserGender userGender;
        private User user;

        public UserDetailsBuilder birthday(LocalDate brithday) {
            this.brithday = brithday;
            return this;
        }

        public UserDetailsBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserDetailsBuilder street(String street) {
            this.street = street;
            return this;
        }

        public UserDetailsBuilder userGender(UserGender userGender) {
            this.userGender = userGender;
            return this;
        }

        public UserDetailsBuilder user(User user){
            this.user = user;
            return this;
        }

        public UserDetails build(){
            return new UserDetails(this);
        }
    }
}

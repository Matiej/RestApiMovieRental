package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USER_DETAILS")
public class UserRentalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birthday;
    private String city;
    private String street;
    @Enumerated(EnumType.STRING)
    private UserGender userGender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserRentalDetails() {
    }

    private UserRentalDetails(UserDetailsBuilder userDetailsBuilder) {
        this.birthday = userDetailsBuilder.brithday;
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

    public LocalDate getBirthday() {
        return birthday;
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

    public static NeedBrithday builder() {
        return new UserDetailsBuilder();
    }

    private static class UserDetailsBuilder implements NeedBrithday, NeedCity, NeedStreet, NeedUserGender, CanBeBuild {
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

        public UserDetailsBuilder user(User user) {
            this.user = user;
            return this;
        }

        public UserRentalDetails build() {
            return new UserRentalDetails(this);
        }
    }

    public interface NeedBrithday {
        public NeedCity birthday(LocalDate brithday);
    }

    public interface NeedCity {
        NeedStreet city(String city);
    }

    public interface NeedStreet {
        NeedUserGender street(String street);
    }

    public interface NeedUserGender {
        CanBeBuild userGender(UserGender userGender);
    }

    public interface CanBeBuild {
        CanBeBuild user(User user);
        UserRentalDetails build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRentalDetails that = (UserRentalDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                userGender == that.userGender &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthday, city, street, userGender);
    }
}


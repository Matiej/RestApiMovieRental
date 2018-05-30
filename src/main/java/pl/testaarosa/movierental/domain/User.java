package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime registerDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private UserDetails userDetails;

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.email = userBuilder.email;
        this.userDetails = userBuilder.userDetails;
        this.registerDate = userBuilder.registerDate;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public static class UserBuilder{
        private String name;
        private String surname;
        private String email;
        private UserDetails userDetails;
        private LocalDateTime registerDate;

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public UserBuilder userDetails(UserDetails userDetails){
            this.userDetails = userDetails;
            return this;
        }

        public UserBuilder registerDate(LocalDateTime registerDate){
            this.registerDate = registerDate;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }


}

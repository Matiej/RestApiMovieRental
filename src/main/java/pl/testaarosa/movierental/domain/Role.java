package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> user = new HashSet<>();
}

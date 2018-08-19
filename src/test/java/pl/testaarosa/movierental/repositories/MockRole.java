package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.Role;

public class MockRole {

    public Role getRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("USER");
        return role;
    }
}

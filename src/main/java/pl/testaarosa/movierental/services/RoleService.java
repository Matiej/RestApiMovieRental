package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.Role;

public interface RoleService {

    Role findByName(String roleName);
}

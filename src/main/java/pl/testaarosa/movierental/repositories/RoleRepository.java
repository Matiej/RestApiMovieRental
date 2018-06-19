package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String roleName);
}

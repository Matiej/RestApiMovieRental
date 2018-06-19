package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();
    List<User> findAllBySurnameContaining(String surname);
    Optional<User> findByName(String userName);
    Optional<User> findByEmail(String email);
}

package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.form.UserForm;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(Long id);
    void add(UserForm userForm);
    List<User> findAllBySurname(String surname);
}

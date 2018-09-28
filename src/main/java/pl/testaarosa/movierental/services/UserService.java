package pl.testaarosa.movierental.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.form.UpdateUserForm;
import pl.testaarosa.movierental.form.UserForm;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();
    User findOne(Long id);
    User add(UserForm userForm);
    User update(UpdateUserForm updateUserForm, User remoteUser);
    List<User> findAllBySurname(String surname);
    User findRemoteUser(String remoteUser);
    UpdateUserForm findRemoteUserForUpdate(String remoteUser);
}

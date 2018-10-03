package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.controller.EmailExistsException;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.form.UpdateUserForm;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.mapper.form.UpdateUserFormMapper;
import pl.testaarosa.movierental.mapper.form.UserFormMapper;
import pl.testaarosa.movierental.repositories.RoleRepository;
import pl.testaarosa.movierental.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFormMapper userFormMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encode;
    @Autowired
    private EmailNotifierService emailNotifierService;
    @Autowired
    private UserMovieService userMovieService;
    @Autowired
    private UpdateUserFormMapper updateUserFormMapper;
    @Autowired
    private MovieWishService movieWishService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    @Override
    public User add(UserForm userForm) throws EmailExistsException {
        if (isAddUserExist(userForm.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: "
                            + userForm.getEmail());
        }
        User user = userFormMapper.mapToUser(userForm);
        UserRentalDetails userRentalDetails = userFormMapper.mapToUserDetails(userForm);
        user.setUserRentalDetails(userRentalDetails);
        user.getUserRentalDetails().setUser(user);
        user.setEnabled(true);
        user.setPassword(encode.encode(userForm.getPassword()));
        user.setMatchingPassword(encode.encode(userForm.getMatchingPassword()));
        Role role = roleRepository.findByName("USER");
        user.setRole(role);
        userRepository.save(user);
        movieWishService.createMowieWish(user);
        emailNotifierService.sendEmailToNewUser(userForm);
        return user;
    }

    @Transactional
    @Override
    public User update(UpdateUserForm updateUserForm, User remoteUser) throws EmailExistsException {
        User user = updateUserFormMapper.mapToUser(updateUserForm, remoteUser);
        if (isUpdateUserExist(user.getId(), updateUserForm.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: " + updateUserForm.getEmail());
        }
        UserRentalDetails userRentalDetails = updateUserFormMapper.mapToUserDetails(updateUserForm, remoteUser);
        user.setUserRentalDetails(userRentalDetails);
        user.getUserRentalDetails().setUser(user);
        userRepository.save(user);
        emailNotifierService.sendEmailToUpdatedUser(updateUserForm);
        return user;
    }

    private boolean isAddUserExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return (user.isPresent());
    }

    private boolean isUpdateUserExist(Long id, String remoteEmail) {
        return userRepository.getUsersToCheckEmailExist(id).stream().anyMatch(u -> u.getEmail().equals(remoteEmail));
    }

    @Override
    public List<User> findAllBySurname(String surname) {
        return userRepository.findAllBySurnameContaining(surname);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No user: " + username + " found."));
//        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        return user.get();
    }

    @Override
    public User findRemoteUser(String remoteUser) {
        return userRepository.findRemoteUser(remoteUser);
    }

    @Override
    public UpdateUserForm findRemoteUserForUpdate(String remoteUser) {
        return updateUserFormMapper.mapToUpdateUserForm(findRemoteUser(remoteUser));
    }
}

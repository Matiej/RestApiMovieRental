package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.controller.EmailExistsException;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.form.UserForm;
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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User add(UserForm userForm) throws EmailExistsException {
        if(isUserExist(userForm.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: "
                            +  userForm.getEmail());
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
        emailNotifierService.sendEmail(userForm);
        return user;
    }

    private boolean isUserExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return (user.isPresent());
    }

    @Override
    public List<User> findAllBySurname(String surname) {
        return userRepository.findAllBySurnameContaining(surname);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        user.orElseThrow(()-> new UsernameNotFoundException("No user: " + username + " found."));
//        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        return user.get();
    }

    @Override
    public User findRemoteUser(String remoteUser){
        return userRepository.findRemoteUser(remoteUser);
    }
}

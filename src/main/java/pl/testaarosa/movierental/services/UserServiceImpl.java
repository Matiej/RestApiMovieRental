package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.cfg.AdminConfig;
import pl.testaarosa.movierental.domain.Mail;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.mapper.form.UserFormMapper;
import pl.testaarosa.movierental.repositories.RoleRepository;
import pl.testaarosa.movierental.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFormMapper userFormMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encode;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User add(UserForm userForm) {
        User user = userFormMapper.mapToUser(userForm);
        UserDetails userDetails = userFormMapper.mapToUserDetails(userForm);
        user.setUserDetails(userDetails);
        user.getUserDetails().setUser(user);
        user.setEnabled(true);
        user.setPassword(encode.encode(userForm.getPassword()));
        Role role = roleRepository.findByName("USER");
        user.setRole(role);
        userRepository.save(user);
        sendEmail(userForm);
        return user;
    }

    //TODO coś tutaj ładniej zrobić bo syfiasto jest, przeniesc do EmailService?
    private void sendEmail(UserForm userForm) {
        String subject = "Welcome " + userForm.getName() + ", Testaarosa movierental app created Yours account";

        StringBuilder message = new StringBuilder("Yours account created as above: " + "\n"
                + "Name: " + userForm.getName() + ",  surname: " + userForm.getSurname() + "\n"
                + "City: " + userForm.getCity() + ",  street: " + userForm.getStreet() + "\n"
                + " ** Birthday: " +userForm.getBrithday() + "\n"
                + "User email: " + userForm.getEmail() + " \n Date of registration: " + userForm.getRegisterDate() + "\n\n"
                + "############################################## \n" + "YOU CAN FIND ME HERE:  http://www.testaarosa.pl");

                ofNullable(userForm).ifPresent(c-> emailService.send(new Mail(
                c.getEmail(), subject, message.toString(), adminConfig.getAdminMail())));
    }

    @Override
    public List<User> findAllBySurname(String surname) {
        return userRepository.findAllBySurnameContaining(surname);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        user.orElseThrow(()-> new UsernameNotFoundException("No user: " + username + " found."));
//        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        return user.get();
    }
}

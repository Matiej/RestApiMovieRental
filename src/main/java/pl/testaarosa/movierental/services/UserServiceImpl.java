package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.mapper.form.UserFormMapper;
import pl.testaarosa.movierental.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFormMapper userFormMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void add(UserForm userForm) {
        User user = userFormMapper.mapToUser(userForm);
        UserDetails userDetails = userFormMapper.mapToUserDetails(userForm);
        user.setUserDetails(userDetails);
        user.getUserDetails().setUser(user);
        userRepository.save(user);
    }

}

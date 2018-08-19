package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.testaarosa.movierental.controller.EmailExistsException;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.mapper.form.UserFormMapper;
import pl.testaarosa.movierental.repositories.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTestSuit {

    private MockUser mockUser = new MockUser();
    private MockUserForm mockUserForm = new MockUserForm();
    private MockRole role = new MockRole();

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserFormMapper userFormMapper;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private EmailNotifierService emailNotifierService;

    @Test
    public void testFindAll() {
        //given
        List<User> expectUserList = mockUser.mockUser();
        when(userRepository.findAll()).thenReturn(expectUserList);
        //when
        List<User> result = userService.findAll();
        //then
        assertEquals(expectUserList, result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindOne() {
        //given
        User expectUser = mockUser.mockUser().get(0);
        User notExpectUser = mockUser.mockUser().get(1);
        when(userRepository.findOne(1L)).thenReturn(expectUser);
        //whne
        User result = userService.findOne(1L);
        //then
        assertEquals(expectUser, result);
        assertNotEquals(notExpectUser, result);
        assertEquals("znikenson@gmail.com", result.getEmail());
    }

    @Test
    public void testAddExistEmail() {
        //given
        List<UserForm> userFormList = mockUserForm.mockFormList();
        List<User> userList = mockUser.mockUser();
        when(userFormMapper.mapToUser(userFormList.get(0))).thenReturn(userList.get(0));
        when(userFormMapper.mapToUserDetails(userFormList.get(0))).thenReturn(userList.get(0).getUserRentalDetails());
        when(roleRepository.findByName("USER")).thenReturn(role.getRole());
        doNothing().when(emailNotifierService).sendEmail(userFormList.get(0));
        when(userRepository.findByEmail(userFormList.get(0).getEmail()))
                .thenReturn(java.util.Optional.ofNullable(userList.get(0)));
        when(userRepository.save(userList.get(0))).thenReturn(userList.get(0));
        //when
        //then
        try {
            User result = userService.add(userFormList.get(0));
            fail("There is an account with that email address: znikenson@gmail.com");
        } catch (EmailExistsException e) {
            final String expectE = "There is an account with that email address: znikenson@gmail.com";
            assertEquals(expectE, e.getMessage());
        }
    }

    @Test
    public void testAddEmailNotExist() throws Exception {
        //given
        List<UserForm> userFormList = mockUserForm.mockFormList();
        List<User> userList = mockUser.mockUser();
        when(userRepository.findByEmail(userFormList.get(0).getEmail())).thenReturn(java.util.Optional.ofNullable(null));
        when(userFormMapper.mapToUser(userFormList.get(0))).thenReturn(userList.get(0));
        when(userFormMapper.mapToUserDetails(userFormList.get(0))).thenReturn(userList.get(0).getUserRentalDetails());
        when(roleRepository.findByName("USER")).thenReturn(role.getRole());
        doNothing().when(emailNotifierService).sendEmail(userFormList.get(0));
        when(userRepository.save(userList.get(0))).thenReturn(userList.get(0));
        //when
        User result = userService.add(userFormList.get(0));
        User expected = userList.get(0);
        //then
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected, result);
        assertNotEquals(userList.get(1).getName(), result.getName());
        verify(emailNotifierService, times(1)).sendEmail(userFormList.get(0));
    }

    @Test
    public void testFindAllBySurname() {
        //given
        String surname = "Wójcik11111";
        List<User> expect = mockUser.mockUser();
        when(userRepository.findAllBySurnameContaining(surname)).thenReturn(expect);
        //when
        List<User> resutlt = userService.findAllBySurname(surname);
        //then
        assertEquals(expect,resutlt);
        assertEquals(2,resutlt.size());
    }

    @Test
    public void testLoadUserbyUserEmail() {
        //given
        String email = "email";
        User expectUser = mockUser.mockUser().get(0);
        when(userRepository.findByEmail(email)).thenReturn(java.util.Optional.ofNullable(expectUser));
        //when
        UserDetails resultUser = userService.loadUserByUsername(email);
        //then
        assertEquals(expectUser,resultUser);
        assertEquals(expectUser.getEmail(),resultUser.getUsername());
        assertNotEquals(mockUser.mockUser().get(1),resultUser);
    }

    @Test
    public void testFindRemoteUser() {
        //given
        String remoteUserek = "RemoteUserek";
        User expectUser = mockUser.mockUser().get(0);
        when(userRepository.findRemoteUser(remoteUserek)).thenReturn(expectUser);
        //when
        User remoteUser = userService.findRemoteUser(remoteUserek);
        //then
        assertEquals(expectUser,remoteUser);
        assertNotEquals(mockUser.mockUser().get(1),remoteUser);
        assertTrue(remoteUser.isEnabled());
    }

}

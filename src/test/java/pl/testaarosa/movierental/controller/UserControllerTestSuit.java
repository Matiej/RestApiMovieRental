package pl.testaarosa.movierental.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.repositories.MockUser;
import pl.testaarosa.movierental.repositories.MockUserDto;
import pl.testaarosa.movierental.repositories.MockUserFormDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserController.class)
@WebAppConfiguration
public class UserControllerTestSuit {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserFacade userFacade;

    private MockMvc mockMvc;
    private MockUser mockUser = new MockUser();
    private MockUserDto mockUserDto = new MockUserDto();
    private List<UserDto> userDtoList;
    private MockUserFormDto mockUserFormDto = new MockUserFormDto();
    private List<User> mockUsers;
    private List<UserFormDto> userFormDtos;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockUsers = mockUser.mockUser();
        userFormDtos = mockUserFormDto.mockFormDtoList();
        userDtoList = mockUserDto.mockUserDto();
    }

    @Test
    public void shouldAddUserWhenFormIsCorrect() throws Exception {
        //given
        UserFormDto userFormDto = userFormDtos.get(0);
        User user = mockUsers.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(user);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/users/adduser")
                .accept(MediaType.TEXT_HTML)
                .param("name", "Maciek")
                .param("surname", "Wójcik")
                .param("email", "znikenson@gmail.com")
                .param("password", "password")
                .param("matchingPassword", "password")
                .param("brithday", "1988-02-11")
                .param("city", "Breslaw")
                .param("street", "Zamkowa")
                .param("userGender", "MALE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("userFormDto", user))
                .andExpect(view().name("successRegister"));
        User result = userFacade.addUserAndWish(userFormDto);
        //then
        verify(userFacade, times(2)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
        assertEquals(user, result);
    }

    @Test
    public void shouldAddUserWhenFormIsWrong() throws Exception {
        //given
        UserFormDto userFormDto = userFormDtos.get(0);
        User user = mockUsers.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(user);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/users/adduser")
                .accept(MediaType.TEXT_HTML)
                .param("name", "Maciek")
                .param("surname", "Wójcik")
                .param("email", "znikenson@gmail.com")
                .param("password", "password")
                .param("matchingPassword", "password")
                .param("brithday", "1988-02-11")
                .param("street", "Zamkowa")
                .param("userGender", "MALE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("userForm"));
        User result = userFacade.addUserAndWish(userFormDto);
        //then
        verify(userFacade, times(1)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
        assertEquals(user, result);
    }

    @Test
    public void testShowForm() throws Exception {
        //given
        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/users/adduser"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userFormDto", new UserFormDto()))
                .andExpect(view().name("userForm"));
    }

    @Test
    public void shouldAddUserNWhenFormIsCorrect() throws Exception {
        //given
        UserFormDto userFormDto = userFormDtos.get(0);
        User user = mockUsers.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(user);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/users/adduser_n")
                .accept(MediaType.TEXT_HTML)
                .param("name", "Maciek")
                .param("surname", "Wójcik")
                .param("email", "znikenson@gmail.com")
                .param("password", "password")
                .param("matchingPassword", "password")
                .param("brithday", "1988-02-11")
                .param("city", "Breslaw")
                .param("street", "Zamkowa")
                .param("userGender", "MALE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("userFormDto", user))
                .andExpect(view().name("successRegister"));
        User result = userFacade.addUserAndWish(userFormDto);
        //then
        verify(userFacade, times(2)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
        assertEquals(user, result);
    }

    @Test
    public void shouldAddUserNWhenFormIsWrong() throws Exception {
        //given
        UserFormDto userFormDto = userFormDtos.get(0);
        User user = mockUsers.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(user);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/users/adduser_n")
                .accept(MediaType.TEXT_HTML)
                .param("name", "Maciek")
                .param("surname", "Wójcik")
                .param("email", "znikenson@gmail.com")
                .param("password", "password")
                .param("matchingPassword", "password")
                .param("brithday", "1988-02-11")
                .param("userGender", "MALE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("userForm_n"));
        User result = userFacade.addUserAndWish(userFormDto);
        //then
        verify(userFacade, times(1)).addUserAndWish(userFormDto);
        assertEquals(user, result);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testShowForm_N() throws Exception {
        //given
        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/users/adduser_n"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userFormDto", new UserFormDto()))
                .andExpect(view().name("userForm_n"));
    }

    @Test
    public void testShowUsers() throws Exception {
        //given
        when(userFacade.findAllUsers()).thenReturn(userDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/users/userslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("users", userDtoList))
                .andExpect(view().name("userList"));
        List<UserDto> result = userFacade.findAllUsers();
        //then
        assertEquals(userDtoList, result);
        verify(userFacade, times(2)).findAllUsers();
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testGetLoginView() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/users/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("login_u"));
    }

    @Test
    public void testGetLoginViewNewUser() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/users/login_new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testAccesDenied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/accesdenied"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("accesdenided"));
    }

    @Test
    public void testLogoutPage() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/users/logout"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("logout_"));
    }
}

package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockUpdateUserFormDto;
import pl.testaarosa.movierental.repositories.MockUserDto;
import pl.testaarosa.movierental.repositories.MockUserFormDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/users/";
    private MockMvc mockMvc;
    private MockUserDto mockUserDto;
    private List<UserDto> userDtoList;
    private MockUserFormDto mockUserFormDto;
    private List<UserFormDto> userFormDtoList;
    private MockUpdateUserFormDto updateUserFormDto;
    private List<UpdateUserFormDto> updateUserFormDtoList;

    @InjectMocks
    private UserControllerRest userControllerRest;

    @Mock
    private UserFacade userFacade;

    @Before
    public void init() {
        mockMvc = standaloneSetup(userControllerRest).build();
        mockUserDto = new MockUserDto();
        userDtoList = mockUserDto.mockUserDto();
        mockUserFormDto = new MockUserFormDto();
        userFormDtoList = mockUserFormDto.mockFormDtoList();
        updateUserFormDto = new MockUpdateUserFormDto();
        updateUserFormDtoList = updateUserFormDto.updateUserFormDtoList();
    }

    @Test
    public void testCreateUserAccount() throws Exception {
        //given
        UserDto userDto = userDtoList.get(0);
        UserFormDto userFormDto = userFormDtoList.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(userDto);
        //when
        mockMvc.perform(post(MAPPING + "add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(converter.jsonInString(userFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userDto)));
        verify(userFacade, times(1)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testCreateUserAccount404() throws Exception {
        //given
        UserDto userDto = userDtoList.get(0);
        UserFormDto userFormDto = userFormDtoList.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(userDto);
        //when
        mockMvc.perform(post(MAPPING + "addStatus404")
                .accept(MediaType.APPLICATION_JSON)
                .content(converter.jsonInString(userFormDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
        verify(userFacade, times(0)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testCreateUserAccount400() throws Exception {
        //given
        UserFormDto userFormDto = userFormDtoList.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenThrow(new UsernameNotFoundException("ADD USER ERROR"));
        //when
        mockMvc.perform(post(MAPPING + "add")
                .accept(MediaType.APPLICATION_JSON)
                .content(converter.jsonInString(userFormDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
        verify(userFacade, times(1)).addUserAndWish(userFormDto);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testUpdateUserAccount() throws Exception {
        //given
        UserDto remoteUser = userDtoList.get(0);
        UserDto userDto = userDtoList.get(1);
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        updateUserFormDto.setRegisterDate(null);
        updateUserFormDto.setLastUpdateDate(null);
        updateUserFormDto.setId(null);
        when(userFacade.findRemoteUser(null)).thenReturn(remoteUser);
        when(userFacade.updateUser(updateUserFormDto, remoteUser)).thenReturn(userDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.put(MAPPING + "update")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(converter.jsonInString(updateUserFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userDto)));
        //then
        verify(userFacade, times(1)).findRemoteUser(null);
        verify(userFacade, times(1)).updateUser(updateUserFormDto,remoteUser);
        verifyNoMoreInteractions(userFacade);

    }

    @Test
    public void testUpdateUserAccount404() throws Exception {
        //given
        UserDto remoteUser = userDtoList.get(0);
        UserDto userDto = userDtoList.get(1);
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        updateUserFormDto.setRegisterDate(null);
        updateUserFormDto.setLastUpdateDate(null);
        updateUserFormDto.setId(null);
        when(userFacade.findRemoteUser(null)).thenReturn(remoteUser);
        when(userFacade.updateUser(updateUserFormDto, remoteUser)).thenReturn(userDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.put(MAPPING + "updateStatus404")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("request", remoteUser)
                .content(converter.jsonInString(updateUserFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(404))
                .andReturn();
        //then
        verify(userFacade, times(0)).findRemoteUser(null);
        verify(userFacade, times(0)).updateUser(updateUserFormDto,remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testUpdateUserAccount401() throws Exception {
        //given
        UserDto remoteUser = userDtoList.get(0);
        UserDto userDto = userDtoList.get(1);
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        updateUserFormDto.setRegisterDate(null);
        updateUserFormDto.setLastUpdateDate(null);
        updateUserFormDto.setId(null);
        when(userFacade.findRemoteUser(null)).thenThrow(new UsernameNotFoundException("NO USER ERROR"));
        when(userFacade.updateUser(updateUserFormDto, remoteUser)).thenReturn(userDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.put(MAPPING + "update")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("request", remoteUser)
                .content(converter.jsonInString(updateUserFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(401))
                .andReturn();
        //then
        verify(userFacade, times(1)).findRemoteUser(null);
        verify(userFacade, times(0)).updateUser(updateUserFormDto,remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldFindAllUsers() throws Exception {
        //given
        when(userFacade.findAllUsers()).thenReturn(userDtoList);
        //when
        mockMvc.perform(get(MAPPING+"allusers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(userDtoList)));
        //then
        verify(userFacade, times(1)).findAllUsers();
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldFindAllUsers404() throws Exception {
        //given
        when(userFacade.findAllUsers()).thenReturn(userDtoList);
        //when
        mockMvc.perform(get(MAPPING+"allusersStatus404"))
                .andExpect(status().is(404))
                .andReturn();
        //then
        verify(userFacade, times(0)).findAllUsers();
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteUser() throws Exception {
        //given
        UserDto userDto = userDtoList.get(0);
        when(userFacade.findUserById(1L)).thenReturn(userDto);
        //then
        mockMvc.perform(delete(MAPPING+"delusernbyid")
        .param("userId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(userDto)));
        verify(userFacade, times(1)).findUserById(1L);
        verify(userFacade, times(1)).deleteUser(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteUser404() throws Exception {
        //given
        UserDto userDto = userDtoList.get(0);
        when(userFacade.findUserById(1L)).thenReturn(userDto);
        //then
        mockMvc.perform(delete(MAPPING+"delusernbyidStatus404")
                .param("userId", String.valueOf(1L)))
                .andExpect(status().is(404))
                .andReturn();
        verify(userFacade, times(0)).findUserById(1L);
        verify(userFacade, times(0)).deleteUser(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteRemoteUser() throws Exception {
        //given
        UserDto value = userDtoList.get(0);
        when(userFacade.findRemoteUser(null)).thenReturn(value);
        //when
        mockMvc.perform(delete(MAPPING+"delremonteuser"))
                .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(value)));
        //then
        verify(userFacade, times(1)).findRemoteUser(null);
        verify(userFacade, times(1)).deleteUser(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldDeleteRemoteUser404() throws Exception {
        //given
        UserDto value = userDtoList.get(0);
        when(userFacade.findRemoteUser(null)).thenReturn(value);
        //when
        mockMvc.perform(delete(MAPPING+"delremonteuserStatus404"))
                .andExpect(status().is(404))
                .andReturn();
        //then
        verify(userFacade, times(0)).findRemoteUser(null);
        verify(userFacade, times(0)).deleteUser(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldDeleteRemoteUser401() throws Exception {
        //given
        UserDto value = userDtoList.get(0);
        when(userFacade.findRemoteUser(null)).thenThrow(new UsernameNotFoundException("USER ERROR"));
        //when
        mockMvc.perform(delete(MAPPING+"delremonteuser"))
                .andExpect(status().is(401))
                .andReturn();
        //then
        verify(userFacade, times(1)).findRemoteUser(null);
        verify(userFacade, times(0)).deleteUser(1L);
        verifyNoMoreInteractions(userFacade);
    }
}

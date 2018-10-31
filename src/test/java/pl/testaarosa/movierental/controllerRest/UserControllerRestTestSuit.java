package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockUserDto;
import pl.testaarosa.movierental.repositories.MockUserFormDto;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
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
    }

    @Test
    public void testCreateUserAccount() throws Exception {
        //given
        UserDto userDto = userDtoList.get(0);
        UserFormDto userFormDto = userFormDtoList.get(0);
        userFormDto.setRegisterDate(LocalDateTime.now());
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(userDto);
        //when
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(MAPPING + "add")
                .accept(MediaType.APPLICATION_JSON)
                .content(converter.jsonInString(userFormDto))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
//                .param("name", "Maciek")
//                .param("surname", "Wójcik")
//                .param("email", "znikenson@gmail.com")
//                .param("password", "password")
//                .param("matchingPassword", "password")
//                .param("birthday","1988-02-11")
//                .param("city", "Breslaw")
//                .param("street", "Zamkowa")
//                .param("userGender", "MALE"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(userDto)));
        verify(userFacade, times(1)).findRemoteUser("znikenson@gmail.com");
        verifyNoMoreInteractions(userFacade);
    }

}

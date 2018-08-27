package pl.testaarosa.movierental.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTestSuit {

    @InjectMocks
    private WelcomeController welcomeController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
    }

    @Test
    public void testStartMyApp() {
        //given
        //then
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(view().name("index"))
                    .andExpect(MockMvcResultMatchers.view().name("index"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHeroku() {
        //given
        //when
        //then
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(view().name("index_n"))
                    .andExpect(MockMvcResultMatchers.view().name("index_n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStartMyAppN() {
        //given
        //when
        //then
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/home_n"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(view().name("index_n"))
                    .andExpect(MockMvcResultMatchers.view().name("index_n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package pl.testaarosa.movierental.controllerRest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerWelcomeControllerTestSuit {

    private MockMvc mockMvc;

    @InjectMocks
    private SwaggerWelcomeController welcomeController;

    @Test
    public void shouldRedirectToUi() throws Exception {
        mockMvc = standaloneSetup(welcomeController).build();
        mockMvc.perform(get("/sw"))
                .andExpect(redirectedUrl("/swagger-ui.html#/"));
    }
}

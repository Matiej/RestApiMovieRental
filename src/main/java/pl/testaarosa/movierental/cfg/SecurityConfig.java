package pl.testaarosa.movierental.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.testaarosa.movierental.services.UserService;
import pl.testaarosa.movierental.services.FlashMessage;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    private static final String[] AUTH_WISHLIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui.html/**",
            "/swagger-ui.html#/**",
            "/mrapi/",
            "/mrapi/**",
            "/swagger-ui.html#/swagger-welcome-controller/**",
            "/v2/api-docs",
            "/webjars/**",
            "/sw",
            "/users/adduser_n",
            "/online/movielist_n",
            "/online/onlinedetail_n",
            "/home_n",
            "/users/login",
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void confGlobalSec(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }


    public AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> {
            response.sendRedirect("/home");
            request.getSession().setAttribute("flash", new FlashMessage("Login successful", FlashMessage.Status.SUCCESS));
            authentication.getDetails();
        };
    }

    public AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
            request.getSession().setAttribute("flash", new FlashMessage("Wrong login or password", FlashMessage.Status.FAILURE));
            response.sendRedirect("/users/login");
        };
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(AUTH_WISHLIST).permitAll()
//                .antMatchers("/**/*").denyAll()
                .anyRequest().hasAnyAuthority("ADMIN", "USER", "TESTER")
                .and()
                .formLogin()
                .loginPage("/users/login").permitAll()
                .successHandler(loginSuccessHandler())
                .failureHandler(loginFailureHandler())
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/users/logout");
    }


}

package pl.testaarosa.movierental.cfg;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    protected static String CLIENT_ID = "swAdmin";
    protected static String CLIENT_SECRET = "1234";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .host("http://localhost:8088")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .paths((PathSelectors.ant("/mrapi/**")))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder().title("movierental")
                .description("Movie rental simulation")
                .version("0.1")
                .contact(new Contact("Matiej", "www.testaarosa.pl", "maciek@testaarosa.pl"))
                .license("Apache License 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
//
//    @Bean
//    public SecurityConfiguration securityConfiguration() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId(CLIENT_ID)
//                .clientSecret(CLIENT_SECRET)
//                .scopeSeparator(" ")
//                .useBasicAuthenticationWithAccessCodeGrant(true)
//                .build();
//    }
//
//    private AuthorizationScope[] scope() {
//        return new AuthorizationScope[]{
//                new AuthorizationScope("read", "for read operations"),
//                new AuthorizationScope("write", "for write operations"),
//                new AuthorizationScope("movieRental", "Access for Movies")
//        };
//    }
//
//    private SecurityScheme securityScheme() {
//        GrantType grantType = new AuthorizationCodeGrantBuilder()
//                .tokenEndpoint(new TokenEndpoint("server" + "/token", "oauthtoken"))
//                .tokenRequestEndpoint(new TokenRequestEndpoint("server" + "/authorize", CLIENT_ID, CLIENT_SECRET))
//                .build();
//
//        SecurityScheme outh = new OAuthBuilder()
//                .name("spring_oauth")
//                .grantTypes(Arrays.asList(grantType))
//                .scopes(Arrays.asList(scope()))
//                .build();
//        return outh;
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scope())))
//                .forPaths(PathSelectors.regex("/sw.*"))
//                .build();
//    }
}
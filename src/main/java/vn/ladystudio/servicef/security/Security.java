package vn.ladystudio.servicef.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Security {

    @Value("${project_f.security.public-urls: ''}")
    private String publicUrls;

    @Bean
    public WebSecurityCustomizer webSecurityConfigurer() {
        return (web) -> web
                .ignoring()
                .requestMatchers((request) -> {
                    String[] publicUrls = this.publicUrls.replaceAll(" ", "").split(",");
                    for (String publicUrl : publicUrls) {
                        if (request.getServletPath().startsWith(publicUrl)) {
                            return true;
                        }
                    }
                    return false;
                });
    }

}


package cl.voteclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/css/**", "/js/**", "/img/**", "/votations/**",
                        "/institutions/**", "/votes/**", "/voters/**", "/census/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/#!/votantes/login")
                .loginProcessingUrl("/voters/login")
                .defaultSuccessUrl("/#!/votantes/inicio")
                .failureUrl("/#!/votantes/login?error=true")
                .and()
            .logout()
                .permitAll();
    }
}


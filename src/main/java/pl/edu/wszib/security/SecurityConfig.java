package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.edu.wszib.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()


        .authorizeRequests()

                .antMatchers("/").authenticated()
                .antMatchers("/rentAppPage/").hasRole("ADMIN")
                .antMatchers("/addVehicle").hasRole("ADMIN")
                .antMatchers("/getVehicle").hasRole("ADMIN")
                .antMatchers("/removeVehicle").hasRole("ADMIN")
                .antMatchers("/updateVehicle").hasRole("ADMIN")
                .antMatchers("/allUser").hasRole("ADMIN")
                .antMatchers("/resultGet").hasRole("ADMIN")
                .antMatchers("/addUser").hasRole("ADMIN")
                .antMatchers("/getUser").hasRole("ADMIN")
                .antMatchers("/updateUser").hasRole("ADMIN")
                .antMatchers("/removeUserById").hasRole("ADMIN")
                .antMatchers("/price").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allScooter").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allCar").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allMotorBike").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/allBike").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/distance").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/user").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rent").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rent2").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/buy").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/buy2").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/thanks").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/rentAppPage").hasAnyAuthority( "ROLE_ADMIN", "ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                 .logoutSuccessUrl("/");
        ;


        http.sessionManagement()
                //.expiredUrl("/sessionExpired.html")
                .invalidSessionUrl("/login.html");
    }



}

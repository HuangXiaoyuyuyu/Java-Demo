package SpringBootSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userlogin");

        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //auth.inMemoryAuthentication()
        // .passwordEncoder(new BCryptPasswordEncoder())
        // .withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER")
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("hxy")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and()
                .withUser("lzh")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3");
    }
}

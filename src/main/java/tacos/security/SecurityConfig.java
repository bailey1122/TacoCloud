package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    // in-memory user store
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("buzz")
//                .password("infinity")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("woody")
//                .password("bullseye")
//                .authorities("ROLE_USER");
//    }


////     jdbc-based user store
//    @Autowired
//    DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled from Users " +
//                        "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities " +
//                        "where username=?");
//    }
//
//    public static final String DEF_USERS_BY_USERNAME_QUERY =
//            "select username,password,enabled " +
//                    "from users " +
//                    "where username = ?";
//    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
//            "select username,authority " +
//                    "from authorities " +
//                    "where username = ?";
//    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
//            "select g.id, g.group_name, ga.authority " +
//                    "from groups g, group_members gm, group_authorities ga " +
//                    "where gm.username = ? " +
//                    "and g.id = ga.group_id " +
//                    "and g.id = gm.group_id";


//    // ldap-backed user store
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("passcode");
//    }


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }
//
//    public static void main(String[] args) {
//        System.out.println(BCrypt.hashpw("user-password", BCrypt.gensalt(4)));
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/design", "/orders")
//                .hasRole("ROLE_USER")
//                .antMatchers("/", "/**").permitAll();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();




//                .authorizeRequests()
//                .antMatchers("/design", "/orders")
//                .access("hasRole('ROLE_USER')")
//                .antMatchers("/", "/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/design", true)
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");

//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/authenticate")
//                .usernameParameter("user")
//                .passwordParameter("pwd");
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/design", "/orders")
//                .access("hasRole('ROLE_USER') && " +
//                        "T(java.util.Calendar).getInstance().get(" +
//                        "T(java.util.Calendar).DAY_OF_WEEK) == " +
//                        "T(java.util.Calendar).TUESDAY")
//                .antMatchers("/", "/**").permitAll();
//    }

}



















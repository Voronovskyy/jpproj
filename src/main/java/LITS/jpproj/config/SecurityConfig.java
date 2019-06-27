package LITS.jpproj.config;

import LITS.jpproj.security.JwtAuthenticationEntryPoint;
import LITS.jpproj.security.JwtAuthenticationTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    protected JwtAuthenticationEntryPoint unauthorizedHandler;

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        log.debug("Exception in class SecurityConfig (authenticationManagerBean)");
        return super.authenticationManagerBean();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        log.debug("Exception in class SecurityConfig (globalUserDetails)");
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        log.debug("Exception in class SecurityConfig (authenticationTokenFilterBean)");
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.debug("Exception in class SecurityConfig (configure)");
        httpSecurity
                .cors().and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/**/login").permitAll()
//                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .antMatchers("/api/AllUsers").hasRole("ADMIN")
                .anyRequest().authenticated();

        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().cacheControl();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin", "X-Requested-With", "Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}

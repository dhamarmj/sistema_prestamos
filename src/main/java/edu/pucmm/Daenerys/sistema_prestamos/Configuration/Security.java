package edu.pucmm.Daenerys.sistema_prestamos.Configuration;

import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.UserRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Service.Security.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

//@Configurable
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security {//extends WebSecurityConfigurerAdapter {
//    //Configuación para la validación del acceso modo JDBC
//    @Autowired
//    private DataSource dataSource;
////    @Value("${query.user-jdbc}")
////    private String queryUsuario;
////    @Value("${query.role-jdbc}")
////    private String queryRol;
//
//
//    //Opción JPA
//    @Autowired
//    private SecurityServices securityServices;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //Clase para encriptar contraseña
//        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//
//       /* //Cargando los usuarios en memoria.
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("usuario")
//                .password("1234")
//                .roles("USER")
//                .and()
//                .withUser("vendedor")
//                .password("1234")
//                .roles("VENDEDOR");*/
//
//
//        /*//Configuración para acceso vía JDBC
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery(queryUsuario)
//                .authoritiesByUsernameQuery(queryRol)
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder);*/
//
//        //Configuración JPA.
//        auth
//                .userDetailsService(securityServices)
//                .passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    /*
//     * Permite configurar las reglas de seguridad.
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //Marcando las reglas para permitir unicamente los usuarios
//        http
//                .authorizeRequests()
//                .antMatchers("/","/css/**", "/js/**", "/actuator/**").permitAll() //permitiendo llamadas a esas urls.
//                .antMatchers("/dbconsole/**").permitAll()
//                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
//                //.anyRequest().authenticated() //cualquier llamada debe ser validada
    //                .and()
    //                .formLogin()
    //                .loginPage("/login") //indicando la ruta que estaremos utilizando.
//               // .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//        //deshabilitando las seguridad contra los frame internos.
//        //Necesario para H2.
//        http.csrf().disable();
//        http.cors().disable();
//        http.headers().frameOptions().disable();
//    }
}

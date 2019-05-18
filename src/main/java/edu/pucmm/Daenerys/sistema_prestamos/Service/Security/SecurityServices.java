package edu.pucmm.Daenerys.sistema_prestamos.Service.Security;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Role;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.User;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.RolRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityServices implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //cualquier cosa...

    /**
     * Creando el usuario por defecto y su rol.
     */
    public void crearUsuarios(){
        //System.out.println("Creación del usuario y rol en la base de datos");
        Role rolAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        rolRepository.save(rolAdmin);
        rolRepository.save(roleUser);

        User user = new User("user", bCryptPasswordEncoder.encode("user"),new HashSet<>(Arrays.asList(roleUser)));
        User admin = new User("admin", bCryptPasswordEncoder.encode("admin"),new HashSet<>(Arrays.asList(rolAdmin)));

        userRepository.save(admin);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities);
    }

}

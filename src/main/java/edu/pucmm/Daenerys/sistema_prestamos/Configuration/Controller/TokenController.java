package edu.pucmm.Daenerys.sistema_prestamos.Configuration.Controller;

import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JwtUser;
import edu.pucmm.Daenerys.sistema_prestamos.Configuration.SecurityP.JWTGenerator;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.User;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.ClientRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JWTGenerator jwtGenerator;
    private User client =null;

    @Autowired
    private UserRepository userRepository;

    public TokenController(JWTGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public User generateToken(@RequestBody final JwtUser jwtUser){
        Optional<User> c = userRepository.findById(jwtUser.getId());
        if(c.isPresent())
        {
            client = c.get();
            client.setToken(jwtGenerator.generate(jwtUser));
            userRepository.save(client);
        }
        return client;
    }

}

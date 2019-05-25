package edu.pucmm.Daenerys.sistema_prestamos.Configuration.Controller;

import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JwtUser;
import edu.pucmm.Daenerys.sistema_prestamos.Configuration.SecurityP.JWTGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JWTGenerator jwtGenerator;

    public TokenController(JWTGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public String generateToken(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);

    }

}

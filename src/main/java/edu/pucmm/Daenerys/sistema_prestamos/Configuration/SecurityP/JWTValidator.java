package edu.pucmm.Daenerys.sistema_prestamos.Configuration.SecurityP;

import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JWTValidator {
    private String secret = "sistemaprestamosP10Camacho";

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

           jwtUser= new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Integer.parseInt((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));


        }
        catch (Exception ex){
            System.out.println("EXCEPTION IN SECURITY" + ex.getMessage());

        }
        return jwtUser;
    }
}

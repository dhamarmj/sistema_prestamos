package edu.pucmm.Daenerys.sistema_prestamos.Configuration.SecurityP;

import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JWTAutenticationToken;
import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JWTUserDetails;
import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JWAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JWTValidator jwtValidator;


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        JWTAutenticationToken jwtAutenticationToken = (JWTAutenticationToken) authentication;
        String token = jwtAutenticationToken.getToken();
        JwtUser jwtUser = jwtValidator.validate(token);
        if (jwtUser == null)
            throw new RuntimeException("INCORRECT TOKEN");

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JWTUserDetails(jwtUser.getUsername(), jwtUser.getId(), token, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JWTAutenticationToken.class.isAssignableFrom(authentication));
    }
}

package edu.pucmm.Daenerys.sistema_prestamos.Configuration.SecurityP;

import edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models.JWTAutenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAutenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JWTAutenticationTokenFilter() {
        super("/ws/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String header = request.getHeader("Authorisation");
        if (header == null || !header.startsWith("Token"))
            throw new RuntimeException("JWT token is missing!");

        String authenticatioToken = header.substring(6);
        JWTAutenticationToken token = new JWTAutenticationToken(authenticatioToken);

        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}

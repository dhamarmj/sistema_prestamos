package edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JWTAutenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;
    public JWTAutenticationToken(String token) {
        super(null, null);
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials(){
        return null;
    }

    @Override
    public Object getPrincipal(){
        return null;
    }

}

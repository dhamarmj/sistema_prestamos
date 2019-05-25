package edu.pucmm.Daenerys.sistema_prestamos.Configuration.Models;

public class JwtUser {
    private String username;
    private int id;
    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRole(String role) {
        this.role=role;
    }
    public String getRole(){
        return this.role;
    }
}

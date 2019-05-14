package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Type;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String cedula;
    @Column(columnDefinition = "LONGTEXT")
    private String foto;

    public Client() {
    }
    public Client(String cedula, String fotoPath) {
        this.cedula = cedula;
        this.foto = fotoPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFotoPath() {
        return foto;
    }

    public void setFotoPath(String fotoPath) {
        this.foto = fotoPath;
    }
}

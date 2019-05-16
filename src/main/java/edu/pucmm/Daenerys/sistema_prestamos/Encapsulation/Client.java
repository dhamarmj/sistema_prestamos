package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Set;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String cedula;
    @Column(columnDefinition = "LONGTEXT")
    private String foto;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<Receipt> receipt;

    public Client() {
    }
    public Client(String cedula, String fotoPath) {
        this.cedula = cedula;
        this.foto = fotoPath;
    }

    public Client(String cedula, String foto, Set<Receipt> receipt) {
        this.cedula = cedula;
        this.foto = foto;
        this.receipt = receipt;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<Receipt> getReceipt() {
        return receipt;
    }

    public void setReceipt(Set<Receipt> receipt) {
        this.receipt = receipt;
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

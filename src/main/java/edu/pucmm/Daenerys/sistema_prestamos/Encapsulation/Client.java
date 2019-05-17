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
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String foto;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<Receipt> receipt;

    public Client() {
    }

    public Client(String cedula, String name, String foto) {
        this.cedula = cedula;
        this.foto = foto;
        this.name = name;
    }

    public Client(String cedula, String name, String foto, Set<Receipt> receipt) {
        this.cedula = cedula;
        this.foto = foto;
        this.receipt = receipt;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}

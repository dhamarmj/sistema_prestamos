package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double costxday;

    @Column(columnDefinition = "LONGTEXT")
    private String foto;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment")
    private Set<Receipt_detail> details;

    @ManyToOne
    private Subfamily subfamily;

    public Equipment() {
    }

    public Equipment(String name, int quantity, double costxday, String foto, Set<Receipt_detail> details, Subfamily subfamily) {
        this.name = name;
        this.quantity = quantity;
        this.costxday = costxday;
        this.foto = foto;
        this.details = details;
        this.subfamily = subfamily;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subfamily getSubfamily() {
        return subfamily;
    }

    public void setSubfamily(Subfamily subfamily) {
        this.subfamily = subfamily;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostxday() {
        return costxday;
    }

    public void setCostxday(double costxday) {
        this.costxday = costxday;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<Receipt_detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Receipt_detail> details) {
        this.details = details;
    }
}

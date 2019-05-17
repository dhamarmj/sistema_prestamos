package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Receipt implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private double ammount;

    @ManyToOne
    private Client client;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receipt")
    private Set<Receipt_detail> details;

    public Receipt() {
    }

    public Receipt(int id, Date date, double ammount, Client client, Set<Receipt_detail> details) {
        this.id = id;
        this.date = date;
        this.ammount = ammount;
        this.client = client;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Receipt_detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Receipt_detail> details) {
        this.details = details;
    }
}

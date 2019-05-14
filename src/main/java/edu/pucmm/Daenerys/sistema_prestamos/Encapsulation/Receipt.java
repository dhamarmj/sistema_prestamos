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

    @OneToOne
    private Client client;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receipt")
    private Set<Receipt_detail> details;




}

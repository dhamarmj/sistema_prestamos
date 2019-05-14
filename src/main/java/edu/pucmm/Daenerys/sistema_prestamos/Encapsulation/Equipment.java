package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String family;
    private String subfamily;
    private int quantity;
    private double costxday;

    @Column(columnDefinition = "LONGTEXT")
    private String foto;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment")
    private Set<Receipt_detail> details;


}

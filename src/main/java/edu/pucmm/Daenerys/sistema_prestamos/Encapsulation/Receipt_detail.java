package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Receipt_detail implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Date deliveryDate;
    private int quantity;
    private double ammount;

    @ManyToOne
    private Equipment equipment;






}

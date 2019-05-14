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

    @ManyToOne
    private Receipt receipt;

    public Receipt_detail() {
    }

    public Receipt_detail(Date deliveryDate, int quantity, double ammount, Equipment equipment, Receipt receipt) {
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.ammount = ammount;
        this.equipment = equipment;
        this.receipt = receipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}

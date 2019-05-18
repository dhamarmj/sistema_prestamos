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
    private boolean delivered;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private Receipt receipt;

    public Receipt_detail() {
    }

    public Receipt_detail(int quantity, double ammount, Equipment equipment, Receipt receipt) {
        this.quantity = quantity;
        this.ammount = ammount;
        this.equipment = equipment;
        this.receipt = receipt;
        this.delivered=false;
    }

    public void setAmmount(){
        int days = daysBetween(receipt.getDate(), deliveryDate);
        this.ammount = days*quantity*equipment.getCostxday();
    }
    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
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

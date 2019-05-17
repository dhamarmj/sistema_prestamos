package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Subfamily implements Serializable {
    @Id
    private String subfamily;

    @ManyToOne
    private Family family;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subfamily")
    private Set<Equipment> equipment;

    public Subfamily() {
    }

    public Subfamily(String subfamily, Family family) {
        this.subfamily = subfamily;
        this.family = family;
    }

    public Subfamily(String subfamily, Family family, Set<Equipment> equipment) {
        this.subfamily = subfamily;
        this.family = family;
        this.equipment = equipment;
    }

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    public String getSubfamily() {
        return subfamily;
    }

    public void setSubfamily(String subfamily) {
        this.subfamily = subfamily;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}

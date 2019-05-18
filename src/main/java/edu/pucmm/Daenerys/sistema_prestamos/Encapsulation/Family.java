package edu.pucmm.Daenerys.sistema_prestamos.Encapsulation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Family implements Serializable {
    @Id
    private String family;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "family")
    private Set<Subfamily> subfamilies;

    public Family() {
    }

    public Family(String family, Set<Subfamily> subfamilies) {
        this.family = family;
        this.subfamilies = subfamilies;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Set<Subfamily> getSubfamilies() {
        return subfamilies;
    }

    public void setSubfamilies(Set<Subfamily> subfamilies) {
        this.subfamilies = subfamilies;
    }
}

package edu.pucmm.Daenerys.sistema_prestamos.Repository;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {


}

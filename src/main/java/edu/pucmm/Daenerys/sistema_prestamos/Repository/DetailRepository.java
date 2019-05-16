package edu.pucmm.Daenerys.sistema_prestamos.Repository;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Receipt_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Receipt_detail, Integer> {
}

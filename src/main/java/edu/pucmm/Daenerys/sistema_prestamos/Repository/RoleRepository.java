package edu.pucmm.Daenerys.sistema_prestamos.Repository;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

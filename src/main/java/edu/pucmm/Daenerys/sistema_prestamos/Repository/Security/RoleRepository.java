package edu.pucmm.Daenerys.sistema_prestamos.Repository.Security;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}

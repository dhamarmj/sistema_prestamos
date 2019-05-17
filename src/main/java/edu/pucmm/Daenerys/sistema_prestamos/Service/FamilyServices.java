package edu.pucmm.Daenerys.sistema_prestamos.Service;

import edu.pucmm.Daenerys.sistema_prestamos.Repository.ClientRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServices {
    @Autowired
    private FamilyRepository familyRepository;
}

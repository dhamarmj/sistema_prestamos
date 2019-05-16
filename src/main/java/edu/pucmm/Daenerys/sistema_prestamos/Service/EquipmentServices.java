package edu.pucmm.Daenerys.sistema_prestamos.Service;

import edu.pucmm.Daenerys.sistema_prestamos.Repository.ClientRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServices {
    @Autowired
    private EquipmentRepository equipmentRepository;
}

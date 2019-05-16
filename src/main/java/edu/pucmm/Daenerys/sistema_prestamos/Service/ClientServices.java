package edu.pucmm.Daenerys.sistema_prestamos.Service;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;




}

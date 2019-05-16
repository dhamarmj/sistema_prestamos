package edu.pucmm.Daenerys.sistema_prestamos.Service;

import edu.pucmm.Daenerys.sistema_prestamos.Repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServices {
    @Autowired
    private DetailRepository detailRepository;
}

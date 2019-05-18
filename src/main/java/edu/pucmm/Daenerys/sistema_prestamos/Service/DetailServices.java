package edu.pucmm.Daenerys.sistema_prestamos.Service;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Receipt_detail;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServices {
    @Autowired
    private DetailRepository detailRepository;

//    public List<Receipt_detail> listaProfesorInicia(int id){
//      //  System.out.println("Nombre recibido: "+nombre);
//        return detailRepository.find(id);
//    }

}

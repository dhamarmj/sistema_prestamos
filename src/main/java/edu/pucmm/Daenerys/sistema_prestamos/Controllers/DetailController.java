package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Equipment;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Receipt_detail;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.DetailRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Detail")
public class DetailController {

    private Receipt_detail detail;

    @Autowired
    private DetailRepository detailRepository;

    @RequestMapping(value = "/")
    public List<Receipt_detail> getClient(){
        return detailRepository.findAll();
    }

//    @RequestMapping(value = "/Post", method = RequestMethod.POST, consumes = "application/json")
//    public Receipt_detail crearClient(@RequestBody Receipt_detail client){
//        detailRepository.save(client);
//        return client;
//    }
//
//    @RequestMapping(value = "/Put", method = RequestMethod.PUT, consumes = "application/json")
//    public Receipt_detail modifyClient(@RequestBody Receipt_detail client){
//        Optional<Receipt_detail> c = detailRepository.findById(client.getId());
//        if(!c.isPresent())
//        {
//           return  null;
//        }
//        else
//        {
//            detail = new Receipt_detail();
//            detail.setId(client.getId());
//            detail.setAmmount(client.getAmmount());
//            detail.setDeliveryDate(client.getDeliveryDate());
//            detail.setEquipment(client.getEquipment());
//            detail.setQuantity(client.getQuantity());
//            detail.setReceipt(client.getReceipt());
//            detailRepository.save(detail);
//            return detail;
//        }
//    }


}

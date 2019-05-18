package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Equipment;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Family;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Subfamily;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.FamilyRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.SubfamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Family")
public class FamilyController {
    private Family familia;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private SubfamilyRepository subfamilyRepository;


    @RequestMapping(value = "/")
    public List<Family> get(){
        return familyRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Family crear(@RequestBody Family client){
        for (Subfamily item:
             client.getSubfamilies()) {
            subfamilyRepository.save(item);
        }
        familyRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public Family modifyClient(@RequestBody Family client){
        Optional<Family> c = familyRepository.findById(client.getFamily());
        if(!c.isPresent())
        {
            return null;
        }
        else
        {
//            familia = new Family();
//            familia.setFamily(client.getFamily());
//            for (Subfamily s:
//                 client.getSubfamilies()) {
//                if(!subfamilyRepository.findById(s.getSubfamily()).isPresent())
//                    subfamilyRepository.save(s);
//            }
//            familia.setSubfamilies(client.getSubfamilies());
            familyRepository.save(client);
            return client;
        }

    }
}

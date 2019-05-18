package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Equipment;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Family;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Family")
public class FamilyController {
    private Family familia;

    @Autowired
    private FamilyRepository familyRepository;

    @RequestMapping(value = "/")
    public List<Family> get(){
        return familyRepository.findAll();
    }

    @RequestMapping(value = "/Post", method = RequestMethod.POST, consumes = "application/json")
    public Family crear(@RequestBody Family client){
        familyRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/Put", method = RequestMethod.PUT, consumes = "application/json")
    public Family modifyClient(@RequestBody Family client){
        Optional<Family> c = familyRepository.findById(client.getFamily());
        if(!c.isPresent())
        {
            familyRepository.save(client);
            return client;
        }
        else
        {
            familia = new Family();
            familia.setFamily(client.getFamily());
            familia.setSubfamilies(client.getSubfamilies());
            familyRepository.save(familia);
            return familia;
        }

    }
}

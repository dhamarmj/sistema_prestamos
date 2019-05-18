package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.*;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Equipment")
public class EquipmentController {

    Equipment equipo;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @RequestMapping(value = "/")
    public List<Equipment> getClient(){
        return equipmentRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Equipment crearClient(@RequestBody Equipment client){
        equipmentRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public Equipment modifyClient(@RequestBody Equipment client){
        Optional<Equipment> c = equipmentRepository.findById(client.getId());
        if(!c.isPresent())
        {
            return null;
        }
        else
        {
            equipmentRepository.save(client);
            return client;
        }
    }
}

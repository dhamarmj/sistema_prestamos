package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.*;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.SubfamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Subfamily")
public class SubfamilyController
{
    private Subfamily subcategoria;

    @Autowired
    private SubfamilyRepository subfamilyRepository;

    @RequestMapping(value = "/")
    public List<Subfamily> get(){
        return subfamilyRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Subfamily crear(@RequestBody Subfamily client){
        subfamilyRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public Subfamily modifyClient(@RequestBody Subfamily client){
        Optional<Subfamily> c = subfamilyRepository.findById(client.getSubfamily());
        if(!c.isPresent())
        {
            subfamilyRepository.save(client);
            return client;
        }
        else
        {
            subcategoria = new Subfamily();
            subcategoria.setEquipment(client.getEquipment());
            subcategoria.setFamily(client.getFamily());
            subcategoria.setSubfamily(client.getSubfamily());
            subfamilyRepository.save(subcategoria);
            return subcategoria;
        }

    }
}

package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Client;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ws/Client")
public class ClientController {

    private Client cliente;

    @Autowired
    private ClientRepository clientRepository;


    @RequestMapping(value = "/")
    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Client crearClient(@RequestBody Client client){
      clientRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public Client modifyClient(@RequestBody Client client){
      Optional<Client> c = clientRepository.findById(client.getId());
      if(!c.isPresent())
      {
          return null;
      }
      else
      {
          clientRepository.save(client);
          return client;
      }

    }

}

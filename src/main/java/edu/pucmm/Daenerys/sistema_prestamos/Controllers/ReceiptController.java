package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.*;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Receipts")
public class ReceiptController {

    private Receipt recibo;

    @Autowired
    private ReceiptRepository receiptRepository;

    @RequestMapping(value = "/")
    public List<Receipt> get(){
        return receiptRepository.findAll();
    }

    @RequestMapping(value = "/Post", method = RequestMethod.POST, consumes = "application/json")
    public Receipt crear(@RequestBody Receipt client){
        receiptRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/Put", method = RequestMethod.PUT, consumes = "application/json")
    public Receipt modifyClient(@RequestBody Receipt client){
        Optional<Receipt> c = receiptRepository.findById(client.getId());
        if(!c.isPresent())
        {
            return null;
        }
        else
        {
            recibo = new Receipt();
            recibo.setId(client.getId());
            recibo.setAmmount(client.getAmmount());
            recibo.setClient(client.getClient());
            recibo.setDate(client.getDate());
            recibo.setDetails(client.getDetails());
            receiptRepository.save(recibo);
            return recibo;
        }

    }

}

package edu.pucmm.Daenerys.sistema_prestamos.Controllers;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.*;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.DetailRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.EquipmentRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.BorderUIResource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/ws/Receipts")
public class ReceiptController {

    private Receipt recibo;
    private Set<Receipt_detail> details;
    private Equipment equipment;
    Date date = new Date();

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private DetailRepository detailRepository;


    @RequestMapping(value = "/")
    public List<Receipt> get() {
        return receiptRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Receipt crear(@RequestBody Receipt client) {
        if (client.getDetails() != null) {
            details = client.getDetails();
            for (Receipt_detail item :
                    client.getDetails()) {
                if (item.getEquipment().getQuantity() < item.getQuantity()) {
                    int val = item.getEquipment().getQuantity();
                    val = val - item.getQuantity();
                    item.getEquipment().setQuantity(val);
                    equipmentRepository.save(item.getEquipment());
                    if (item.getDeliveryDate().compareTo(date) <= 0) {
                        return null;
                    }
                    detailRepository.save(item);
                } else {
                    return null;
                }
            }
            receiptRepository.save(client);
            return  client;
        }
        return null;
    }

    double total;
    int all;
    @RequestMapping(value = "/Return", method = RequestMethod.POST, consumes = "application/json")
    public Receipt returnEquipments(@RequestBody Receipt client) {
        total=0;
        all=0;

        for (Receipt_detail item:
                client.getDetails()) {
            if(item.isDelivered())
            {
                item.setDeliveryDate(date);
                item.setAmmount();
                total+=item.getAmmount();
                all++;
            }
            else
                return null;
        }
            client.setPayedDate(date);
            client.setDeliveryCompleted(true);
            client.setAmmount(total);

            receiptRepository.save(recibo);
            return client;
    }


    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public Receipt modifyClient(@RequestBody Receipt client) {
        Optional<Receipt> c = receiptRepository.findById(client.getId());
        if (!c.isPresent()) {
            return null;
        } else {
            receiptRepository.save(client);
            return recibo;
        }
    }

}

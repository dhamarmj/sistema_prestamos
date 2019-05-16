package edu.pucmm.Daenerys.sistema_prestamos.Service;


import edu.pucmm.Daenerys.sistema_prestamos.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServices {
    @Autowired
    private ReceiptRepository receiptRepository;
}

package com.finastra.ett.financier.DAO;

import com.finastra.ett.financier.model.*;
import java.util.*;
public interface InvoiceBiddingDAO {


    BiddingInvoice geSumAmountById(String smeId);
    //List<BiddingInvoice> getSumOfAmount();
    
}

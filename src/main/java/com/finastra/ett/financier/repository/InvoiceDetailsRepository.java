package com.finastra.ett.financier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finastra.ett.financier.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Map;
import java.util.List;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Long> {
    

    String searchQuery="SELECT INV.* FROM icc_marketplace.invoice_details INV";
    //@Query(value=" SELECT SUM(INV.INV_AMT) AS AMOUNT ,INV.INV_CCY AS INVCURRENCY FROM INVOICE INV WHERE INV.INV_ID IN(SELECT BID.inv_key FROM BIDDING_DETAIL BID WHERE BID.FIN_BID_STATUS='I' ) AND INV.SME_ID=(:smeId) GROUP BY INV.INV_CCY",nativeQuery = true)
    @Query(value=" SELECT SUM(INV.INV_AMT) AS AMOUNT ,INV.INV_CCY AS INVCURRENCY FROM icc_marketplace.invoice_details INV WHERE INV.INV_ID IN(SELECT BID.inv_key FROM icc_marketplace.BIDDING_DETAIL BID WHERE BID.FIN_BID_STATUS='I' ) AND INV.SME_ID=(:smeId) AND INV.INV_NO NOT IN (SELECT DISTINCT FIN.INV_NO FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS='A' ) GROUP BY INV.INV_CCY",nativeQuery = true)
    Map<String, Object> getSumIntiatedBidAmt(@Param("smeId") String smeId);

    @Query(value = "SELECT SUM(INV.INV_AMT) as AMOUNT, INV.INV_CCY as CCY FROM icc_marketplace.invoice_details INV WHERE INV_ID NOT IN(select INV_KEY from icc_marketplace.BIDDING_DETAIL BID where (BID.FIN_BID_STATUS NOT IN ('A') AND BID.FIN_ID IN (:finId) ) ) AND INV.INV_NO NOT IN (SELECT DISTINCT FIN.INV_NO FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS='A' ) group by INV.INV_CCY", nativeQuery = true)
    Map<String, Object> openForOffer(@Param("finId") String finId);

    @Query(value = "SELECT SUM(BID.inv_amt) as AMOUNT, INV.INV_CCY as CCY FROM icc_marketplace.BIDDING_DETAIL BID, icc_marketplace.invoice_details INV WHERE BID.inv_key = INV.INV_ID AND BID.FIN_BID_STATUS = 'I' AND BID.FIN_ID = :finId group by INV.INV_CCY", nativeQuery = true)
    Map<String, Object> bidsToBeAccepted(@Param("finId") String finId);
    
    //For Open Funding Requests by smeId
    @Query(value="SELECT SUM(INV.INV_AMT) as AMOUNT, INV.INV_CCY AS CCY FROM icc_marketplace.invoice_details INV WHERE  INV.SME_ID IN (:smeId) AND INV_ID NOT IN(select INV_ID from icc_marketplace.FINANCING_DETAILS FIN where (FIN.STATUS IN ('A') ))  group by INV.INV_CCY",nativeQuery = true)
    Map<String,Object> getOpenFundingRequests(@Param("smeId") String smeId);
    
    @Query(value="SELECT INV.* FROM icc_marketplace.invoice_details INV WHERE INV_ID  NOT IN(select INV_ID from icc_marketplace.FINANCING_DETAILS FIN where (FIN.STATUS NOT IN ('I') )) AND INV.SME_ID IN (:smeId)",nativeQuery = true)
     List<InvoiceDetails> getAllInvoicesBySmeId(@Param("smeId") String smeId);
     
     //@Query(value=" SELECT INV.ID,INV.BUYER_NAME,INV.INV_DUE_DATE,INV.INV_AMT AS invoiceNo,INV.INV_CCY,INV.INV_DATE, INV.INV_ID,INV.INV_NO,INV.INV_REF ,INV.SME_ID,INV.STATUS ,COUNT(INV.ID) AS FINANCIERCOUNT FROM BIDDING_DETAIL BID,INVOICE INV WHERE BID.inv_key=INV.INV_ID AND BID.FIN_BID_STATUS='I' AND INV.SME_ID IN (:smeId) GROUP BY  INV.ID,INV.BUYER_NAME,INV.INV_DUE_DATE,INV.INV_AMT ,INV.INV_CCY,INV.INV_DATE, INV.INV_ID,INV.INV_NO,INV.INV_REF ,INV.SME_ID,INV.STATUS ",nativeQuery = true)
     @Query(value="SELECT INV.INV_DTLS_KEY ,INV.BUYER_NAME,INV.DUE_DATE AS INV_DUE_DATE,INV.INV_AMT AS INVOICENO,INV.INV_CCY,INV.REQ_DATE AS INV_DATE,  INV.INV_ID,INV.INV_NO  ,INV.SME_ID,INV.STATUS ,INV.REF_NO ,COUNT(INV.INV_DTLS_KEY) AS FINANCIERCOUNT   FROM icc_marketplace.BIDDING_DETAIL BID,icc_marketplace.invoice_details INV   WHERE BID.inv_key=INV.INV_ID AND BID.FIN_BID_STATUS='I' AND INV.SME_ID IN (:smeId) AND INV.INV_NO  NOT IN (SELECT DISTINCT FIN.INV_NO FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS='A' )   GROUP BY  INV.INV_DTLS_KEY,INV.BUYER_NAME,INV.DUE_DATE,INV.INV_AMT  ,INV.INV_CCY,INV.REQ_DATE, INV.INV_ID,INV.INV_NO ,INV.SME_ID,INV.STATUS ,INV.REF_NO; ",nativeQuery = true) 
     List<Map<String, Object>> getAllInvoicesBiddingBySmeId(@Param("smeId") String smeId);     
     
     @Query(value="SELECT INV.* FROM icc_marketplace.BIDDING_DETAIL BID,icc_marketplace.invoice_details INV WHERE BID.inv_key=INV.INV_ID AND BID.FIN_BID_STATUS='I' AND INV.SME_ID IN (:smeId) ",nativeQuery = true)
     List<InvoiceDetails> getAllInvoicesBiddingBySmeIdForTesting(@Param("smeId") String smeId);


     @Query(value="SELECT INV.* FROM icc_marketplace.invoice_details INV WHERE INV_ID NOT IN(select INV_KEY from icc_marketplace.BIDDING_DETAIL BID where (BID.FIN_BID_STATUS NOT IN ('A') AND BID.FIN_ID IN (:finId) ) ) AND INV.INV_NO NOT IN (SELECT DISTINCT FIN.INV_NO FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS='A' ) ",nativeQuery = true)
     List<InvoiceDetails> getAllFinanceInvoice(@Param("finId") String finId);

     
    @Query(value="SELECT INV.* FROM icc_marketplace.invoice_details INV WHERE INV_ID  IN(select INV_ID from icc_marketplace.FINANCING_DETAILS FIN where (FIN.STATUS IN ('A') )) AND INV.SME_ID IN (:smeId)",nativeQuery = true)
    List<InvoiceDetails> getAllInvoiceFinancing(@Param("smeId") String smeId);

    @Query(value="SELECT INV.* FROM icc_marketplace.invoice_details INV ,icc_marketplace.FINANCING_DETAILS FIN  WHERE INV.INV_ID=FIN.INV_ID AND FIN.STATUS='A' AND FIN.FIN_ID=:finId",nativeQuery = true)
    List<InvoiceDetails> getFundedByFinId(@Param("finId") String finId);

    //Changes By Abdul

    // ICC DASHBOARD - Funding Requests
    @Query(value = "SELECT SUM(INV.INV_AMT) as AMOUNT, INV.INV_CCY AS CCY FROM icc_marketplace.invoice_details INV WHERE INV_ID NOT IN (select INV_ID from icc_marketplace.FINANCING_DETAILS FIN where (FIN.STATUS IN ('A'))) group by INV.INV_CCY", nativeQuery = true)
    Map<String, Object> getFundingRequests();

    // ICC DASHBOARD - DETAILED Funding Requests
    @Query(value = "SELECT * FROM icc_marketplace.invoice_details INV WHERE INV_ID NOT IN (select INV_ID from icc_marketplace.FINANCING_DETAILS FIN where (FIN.STATUS IN ('A')))", nativeQuery = true)
    List<InvoiceDetails> getAllFundingRequests();

    // ICC DASHBOARD - Invoice Master
    @Query(value = "SELECT SUM(INV_AMT) as AMOUNT, INV_CCY AS CCY FROM icc_marketplace.invoice_details GROUP BY INV_CCY", nativeQuery = true)
    Map<String, Object> getInvoiceMaster();

    // ICC DASHBOARD - DETAILED Invoice Master
    @Query(value = "SELECT * FROM icc_marketplace.invoice_details", nativeQuery = true)
    List<InvoiceDetails> getAllInvoiceMaster();

    @Query(value = "SELECT INV.* FROM icc_marketplace.BIDDING_DETAIL BID, icc_marketplace.invoice_details INV WHERE BID.inv_key = INV.INV_ID AND BID.FIN_BID_STATUS = 'I'  AND BID.inv_key NOT IN (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') ) ", nativeQuery = true)
    List<InvoiceDetails> getAllOfferForAcceptance();
}

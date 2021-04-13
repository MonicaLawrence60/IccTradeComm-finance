package com.finastra.ett.financier.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.finastra.ett.financier.model.*;
import java.util.Map;

public interface BiddingDetailsRepositories extends JpaRepository<BiddingDetails, Long>{



    @Query("select i from BiddingDetails i where  i.invNo = :invNo and i.status='I' ")
    List<BiddingDetails> getBidDetailsById(@Param("invNo") String  invNo);

    //  @Query("select sum(i.invAmt) as invTotalAmt, i.invCcy as invCcy from InvoiceDetails i where i.status = 'A' and i.smeId = :smeId group by i.invCcy")
    // Map<String, Object> getSumOfBidRecieve(@Param("smeId") String smeId);
  
    @Query(value="SELECT SUM(BID.inv_amt) AS InvoiceAmt,'SGD' AS INVOICECCY FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='I' AND BID.FIN_ID=:finId",nativeQuery = true)
    Map<String, Object> getAllInitatedBids(@Param("finId") String finId);

    @Query(value="SELECT SUM(BID.inv_amt) AS INVOICEAMT ,'SGD' AS CCY FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='R' AND BID.FIN_ID=:finId",nativeQuery = true)
    Map<String, Object> getAllRejectedBids(@Param("finId") String finId);

    @Query(value="SELECT SUM(BID.inv_amt) AS INVOICEAMT ,'SGD' AS CCY FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='E' AND BID.FIN_ID= :finId",nativeQuery = true)
    Map<String, Object> getAllExpiredBids(@Param("finId") String finId);

    @Query(value="SELECT * FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='I' AND BID.FIN_ID=:finId",nativeQuery = true)
    List<BiddingDetails> getAllInitatedBidsList(@Param("finId") String finId);

    @Query(value="SELECT * FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='R' AND BID.FIN_ID=:finId",nativeQuery = true)
    List<BiddingDetails> getAllRejectedBidsList(@Param("finId") String finId);

    @Query(value="SELECT * FROM icc_marketplace.BIDDING_DETAIL BID WHERE   BID.inv_key NOT IN  (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )  AND BID.FIN_BID_STATUS='E' AND BID.FIN_ID= :finId",nativeQuery = true)
    List<BiddingDetails> getAllExpiredBidsList(@Param("finId") String finId);
    
  //Changes by Abdul
  // ICC DASHBOARD - Offer For Acceptance
  @Query(value = "SELECT SUM(BID.INV_AMT) as AMOUNT, INV.INV_CCY as CCY FROM icc_marketplace.BIDDING_DETAIL BID, icc_marketplace.invoice_details INV WHERE BID.inv_key = INV.INV_ID AND BID.FIN_BID_STATUS = 'I'  AND BID.inv_key NOT IN (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') )   group by INV.INV_CCY", nativeQuery = true)
  Map<String, Object> getOfferForAcceptance();

  // ICC DASHBOARD - DETAILED Offer For Acceptance
  @Query(value = "SELECT INV.* FROM icc_marketplace.BIDDING_DETAIL BID, icc_marketplace.invoice_details INV WHERE BID.inv_key = INV.INV_ID AND BID.FIN_BID_STATUS = 'I'  AND BID.inv_key NOT IN (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') ) group by INV.INV_CCY", nativeQuery = true)
  List<BiddingDetails> getAllOfferForAcceptance();

  //Search Filter
  
  @Query(value = "SELECT INV.* FROM icc_marketplace.BIDDING_DETAIL BID, icc_marketplace.invoice_details INV WHERE BID.inv_key = INV.INV_ID AND BID.FIN_BID_STATUS = 'I'  AND BID.inv_key NOT IN (SELECT FIN.INV_ID FROM icc_marketplace.FINANCING_DETAILS FIN WHERE FIN.STATUS IN ('A') ) group by INV.INV_CCY", nativeQuery = true)
  List<BiddingDetails> getBidDetailsSearchFilter(@Param("invNo") String  invNo,String searchQuery);

    
}

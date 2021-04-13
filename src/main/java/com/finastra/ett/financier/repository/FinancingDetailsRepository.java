package com.finastra.ett.financier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finastra.ett.financier.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FinancingDetailsRepository extends JpaRepository<FinancingDetails, Long> {
    @Query(value = "SELECT FIN.INV_ID AS invoiceId,FIN.INV_NO AS invoiceNo,FIN.BASECCY_FUNDAMT AS baseCcyFundingAmt,FIN.finance_amt AS baseCcyNetAmtPayable ,FIN.SME_ID AS smeId ,FIN.FIN_ID AS finId ,BID.FXRATE AS fxRate,BID.FUNDING_CCY AS  baseCcyAmt, BID.FUNDING_PERCENT AS fundablePercent, FIN.REPAYMENT_DATE AS repaymentDate,FIN.ANNUAL_YEILD AS annualYeild  ,INV.BUYER_NAME AS buyerName, INV.REQ_DATE AS invoiceDate ,INV.DUE_DATE as invoiceDueDate,fin.status FROM icc_marketplace.FINANCING_DETAILS FIN,icc_marketplace.invoice_details INV,icc_marketplace.BIDDING_detail BID WHERE FIN.INV_ID=INV.INV_ID   AND BID.INV_KEY =FIN.INV_ID AND BID.FIN_BID_STATUS='A' AND FIN.INV_ID=:invoiceId AND FIN.STATUS='A'", nativeQuery = true)
   // @Query("select i from FinancingDetails i where  i.invoiceId = :invoiceId")
   List<Map<String, Object>> getFinancingDetailsById(@Param("invoiceId") String invoiceId);

    @Query("select i.smeId from FinancingDetails i where  i.smeId = :smeId")
    List<FinancingDetails> addFinancingAndOnboard(@Param("smeId") String smeId);

    @Query(value = "SELECT SUM(INV.FINANCE_AMT) as INVTOTALAMT,'SGD' AS INVCCY FROM icc_marketplace.FINANCING_DETAILS INV WHERE INV.status = 'A' and INV.sme_Id = :smeId  ", nativeQuery = true)
    Map<String, Object> getSumOfFinancingDue(@Param("smeId") String smeId);

    @Query(value = "SELECT SUM(INV.FINANCE_AMT) as INVTOTALAMT,'SGD' AS INVCCY FROM icc_marketplace.FINANCING_DETAILS INV WHERE INV.status = 'A' and INV.fin_id = :finId ", nativeQuery = true)
    Map<String, Object> getSumOfFinancingDueByFinId(@Param("finId") String finId);

    // FINANCE MATURITY
    @Query(value = "SELECT '1' AS id, 'Upto 30 Days' AS Period, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) < 30 AND SME_ID = :smeId UNION SELECT '2' AS id, '30 to 45 Days' AS Period, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) BETWEEN 30 AND 45 AND SME_ID = :smeId UNION SELECT '3' AS id, '46 to 60 Days' AS Period, COUNT(1) AS Number,SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace. WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) BETWEEN 46 AND 60 AND SME_ID = :smeId UNION SELECT '4' AS id, '61 to 75 Days' AS Period, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) BETWEEN 61 AND 75 AND SME_ID = :smeId UNION SELECT '5' AS id, '76 to 90 Days' AS Period, COUNT(1) AS Number,SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) BETWEEN 76 AND 90 AND SME_ID = :smeId UNION SELECT '6' AS id, '91 to 120 Days' AS Period, COUNT(1) AS Number,SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE DATEDIFF(DAY, CURRENT_DATE(), PARSEDATETIME(REPAYMENT_DATE,'dd-MM-yyyy')) BETWEEN 91 AND 120 AND SME_ID = :smeId", nativeQuery = true)
    List<Map<String, Object>> getFinMatData(@Param("smeId") String smeId);
    
    // FINANCE SIZE
    @Query(value = "SELECT '1' AS id, 'Upto 10000 SGD' AS Invoice_Size, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE BASECCY_FUNDAMT < 10000 AND SME_ID = :smeId UNION SELECT '2' AS id, '10000 to 20000 SGD' AS Invoice_Size, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT),0) AS Amount FROM icc_marketplace. WHERE BASECCY_FUNDAMT BETWEEN 10000 AND 20000 AND SME_ID = :smeId UNION SELECT '3' AS id, '20001 to 40000 SGD' AS Invoice_Size, COUNT(1) AS Number,SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE BASECCY_FUNDAMT BETWEEN 20001 AND 40000 AND SME_ID = :smeId UNION SELECT '4' AS id, '80001 to 100000 SGD' AS Invoice_Size, COUNT(1) AS Number,SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE BASECCY_FUNDAMT BETWEEN 80001 AND 100000 AND SME_ID = :smeId UNION SELECT '5' AS id, 'Above 100000 SGD' AS Invoice_Size, COUNT(1) AS Number, SUM(BASECCY_FUNDAMT) AS Amount FROM icc_marketplace.FINANCING_DETAILS WHERE BASECCY_FUNDAMT > 100000 AND SME_ID = :smeId", nativeQuery = true)
    List<Map<String, Object>> getFinSizeData(@Param("smeId") String smeId);

    //Icc Dashboard-Finance Master
    @Query(value = "SELECT SUM(FIN.FINANCE_AMT  ) AS FINANCEAMT, 'SGD' AS FINANCECCY FROM icc_marketplace.FINANCING_DETAILS FIN,icc_marketplace.invoice_details INV WHERE FIN.INV_ID=INV.INV_ID  AND FIN.STATUS='A'  AND CONVERT(VARCHAR(10),fin.finance_date, 110)=CONVERT(VARCHAR(10), getdate(), 110)", nativeQuery = true)
    Map<String, Object> getFinanceMasterDetails();

    @Query(value="SELECT FIN.INV_ID AS invoiceId,FIN.INV_NO AS invoiceNo,FIN.BASECCY_FUNDAMT AS baseCcyFundingAmt,  FIN.finance_amt AS baseCcyNetAmtPayable ,FIN.SME_ID AS smeId ,FIN.FIN_ID AS finId ,BID.FXRATE AS fxRate,BID.FUNDING_CCY AS   baseCcyAmt, BID.FUNDING_PERCENT AS fundablePercent, FIN.REPAYMENT_DATE AS repaymentDate,FIN.ANNUAL_YEILD AS annualYeild  ,INV.BUYER_NAME AS buyerName, INV.REQ_DATE AS invoiceDate ,INV.DUE_DATE as invoiceDueDate,fin.status  FROM icc_marketplace.FINANCING_DETAILS FIN,icc_marketplace.invoice_details INV,icc_marketplace.BIDDING_detail BID WHERE  FIN.INV_ID=INV.INV_ID   AND BID.INV_KEY =FIN.INV_ID AND BID.FIN_BID_STATUS='A'  AND FIN.STATUS='A' AND CONVERT(VARCHAR(10),fin.finance_date, 110)=CONVERT(VARCHAR(10), getdate(), 110)",nativeQuery = true)
    List<Map<String,Object>> getFinanceMasterDetailsList();

    //Changes By Abdul

    // ICC DASHBOARD - Finance Master
    @Query(value = "SELECT SUM(FINANCE_AMT) as AMOUNT, 'SGD' AS CCY FROM icc_marketplace.FINANCING_DETAILS", nativeQuery = true)
    Map<String, Object> getFinanceMaster();

    // ICC DASHBOARD - DETAILED Finance Master
    @Query(value = "SELECT * FROM icc_marketplace.FINANCING_DETAILS", nativeQuery = true)
    List<FinancingDetails> getAllFinanceMaster();

    // SME DASHBOARD - ACTUAL FUNDING CHART DATA
    @Query(value = "SELECT MONTH(REPAYMENT_DATE) AS MONTH, CAST(SUM(finance_amt) AS INT) AS AMOUNT FROM icc_marketplace.FINANCING_DETAILS WHERE SME_ID = :smeId GROUP BY MONTH(REPAYMENT_DATE)", nativeQuery = true)
    List<Map<String, Object>> getSmeActualFundingChartData(@Param("smeId") String smeId);

    // FINANCIER DASHBOARD - ACTUAL FUNDING CHART DATA
    @Query(value = "SELECT MONTH(REPAYMENT_DATE) AS MONTH, CAST(SUM(finance_amt) AS INT) AS AMOUNT FROM icc_marketplace.FINANCING_DETAILS WHERE FIN_ID = :finId GROUP BY MONTH(REPAYMENT_DATE)", nativeQuery = true)
    List<Map<String, Object>> getFinActualFundingChartData(@Param("finId") String finId);

}

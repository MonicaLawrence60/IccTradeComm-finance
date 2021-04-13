package com.finastra.ett.financier.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finastra.ett.financier.model.*;
import com.finastra.ett.financier.repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;  
import java.util.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//Changes
//dfjdf

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class FinancierController {
  
    @Autowired
    private BiddingDetailsRepositories biddingDetailsRepositories;

    @Autowired
    private FinancingDetailsRepository financingDetailsRepository;

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

  

    // @GetMapping("/bidding")
  
    // // public List<BiddingDetails> getBiddingDetails(){
    // //         return biddingDetailsRepositories.findAll();
    // //  }
 

    //  @GetMapping("/bidding-details/getBiddingDetails/{invoiceId}")
    // public BiddingDetails getAllBidByInvoiceId(@PathVariable("id") String invoiceId, BiddingDetails biddingDetails) {
    //     if (biddingDetailsRepositories.findById(invoiceId).isPresent()) 
    //     biddingDetails = biddingDetailsRepositories.findById(invoiceId).get();
    //     return biddingDetails;
    // }

     // Get initiated invoices by sme id
     @GetMapping("/bidding-details/getBiddingDetails/{invNo}")
     public List<BiddingDetails> getAllBidByInvoiceId(@PathVariable("invNo") String  invNo) {
         List<BiddingDetails> biddingDetails = (List<BiddingDetails>) biddingDetailsRepositories.getBidDetailsById(invNo);
         return biddingDetails;
     }
 
       // Get bidding details by bid id
       @GetMapping("/bidding-details/getBiddingDetailsByBidId/{id}")
       public BiddingDetails getAllBidByBidId(@PathVariable("id") long id, BiddingDetails biddingDetails) {
        if (biddingDetailsRepositories.findById(id).isPresent()) 
        biddingDetails = biddingDetailsRepositories.findById(id).get();
        return biddingDetails;
       }

       
   @GetMapping("/financing-details/getFinancingDetails/{invoiceId}")
   public List<Map<String, Object>> getFinancingDetailsById(@PathVariable("invoiceId") String  invoiceId) {
   // List<FinancingDetails> financingDetails = (List<FinancingDetails>)financingDetailsRepository.getFinancingDetailsById(invoiceId);
   return financingDetailsRepository.getFinancingDetailsById(invoiceId);
    }

    // SME Dashboard - Finance for Bidding
    @GetMapping("/invoice-request/getSumOfFinancingDue/{smeId}")
    public Map<String, Object> getSumOfFinancingDue(@PathVariable("smeId") String  smeId) {
        return financingDetailsRepository.getSumOfFinancingDue(smeId);
    }

    // Financier Dashboard - Finance for Bidding
    @GetMapping("/invoice-request/getSumOfFinancingDueByFinId/{finId}")
    public Map<String, Object> getSumOfFinancingDueByFinId(@PathVariable("finId") String  finId) {
        return financingDetailsRepository.getSumOfFinancingDueByFinId(finId);
    }

    

    @GetMapping("/invoice-request/getSumOfIntiatedBidAmt/{smeId}")
    public Map<String, Object> getSumIntiatedBidAmt(@PathVariable("smeId") String  smeId) {
        return invoiceDetailsRepository.getSumIntiatedBidAmt(smeId);
    }

    @GetMapping("/invoice-request/getOpenFundingRequests/{smeId}")
    public Map<String, Object> getOpenFundingRequests(@PathVariable("smeId") String smeId){
        return invoiceDetailsRepository.getOpenFundingRequests(smeId);

    }
      // Get all invoices by passing SME id
    @GetMapping("/invoice-request/allInvoicesBySmeId/{smeId}")
    public List<InvoiceDetails> viewAllInvoicesBySmeId(@PathVariable("smeId") String  smeId) {
        List<InvoiceDetails> initiatedInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoicesBySmeId(smeId);
        return initiatedInvoicesBySmeIdList;
    }

    @GetMapping("/invoice-request/allBiddingInvoicesBySmeId/{smeId}")
    public List<Map<String, Object>>viewAllBiddingInvoicesBySmeId(@PathVariable("smeId") String  smeId) {
        //List<InvoiceDetails> biddingInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoicesBiddingBySmeId(smeId);
        return invoiceDetailsRepository.getAllInvoicesBiddingBySmeId(smeId);
    }

    @GetMapping("/invoice-request/getOpenFundingRequestsByFinId/{finId}")
    public Map<String, Object> getOpenFundingRequestsByFinId(@PathVariable("finId") String finId){
        return invoiceDetailsRepository.getOpenFundingRequests(finId);

    }
      // Get all invoices by passing SME id
    @GetMapping("/invoice-request/allInvoicesByFinId/{finId}")
    public List<InvoiceDetails> viewAllInvoicesByFinId(@PathVariable("finId") String  finId) {
        List<InvoiceDetails> initiatedInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoicesBySmeId(finId);
        return initiatedInvoicesBySmeIdList;
    }

    @GetMapping("/invoice-request/allBiddingInvoicesByFinId/{smeId}")
    public List<Map<String, Object>>viewAllBiddingInvoicesByFinId(@PathVariable("finId") String  finId) {
        //List<InvoiceDetails> biddingInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoicesBiddingBySmeId(smeId);
        return invoiceDetailsRepository.getAllInvoicesBiddingBySmeId(finId);
    }


    @GetMapping("/invoice-request/allBiddingInvoicesBySmeIdForTesting/{smeId}")
    public List<InvoiceDetails> viewAllBiddingInvoicesBySmeIdForTesting(@PathVariable("smeId") String  smeId) {
        List<InvoiceDetails> biddingInvoicesBySmeIdList1 = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoicesBiddingBySmeIdForTesting(smeId);
        return biddingInvoicesBySmeIdList1;
    }
    @GetMapping("/invoice-request/allFinanceInvoices/{finId}")
    public List<InvoiceDetails> viewAllFinanceInvoices(@PathVariable("finId") String finId) {
        List<InvoiceDetails> biddingInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllFinanceInvoice(finId);
        return biddingInvoicesBySmeIdList;
    }

    @GetMapping("/invoice-request/allInvoiceFinancing/{smeId}")
    public List<InvoiceDetails> getAllInvoiceFinancing(@PathVariable("smeId") String smeId) {
        List<InvoiceDetails> financingInvoicesBySmeIdList = (List<InvoiceDetails>) invoiceDetailsRepository.getAllInvoiceFinancing(smeId);
        return financingInvoicesBySmeIdList;
    }
    @GetMapping("/invoice-request/getFundedListByFinId/{finId}")
    public List<InvoiceDetails> getFundedListByFinId(@PathVariable("finId") String finId) {
        List<InvoiceDetails> fundedListByFinId = (List<InvoiceDetails>) invoiceDetailsRepository.getFundedByFinId(finId);
        return fundedListByFinId;
    }
   
    @GetMapping("/invoice-request/allInitatedBidsList/{finId}")
    public List<BiddingDetails> getAllInitatedBidsList(@PathVariable("finId") String finId) {
        List<BiddingDetails> allInitatedBidsList = (List<BiddingDetails>) biddingDetailsRepositories.getAllInitatedBidsList(finId);
        return allInitatedBidsList;
    }
    @GetMapping("/invoice-request/allRejectedBidsList/{finId}")
    public List<BiddingDetails> getAllRejectedBidsList(@PathVariable("finId") String finId) {
        List<BiddingDetails> allRejectedBidsList = (List<BiddingDetails>) biddingDetailsRepositories.getAllRejectedBidsList(finId);
        return allRejectedBidsList;
    }
    @GetMapping("/invoice-request/allExpiredBidsList/{finId}")
    public List<BiddingDetails> getAllExpiredBidsList(@PathVariable("finId") String finId) {
        List<BiddingDetails> allExpiredBidsList = (List<BiddingDetails>) biddingDetailsRepositories.getAllExpiredBidsList(finId);
        return allExpiredBidsList;
    }

    @GetMapping("/bidding-details/getBiddingFromId/{id}")
    public BiddingDetails getBiddingFromId(@PathVariable("id") long id, BiddingDetails biddingDetails) {
     if (biddingDetailsRepositories.findById(id).isPresent()) 
     biddingDetails = biddingDetailsRepositories.findById(id).get();
     return biddingDetails;
    }

    @GetMapping("/financing-details/allFinanceToday")
    public Map<String, Object> getAllFinanceToday() {
        return financingDetailsRepository.getFinanceMasterDetails();
    }

    @GetMapping("/financing-details/allFinanceTodayList")
    public List<Map<String,Object>> getAllFinanceTodayList() {
      //  List<FinancingDetails> allFinanceTodayList = (List<FinancingDetails>)financingDetailsRepository.getFinanceMasterDetailsList();
        return financingDetailsRepository.getFinanceMasterDetailsList();
    }

    //Changes By Abdul
    // open for offer
    @GetMapping("/financing-details/openForOffer/{finId}")
    public Map<String, Object> openForOffer(@PathVariable("finId") String finId) {
        return invoiceDetailsRepository.openForOffer(finId);
    }

    // bids to be accepted
    @GetMapping("/financing-details/bidsToBeAccepted/{finId}")
    public Map<String, Object> bidsToBeAccepted(@PathVariable("finId") String finId) {
        return invoiceDetailsRepository.bidsToBeAccepted(finId);
    }

    // FINANCE MATURITY
    @GetMapping("/financing-details/getFinMatData/{smeId}")
    public List<Map<String, Object>> getFinMatData(@PathVariable("smeId") String  smeId) {
        return financingDetailsRepository.getFinMatData(smeId);
    }

    // FINANCE SIZE
    @GetMapping("/financing-details/getFinSizeData/{smeId}")
    public List<Map<String, Object>> getFinSizeData(@PathVariable("smeId") String  smeId) {
        return financingDetailsRepository.getFinSizeData(smeId);
    }

    @GetMapping("/icc-dashboard/getFundingRequests")
    public Map<String, Object> getFundingRequests() {
        return invoiceDetailsRepository.getFundingRequests();

    }

    @GetMapping("/icc-dashboard/getAllFundingRequests")
    public List<InvoiceDetails> getAllFundingRequests() {
        return invoiceDetailsRepository.getAllFundingRequests();

    }

    @GetMapping("/icc-dashboard/getOfferForAcceptance")
    public Map<String, Object> getOfferForAcceptance() {
        return biddingDetailsRepositories.getOfferForAcceptance();

    }

    @GetMapping("/icc-dashboard/getAllOfferForAcceptance")
    public List<InvoiceDetails> getAllOfferForAcceptance() {
        return invoiceDetailsRepository.getAllOfferForAcceptance();

    }

    @GetMapping("/icc-dashboard/getFinanceMaster")
    public Map<String, Object> getFinanceMaster() {
        return financingDetailsRepository.getFinanceMaster();

    }

    @GetMapping("/icc-dashboard/getAllFinanceMaster")
    public List<FinancingDetails> getAllFinanceMaster() {
        return financingDetailsRepository.getAllFinanceMaster();

    }

    @GetMapping("/icc-dashboard/getInvoiceMaster")
    public Map<String, Object> getInvoiceMaster() {
        return invoiceDetailsRepository.getInvoiceMaster();

    }
    @GetMapping("/icc-dashboard/getAllInvoiceMaster")
    public List<InvoiceDetails> getAllInvoiceMaster() {
        return invoiceDetailsRepository.getAllInvoiceMaster();

    }
    // SME DASHBOARD - ACTUAL FUNDING CHART DATA
    @GetMapping("/invoice-request/getSmeActualFundingChartData/{smeId}")
    public Map<String, String> getSmeActualFundingChartData(@PathVariable("smeId") String  smeId) {
        Map<String, String> chartData = new LinkedHashMap<>();
		chartData.put("1", "0");
		chartData.put("2", "0");
		chartData.put("3", "0");
		chartData.put("4", "0");
		chartData.put("5", "0");
		chartData.put("6", "0");
		chartData.put("7", "0");
		chartData.put("8", "0");
		chartData.put("9", "0");
		chartData.put("10", "0");
		chartData.put("11", "0");
		chartData.put("12", "0");

		List<Map<String, Object>> list = financingDetailsRepository.getSmeActualFundingChartData(smeId);
		List<String> keys = new ArrayList<>();
		List<String> values = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			int tempKey = (Integer) list.get(i).get("MONTH");
			keys.add(String.valueOf(tempKey));
			int tempValue = (Integer) list.get(i).get("AMOUNT");
			values.add(String.valueOf(tempValue));
		}
		
		for (int j = 0; j < list.size(); j++) {
			for (int i = 0; i < 12; i++) {
				if (chartData.containsKey(keys.get(j))) {
					chartData.put(keys.get(j), values.get(j));
				}
			}
		}

		return chartData;
    }

    // FINANCIER DASHBOARD - ACTUAL FUNDING CHART DATA
    @GetMapping("/invoice-request/getFinActualFundingChartData/{finId}")
    public Map<String, String> getFinActualFundingChartData(@PathVariable("finId") String  finId) {
        Map<String, String> chartData = new LinkedHashMap<>();
		chartData.put("1", "0");
		chartData.put("2", "0");
		chartData.put("3", "0");
		chartData.put("4", "0");
		chartData.put("5", "0");
		chartData.put("6", "0");
		chartData.put("7", "0");
		chartData.put("8", "0");
		chartData.put("9", "0");
		chartData.put("10", "0");
		chartData.put("11", "0");
		chartData.put("12", "0");

		List<Map<String, Object>> list = financingDetailsRepository.getFinActualFundingChartData(finId);
		List<String> keys = new ArrayList<>();
		List<String> values = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			int tempKey = (Integer) list.get(i).get("MONTH");
			keys.add(String.valueOf(tempKey));
			int tempValue = (Integer) list.get(i).get("AMOUNT");
			values.add(String.valueOf(tempValue));
		}
		
		for (int j = 0; j < list.size(); j++) {
			for (int i = 0; i < 12; i++) {
				if (chartData.containsKey(keys.get(j))) {
					chartData.put(keys.get(j), values.get(j));
				}
			}
		}

		return chartData;
    }
  
    @PostMapping("/bidding-details")
    public BiddingDetails getAllFinBidByInvoiceId(@RequestBody BiddingDetails biddingDetails){
        biddingDetails.setStatus("I");
        return biddingDetailsRepositories.save(biddingDetails);
   }
 

   @PostMapping("/financing-details/addFinancingBidDetails")

   public FinancingDetails addFinancingDetails(@RequestBody FinancingDetails financingDetails ){
        return financingDetailsRepository.save(financingDetails);
   }

   //To save Invoice Details
   @PostMapping("/invoice-details")
   public void addInvoiceDetails(@RequestBody  List<InvoiceDetails> invoiceDetails){
    //List<InvoiceDetails> invoiceDetailsList = new   ArrayList<InvoiceDetails>();
    for(InvoiceDetails aInvoiceDetails:invoiceDetails){
    invoiceDetailsRepository.save(aInvoiceDetails);
    }
   // return invoiceDetailsList;
    }

     @PostMapping("/bidding-details/remarks")
     public void addInvoice(@RequestBody Bidding bidding) {
        BiddingDetails biddingDetails = bidding.getBiddingDetails();
        biddingDetailsRepositories.save(biddingDetails);
    }


    //To Update  bidding status to A
    @PutMapping("/bidding-details/updateBidStatus/{id}")
    public void updateBidStatus(@PathVariable("id") Long id,Bidding bidding){
        BiddingDetails biddingDetails = bidding.getBiddingDetails();
        if (biddingDetailsRepositories.findById(id).isPresent()) {
            biddingDetails = biddingDetailsRepositories.findById(id).get();
            biddingDetails.setStatus("A");
            biddingDetailsRepositories.save(biddingDetails);
        }
    }

    //To Update  bidding status to R
    @PutMapping("/bidding-details/rejectBidStatus/{id}")
    public String rejectBidStatus(@PathVariable("id") Long id,@RequestBody BiddingDetails biddingDetails,Bidding bidding){
        String remarks="";
        BiddingDetails biddingDetails1 = bidding.getBiddingDetails();
        if (biddingDetailsRepositories.findById(id).isPresent()) {
            biddingDetails1 = biddingDetailsRepositories.findById(id).get(); 
              biddingDetails1.setRemarks(biddingDetails.getRemarks());           
            // remarks=biddingDetails.getRemarks();
            biddingDetails1.setStatus("R");
            biddingDetailsRepositories.save(biddingDetails1);
          
        }
        return remarks;
    } 
    

//To Update  bidding status to I
@PutMapping("/bidding-details/updateBidStatusInitiated/{id}")
public void updateBidStatusInitiated(@PathVariable("id") Long id,@RequestBody BiddingDetails biddingDetails,Bidding bidding){
      BiddingDetails biddingDetails1 = bidding.getBiddingDetails();
    if (biddingDetailsRepositories.findById(id).isPresent()) {
        biddingDetails1 = biddingDetailsRepositories.findById(id).get();
        biddingDetails1.setRepaymentDate(biddingDetails.getRepaymentDate());
        biddingDetails1.setAnnualYeild(biddingDetails.getAnnualYeild());
        biddingDetails1.setBaseCcyAmt(biddingDetails.getBaseCcyAmt());
        biddingDetails1.setBaseCcyDiscAmt(biddingDetails.getBaseCcyDiscAmt());
        biddingDetails1.setBaseCcyFundingAmt(biddingDetails.getBaseCcyFundingAmt());
        biddingDetails1.setBaseCcyNetAmtPayable(biddingDetails.getBaseCcyNetAmtPayable());
        biddingDetails1.setFinId(biddingDetails.getFinId());
        biddingDetails1.setFundablePercent(biddingDetails.getFundablePercent());
        biddingDetails1.setFundingCcy(biddingDetails.getFundingCcy());
        biddingDetails1.setFxRate(biddingDetails.getFxRate());
        biddingDetails1.setInvCcyDiscAmt(biddingDetails.getInvCcyDiscAmt());
        biddingDetails1.setInvCcyFundingAmt(biddingDetails.getInvCcyFundingAmt());
        biddingDetails1.setInvDiscRate(biddingDetails.getInvDiscRate());
        biddingDetails1.setInvNo(biddingDetails.getInvNo());
        biddingDetails1.setInvoiceAmt(biddingDetails.getInvoiceAmt());
        biddingDetails1.setInvoiceId(biddingDetails.getInvoiceId());
        biddingDetails1.setStatus("I");
        biddingDetailsRepositories.save(biddingDetails1);
    }
}







}

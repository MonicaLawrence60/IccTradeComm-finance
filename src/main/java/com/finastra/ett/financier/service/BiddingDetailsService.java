package com.finastra.ett.financier.service;

import org.springframework.stereotype.Service;
import com.finastra.ett.financier.repository.*;
import com.finastra.ett.financier.model.*;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class BiddingDetailsService {

    @Autowired
    private BiddingDetailsRepositories biddingDetailsRepositories;

    public void getSearchFiltersValues(BiddingDetails biddingDetails){
        String searchQueryFilter="";
        String setValue = null;
        String searchQuery="SELECT * FROM icc_marketplace.BIDDING_DETAIL";

        if(!biddingDetails.getFxRate().equals(null)||!biddingDetails.getFxRate().isEmpty()){
            searchQueryFilter=searchQuery+ " WHERE FXRATE like ?||'%' ";
            setValue=biddingDetails.getFxRate();
        }else if(!biddingDetails.getInvNo().equals(null)||!biddingDetails.getInvNo().isEmpty()){
            searchQueryFilter=searchQuery+ " WHERE INVNO like ?||'%' ";
            setValue=biddingDetails.getInvNo();
            if (setValue != null) {
                biddingDetailsRepositories.getBidDetailsSearchFilter(setValue,searchQueryFilter);
                }

    }

   
}}

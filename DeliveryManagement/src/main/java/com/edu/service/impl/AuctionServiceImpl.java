/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.service.impl;

import com.edu.pojo.Auction;
import com.edu.repository.AuctionRepository;
import com.edu.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author beanp
 */
public class AuctionServiceImpl implements AuctionService {
    
    @Autowired
    private AuctionRepository auctionRepository;
    
    @Override
    public boolean addOrUpdateAuction(Auction auction) {
        return this.auctionRepository.addOrUpdateAuction(auction);
    }
    
}

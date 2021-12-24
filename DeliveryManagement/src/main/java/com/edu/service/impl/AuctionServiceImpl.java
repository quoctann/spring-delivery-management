package com.edu.service.impl;

import com.edu.pojo.Auction;
import com.edu.repository.AuctionRepository;
import com.edu.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService {
    
    @Autowired
    private AuctionRepository auctionRepository;
    
    @Override
    public boolean addOrUpdateAuction(Auction auction) {
        return this.auctionRepository.addOrUpdateAuction(auction);
    }

    @Override
    public Auction getAuctionByShipperAndOrder(int shipperId, int orderId) {
        return this.auctionRepository.getAuctionByShipperAndOrder(shipperId, orderId);
    }
    
}

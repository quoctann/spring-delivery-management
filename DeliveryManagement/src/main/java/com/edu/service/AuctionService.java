package com.edu.service;

import com.edu.pojo.Auction;

public interface AuctionService {
    boolean addOrUpdateAuction(Auction auction);
    Auction getAuctionByShipperAndOrder(int shipperId, int orderId);
}

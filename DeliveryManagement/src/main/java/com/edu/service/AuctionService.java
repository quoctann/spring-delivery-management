package com.edu.service;

import com.edu.pojo.Auction;
import java.util.List;

public interface AuctionService {
    boolean addOrUpdateAuction(Auction auction);
    Auction getAuctionByShipperAndOrder(int shipperId, int orderId);
    List<Auction> getAuctionsByOrderId(int id);
}

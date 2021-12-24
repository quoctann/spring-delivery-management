package com.edu.repository;

import com.edu.pojo.Auction;
import java.util.List;

public interface AuctionRepository {
    Auction getAuctionById(int id);
    List<Auction> getAuctions();
    boolean addOrUpdateAuction(Auction auction);
    Auction getAuctionByShipperAndOrder(int shipperId, int orderId);
}

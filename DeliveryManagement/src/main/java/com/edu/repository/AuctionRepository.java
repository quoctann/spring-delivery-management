/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.repository;

/**
 *
 * @author beanp
 */

import com.edu.pojo.Auction;
import java.util.List;

public interface AuctionRepository {
    Auction getAuctionById(int id);
    List<Auction> getAuctions();
    List<Auction> getAuctionsByOrderId(int id);
    boolean addOrUpdateAuction(Auction auction);
    Auction getAuctionByShipperAndOrder(int shipperId, int orderId);
}

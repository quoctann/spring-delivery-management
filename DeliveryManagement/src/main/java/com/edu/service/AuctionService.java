/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.service;

import com.edu.pojo.Auction;

/**
 *
 * @author beanp
 */
public interface AuctionService {
    boolean addOrUpdateAuction(Auction auction);
}

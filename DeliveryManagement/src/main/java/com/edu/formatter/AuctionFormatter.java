/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.formatter;

import com.edu.pojo.Auction;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author beanp
 */
public class AuctionFormatter implements Formatter<Auction> {
    
    @Override
    public String print(Auction a, Locale locale) {
        return String.valueOf(a.getId());
    }

    @Override
    public Auction parse(String Id, Locale locale) throws ParseException {
        Auction a = new Auction();
        a.setId(Integer.parseInt(Id));
        
        return a;
    }
    
}

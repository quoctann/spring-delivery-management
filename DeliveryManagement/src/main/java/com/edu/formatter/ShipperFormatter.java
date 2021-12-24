/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.formatter;

import com.edu.pojo.Shipper;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author beanp
 */
public class ShipperFormatter implements Formatter<Shipper> {
    
    @Override
    public String print(Shipper s, Locale locale) {
        return String.valueOf(s.getShipperId());
    }

    @Override
    public Shipper parse(String Id, Locale locale) throws ParseException {
        Shipper s = new Shipper();
        s.setShipperId(Integer.parseInt(Id));
        
        return s;
    }
    
    
}

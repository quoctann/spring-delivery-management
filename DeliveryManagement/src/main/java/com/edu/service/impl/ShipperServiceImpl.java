package com.edu.service.impl;

import com.edu.pojo.Shipper;
import com.edu.repository.ShipperRepository;
import com.edu.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperServiceImpl implements ShipperService {
    
    @Autowired
    private ShipperRepository shipperRepository;
    
    @Override
    public Shipper getShipperById(int id) {
        return this.shipperRepository.getShipperById(id);
    }

    @Override
    public boolean updateInfo(Shipper shipper) {
        return this.shipperRepository.updateInfo(shipper);
    }
    
}

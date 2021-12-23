package com.edu.service.impl;

import com.edu.pojo.Shipper;
import com.edu.repository.ShipperRepository;
import com.edu.service.ShipperService;
import java.util.List;
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

    @Override
    public List<Object[]> getShipperList(String filterType, String username, int page) {
        return this.shipperRepository.getShipperList(filterType, username, page);
    }

    @Override
    public boolean deactivateShipper(int shipperId) {
        return this.shipperRepository.deactivateShipper(shipperId);
    }

    @Override
    public boolean activateShipper(int shipperId) {
        return this.shipperRepository.activateShipper(shipperId);
    }

    @Override
    public boolean approveShipper(int adminId, int shipperId) {
        return this.shipperRepository.approveShipper(adminId, shipperId);
    }

    @Override
    public boolean partialUpdateByAdmin(int shipperId, String email, String phone, String idCard) {
        return this.shipperRepository.partialUpdateByAdmin(shipperId, email, phone, idCard);
    }
    
}

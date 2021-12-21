
package com.edu.service;

import com.edu.pojo.Shipper;

public interface ShipperService {
    Shipper getShipperById(int id);
    boolean updateInfo(Shipper shipper);
}

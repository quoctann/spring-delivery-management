
package com.edu.repository;

import com.edu.pojo.Shipper;

public interface ShipperRepository {
    Shipper getShipperById(int id);
    boolean updateInfo(Shipper shipper);
}

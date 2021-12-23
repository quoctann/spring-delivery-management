
package com.edu.service;

import com.edu.pojo.Shipper;
import java.util.List;

public interface ShipperService {
    Shipper getShipperById(int id);
    boolean updateInfo(Shipper shipper);
    List<Object[]> getShipperList(String filterType, String username, int page);
    boolean deactivateShipper(int shipperId);
    boolean activateShipper(int shipperId);
    boolean approveShipper(int adminId, int shipperId);
    boolean partialUpdateByAdmin(int shipperId, String email, String phone, String idCard);
}

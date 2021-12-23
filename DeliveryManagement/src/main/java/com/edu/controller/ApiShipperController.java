package com.edu.controller;

import com.edu.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiShipperController {
    
    @Autowired
    private ShipperService shipperService;
    
    // Kích hoạt lại tài khoản shipper (active = true)
    @PutMapping("/admin/api/deactivate-shipper/{id}")
    public HttpStatus deactivateShipper(@PathVariable(value = "id") int shipperId) {        
        if (this.shipperService.deactivateShipper(shipperId)) {
            return HttpStatus.OK;
        }
        
        // Nếu không update thành công thì trả về 304
        return HttpStatus.NOT_MODIFIED;
    }
    
    // Tạm hủy kích hoạt tài khoản shipper (active = false)
    @PutMapping("/admin/api/activate-shipper/{id}")
    public HttpStatus activateShipper(@PathVariable(value = "id") int shipperId) {        
        if (this.shipperService.activateShipper(shipperId)) {
            return HttpStatus.OK;
        }
        
        // Nếu không update thành công thì trả về 304
        return HttpStatus.NOT_MODIFIED;
    }
    
    @PutMapping("/admin/api/approve-shipper")
    public HttpStatus approveShipper(@RequestParam(name = "adminId") int adminId,
            @RequestParam(name = "shipperId") int shipperId) {        
        
        System.out.println(adminId);
        if (this.shipperService.approveShipper(adminId, shipperId)) {
            return HttpStatus.OK;
        }
        
        // Nếu không update thành công thì trả về 304
        return HttpStatus.NOT_MODIFIED;
    }
}

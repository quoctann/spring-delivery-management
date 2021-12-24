// Admin tạm dừng hoạt động một shipper
function deactivateShipper(shipperId) {
    fetch(`/DeliveryManagement/admin/api/deactivate-shipper/${shipperId}`, {
        method: "put"
    }).then(function(res) {
        return res.status;
    }).then(function(data) {
        if (data === 200) {
            alert("Khóa tài khoản shipper thành công!");
            window.location.reload();
        } else {
            alert("Có lỗi xảy ra!")
            console.log(data)
        }
    });
};


// Admin kích hoạt lại hoạt động một shipper
function activateShipper(shipperId) {
    fetch(`/DeliveryManagement/admin/api/activate-shipper/${shipperId}`, {
        method: "put"
    }).then(function(res) {
        return res.status;
    }).then(function(data) {
        if (data === 200) {
            alert("Mở khóa tài khoản shipper thành công!");
            window.location.reload();
        } else {
            alert("Có lỗi xảy ra!")
            console.log(data)
        }
    });
}


// Admin phê duyệt một shipper (đồng thời cũng set active shipper này = true)
function approveShipper(adminId, shipperId) {
    fetch(`/DeliveryManagement/admin/api/approve-shipper?adminId=${adminId}&shipperId=${shipperId}`, {
        method: "put"
    }).then(function(res) {
        return res.status;
    }).then(function(data) {
        if (data === 200) {
            alert("Phê duyệt tài khoản shipper thành công!");
            window.location.reload();
        } else {
            alert("Có lỗi xảy ra!")
            console.log(data)
        }
    })
}


// Tìm kiếm, filter, phân trang khi các nút được bấm (ở trang shipper)
function getAdditionInfo() {   
    let filterType = document.getElementById("filterType").value;
    let username = document.getElementById("search").value;
    let page = 1;
    
    let path = "/DeliveryManagement/admin/shipper?";
    
    if (filterType !== null)
        path += `filterType=${filterType}&`;
    if (username !== null && username !== "")
        path += `username=${username}&`;
    if (page !== null)
        path += `page=${page}`;
    else {
        path += "page=1";
    }
    
    window.location.replace(path);
}


// Tìm kiếm, filter, phân trang khi các nút được bấm (ở trang order)
function getAdditionOrderInfo() {   
    let filterType = document.getElementById("filterType").value;
    let description = document.getElementById("search").value;
    let sort = document.getElementById("sort").value;
    let page = 1;
    
    let path = "/DeliveryManagement/admin/order?";
    
    filterType !== null ? path += `filterType=${filterType}&` : null;
    description !== null ? path += `description=${description}&` : null;
    sort !== null ? path += `sort=${sort}&` : null;
    page !== null ? path += `page=${page}` : path += "page=1";
    
    window.location.replace(path);
}
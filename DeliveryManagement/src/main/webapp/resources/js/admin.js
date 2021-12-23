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
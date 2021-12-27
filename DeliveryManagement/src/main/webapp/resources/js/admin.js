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


// Xử lý lọc theo ngày tháng, loại hàng hóa để thống kê doanh thu
function incomeStat() {
    let fromDate = document.getElementById("fromDate").value;
    let toDate = document.getElementById("toDate").value;
    let type = document.getElementById("type").value;
    
    let path = "/DeliveryManagement/admin/income-stat?";
    
    fromDate !== null && fromDate !== "" ? path += `fromDate=${fromDate}&` : null;
    toDate !== null && toDate !== "" ? path += `toDate=${toDate}&` : null;
    type !== null && type !== "" ? path += `type=${type}` : null;
    
    window.location.replace(path);
}

// THỐNG KÊ BÁO CÁO

// Sinh màu ngẫu nhiên cho biểu đồ
function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);
    return `rgb(${r}, ${g}, ${b})`;
}

// Biểu đồ thống kê doanh thu
function incomeChart(canvasId, labels = [], info = []) {
    let colors = [];
    for (let i = 0; i < info.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: labels,
        datasets: [{
                label: 'Thống kê doanh thu theo ngày',
                data: info,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data
    };
    
    let context = document.getElementById(canvasId).getContext("2d");
    new Chart(context, config);
}

// Biểu đồ thống kê số lượng đơn hàng
function orderChart(canvasId, labels = [], info = []) {   
    const data = {
        labels: labels,
        datasets: [{
                label: 'Thống kê tần suất giao hàng theo ngày',
                data: info,
                borderColor: 'rgb(75, 192, 192)',
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'line',
        data: data
    };
    
    let context = document.getElementById(canvasId).getContext("2d");
    new Chart(context, config);
}
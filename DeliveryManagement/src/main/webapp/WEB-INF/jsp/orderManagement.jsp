<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="shipper-man-page">
    <h4 class="mb-4">Quản lý thông tin đơn hàng</h4>

    <!-- Ô tìm kiếm -->
    <div class="row">
        <div class="col-md-6">
            <div class="input-group">
                <span class="input-group-text"><i class="fas fa-search"></i></span>
                <input name="search" id="search" type="text" class="form-control" placeholder="Tìm kiếm theo mô tả đơn hàng">
                <button onclick="getAdditionOrderInfo()" class="btn btn-primary">Tìm</button>
            </div>
        </div>

        <div class="col-md-6 row">
            <div class="col-5">
                <select class="form-select" name="filterType" id="filterType">
                    <option selected value="ALL">Tất cả</option>
                    <option value="PENDING">Chờ đấu giá</option>
                    <option value="SHIPPING">Đang giao</option>
                    <option value="SUCCESS">Thành công</option>
                    <option value="FAILED">Thất bại</option>
                </select>
            </div>
            <div class="col-5">
                <select class="form-select" name="sort" id="sort">
                    <option selected value="des">Mới nhất</option>
                    <option value="asc">Cũ nhất</option>
                </select>
            </div>
            <button onclick="getAdditionOrderInfo()" type="button" class="btn btn-primary col"><i class="fas fa-filter"></i> Lọc</button>
        </div>
    </div>

    <hr />

    <!-- Danh sách đơn hàng -->
    <div class="list-shipper row">
        <%--<c:forEach begin="1" end="9" var="i">--%>
        <c:forEach items="${orderList}" var="order">
            <div class="p-2 col-xs-12 col-md-4">
                <div class="card  shadow">
                    <div class="card-body">

                        <c:choose>
                            <c:when test="${order.status == 'PENDING'}">
                                <div class="alert alert-info"><i class="fas fa-hourglass-half me-1"></i> Đang chờ đấu giá</div>
                            </c:when>
                            <c:when test="${order.status == 'SHIPPING'}">
                                <div class="alert alert-primary"><i class="fas fa-shipping-fast me-1"></i> Đang giao hàng</div>
                            </c:when>
                            <c:when test="${order.status == 'SUCCESS'}">
                                <div class="alert alert-success"><i class="fas fa-clipboard-check me-1"></i> Đơn hàng thành công</div>
                            </c:when>
                            <c:when test="${order.status == 'FAILED'}">
                                <div class="alert alert-danger"><i class="fas fa-times-circle me-1"></i> Đơn hàng thất bại</div>
                            </c:when>
                        </c:choose>

                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">ID đơn hàng: ${order.id}</li>
                            <li class="list-group-item">Khách hàng (ID: ${order.customerId.user.id}): ${order.customerId.user.firstName} ${order.customerId.user.firstName}</li>
                            <li class="list-group-item">Shipper <a href="<c:url value="/admin/shipper?username=${order.shipperId.user.username}" />">(ID: ${order.shipperId.user.id})</a>: ${order.shipperId.user.firstName} ${order.shipperId.user.lastName}</li>
                            <li class="list-group-item price">Giá được chấp nhận: <span class="text-primary fw-bold">${order.price}</span></li>
                            <li class="list-group-item">Loại hàng: ${order.type}</li>
                            <li class="list-group-item">Ngày tạo: ${order.createdDate}</li>
                            <li class="list-group-item">Ngày hoàn thành: ${order.completedDate}</li>
                            <li class="list-group-item">Mô tả: ${order.description}</li>
                            <li class="list-group-item">SĐT người nhận: ${order.receiverPhone}</li>
                            <li class="list-group-item">Gửi từ: ${order.sentFrom}</li>
                            <li class="list-group-item">Gửi đến: ${order.sentTo}</li>
                            <li class="list-group-item">Phương thức thanh toán: ${order.paymentMethod}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Cụm nút phân trang -->
    <div class="d-flex justify-content-center my-2">
        <nav>
            <ul class="pagination shadow">
                <c:forEach begin="1" end="${Math.ceil(orderCount/6)}" var="count">
                    <li class="page-item"><a class="page-link" href="<c:url value="/admin/order?page=${count}" />">${count}</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>
<script>
    window.addEventListener("load", function () {
        let price = document.querySelectorAll(".price > span");
        for (let i = 0; i < price.length; i++) {
            let d = price[i];
            d.innerText = new Intl.NumberFormat('vi-VN', {
                style: 'currency',
                currency: 'VND'
            }).format(d.innerText);
        }
    });
</script>
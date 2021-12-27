<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/orderDetail/${order.id}" var="pick" />

<!-- OrderDetail -->
<section id="orderDetail">
    <div class="container">
        <h1 class="title text-center mt-5 mb-2">Chi tiết đơn hàng</h1>
        <div class="detail w-75 mx-auto my-5">
            <div class="row">
                <div class="bio-row col-6">
                    <p><span>Mã đơn hàng </span>: ${order.id}</p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Điện thoại người nhận </span>: ${order.receiverPhone}</p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Ngày tạo</span>: ${order.createdDate}</p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Loại hàng</span>: ${order.type}</p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Địa chỉ gửi </span>: ${order.sentFrom} </p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Địa chỉ nhận </span>: ${order.sentTo}</p>
                </div>
                <div class="bio-row col-6">
                    <p><span>Trạng thái</span>: ${order.status}</p>
                </div>
                <c:if test="${order.completedDate != null}" >
                    <div class="bio-row col-6">
                        <p><span>Ngày hoàn thành </span>: ${order.completedDate}</p>
                    </div>
                </c:if>
                <c:if test="${order.price != null}" >
                    <div class="bio-row col-6">
                        <p><span>Giá trị đơn </span>: ${order.price}</p>
                    </div>
                </c:if>
                <c:if test="${order.customerId != null}" >
                    <div class="bio-row col-6">
                        <p><span>Người đặt đơn: </span>: (ID: ${order.customerId.user.id}) ${order.customerId.user.firstName} ${order.customerId.user.lastName}</p>
                    </div>
                </c:if>
                <div class="bio-row col-12">
                    <p><span>Mô tả </span>: ${order.description}</p>
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-center">
            <div class="card p-4">
                <h3 class="pt-3 ps-3">Cập nhật trạng thái đơn hàng</h3>
                <div class="card-body d-flex justify-content-center">
                    <div class="btn-group" role="group">
                        <button onclick="updateStatus(${order.id}, 'SUCCESS')" type="button" class="btn btn-outline-primary">Đã giao thành công</button>
                        <button onclick="updateStatus(${order.id}, 'FAILED')" type="button" class="btn btn-outline-primary">Hủy đơn hàng</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="manpage">
    <h4>Trang quản trị hệ thống</h4>
    <hr />
    <ul class="list-group-flush">
        <li class="list-group-item">
            <a href="<c:url value='/admin/shipper'/>" class="btn btn-outline-primary btn-lg">Xem, chỉnh sửa thông tin shipper</a>
        </li>
        <li class="list-group-item">
            <a href="<c:url value='/admin/order'/>" class="btn btn-outline-primary btn-lg">Xem danh sách đơn hàng</a>
        </li>
        <li class="list-group-item">
            <a href="<c:url value='/admin/income-stat'/>" class="btn btn-outline-primary btn-lg">Thống kê</a>
        </li>
    </ul>
</div>

<style>

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/admin'/>"><i class="fas fa-user-shield me-1"></i> Xin chào: Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value='/admin'/>">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/admin/shipper'/>">Shipper</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/admin/order'/>">Đơn hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/admin/income-stat'/>">Thống kê</a>
                </li>
                
                <li class="nav-item">
                    <a class="btn btn-outline-light ms-2" href="<c:url value='/logout'/>">Đăng xuất <i class="fas fa-sign-out-alt ms-1"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <header>
        <nav class="navbar navbar-light navbar-expand-lg bg-light sticky-top">
            <div class="container header">
                <a class="navbar-brand row justify-content-center align-items-center" href="#">
                    <i class="fa fa-shipping-fast brand-logo col"></i>
                    <h1 class="brand-text col">ShipEveryWhere</h1>
                </a>
                <div class="collapse navbar-collapse me-auto menu" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Nhân viên</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đặt đơn</a>
                        </li>
                    </ul>
                </div>
                <!-- Phần đăng nhập/đăng ký -->
                <div class="signGroup d-flex justify-content-center align-items-center">
                    <a href="#" class="btn btnSignUp">Đăng ký</a>
                    <div class="horizontalDiviner"></div>
                    <a href="#" class="btn btnSignIn">Đăng nhập</a>
                </div>

                <!-- Phần này đã đăng nhập mới có -->
                <div class="account dropdown">
                    <div class="dropdown-toggle d-flex flex-direction-row justify-content-center align-items-center">
                        <!-- <i class="fa fa-user-circle account-icon"></i> -->
                        <img src="./image/Suar.png" alt='avatar' class="rounded-circle border border-primary me-2"
                            width="50" height="50" />
                        <div class="account-name">Name</div>
                    </div>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="#">Thông tin tài khoản</a></li>
                        <li><a class="dropdown-item" href="#">Lịch sử đơn hàng</a></li>
                        <li><a class="dropdown-item" href="#">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav class="navbar navbar-light navbar-expand-lg bg-light sticky-top">
        <div class="container header">
            <a class="navbar-brand row justify-content-center align-items-center" href="<c:url value="/" />">
                <i class="fa fa-shipping-fast brand-logo col"></i>
                <h1 class="brand-text col">ShipEveryWhere</h1>
            </a>
            <div class="collapse navbar-collapse me-auto menu" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="<c:url value="/" />">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/shipperList" />">Danh sách shipper</a>
                    </li>
                    <c:if test="${currentUser.userRole == 'ROLE_CUSTOMER'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/createOrder" />">Đặt đơn</a>
                        </li>
                    </c:if>
                    <c:if test="${currentUser.userRole == 'ROLE_SHIPPER'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/shipper/auction" />">Đấu giá</a>
                        </li>
                    </c:if>
                    <c:if test="${currentUser.userRole == 'ROLE_ADMIN'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin" />">Quản lý</a>
                        </li>
                    </c:if>
                </ul>
            </div>

            <c:if test="${pageContext.request.userPrincipal.name == null}" >
                <!-- Phần đăng nhập/đăng ký -->
                <div class="signGroup d-flex justify-content-center align-items-center">
                    <a href="<c:url value="/signup" />" class="btn btnSignUp">Đăng ký</a>
                    <div class="horizontalDiviner"></div>
                    <a href="<c:url value="/signin" />" class="btn btnSignIn">Đăng nhập</a>
                </div>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}" >
                <!-- Phần này đã đăng nhập mới có -->
                <div class="account dropdown">
                    <div class="dropdown-toggle d-flex flex-direction-row justify-content-center align-items-center">
                        <!-- <i class="fa fa-user-circle account-icon"></i> -->
                        <c:if test="${currentUser.avatar == null}">
                            <img src="<c:url value='/images/default.jpg' />" alt='avatar' class="rounded-circle border border-primary me-2"
                                 width="50" height="50" />
                        </c:if>

                        <c:if test="${currentUser.avatar != null}">
                            <img src="<c:url value='${currentUser.avatar}' />" alt='avatar' class="rounded-circle border border-primary me-2"
                                 width="50" height="50" />
                        </c:if>

                        <div class="account-name">${currentUser.firstName} ${currentUser.lastName}</div>
                    </div>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">

                        <c:choose>
                            <c:when test="${currentUser.userRole == 'ROLE_CUSTOMER'}">
                                <li><a class="dropdown-item" href="<c:url value="/customer/info" />">Thông tin tài khoản</a></li>
                            </c:when>

                            <c:when test="${currentUser.userRole == 'ROLE_SHIPPER'}">
                                <li><a class="dropdown-item" href="<c:url value="/shipper/info" />">Thông tin tài khoản</a></li>
                            </c:when>
                                
                            <c:when test="${currentUser.userRole == 'ROLE_ADMIN'}">
                                <li><a class="dropdown-item" href="<c:url value="/admin/info" />">Thông tin tài khoản</a></li>
                            </c:when>
                        </c:choose>
                        <li><a class="dropdown-item" href="<c:url value="/logout" />">Đăng xuất</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </nav>
</header>
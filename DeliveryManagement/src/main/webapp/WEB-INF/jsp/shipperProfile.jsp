<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Profile -->
<section id="profile">
    <div class="container my-5">
        <div class="row">
            <div class="profile-nav col-md-3 pt-0">
                <div class="panel">
                    <div class="profile-img ">
                        <c:if test="${currentUser.avatar == null}">
                            <a href="#">
                                <img src="/DeliveryManagement/images/default.jpg" class="rounded img-fluid" alt="">
                            </a>
                        </c:if>
                        <c:if test="${currentUser.avatar != null}">
                            <a href="#">
                                <img src="${currentUser.avatar}" class="rounded img-fluid" alt="">
                            </a>
                        </c:if>
                        <h2>${currentUser.firstName} ${currentUser.lastName}</h2>
                        <p>${currentUser.email}</p>
                        <p>Điểm đánh giá trung bình: ${avgRating}</p>
                    </div>
                    <ul class="nav nav-pills nav-stacked profile-nav-menu">
                        <li class="active"><a href="#"> <i class="fa fa-user"></i> Thông tin tài khoản</a></li>
                        <li><a href="#"> <i class="fa fa-calendar"></i> Danh sách đơn hàng</a></li>
                        <li><a href="#"> <i class="fa fa-edit"></i> Chỉnh sửa hồ sơ</a></li>
                    </ul>
                </div>
            </div>

            <!-- Lịch sử đơn hàng -->
            <div class="order-list col-md-9">

                <h3>Cập nhật thông tin</h3>

                <c:if test="${generalErr != null}">
                    <div class="alert alert-danger">${generalErr}</div>
                </c:if>

                <c:if test="${successfulUpdate != null}">
                    <div class="alert alert-success">${successfulUpdate}</div>
                </c:if>

                <c:url value="/shipper/user-info" var="userAction" />

                <div class="col-md-9">
                    <form:form modelAttribute="user" action="${userAction}">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">Tên</label>
                            <input type="text" name="firstName" class="form-control" id="firstName" value="${currentUser.firstName}">
                        </div>

                        <div class="mb-3">
                            <label for="lastName" class="form-label">Họ và tên đệm</label>
                            <input type="text" name="lastName" class="form-control" id="lastName" value="${currentUser.lastName}">
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" id="email" value="${currentUser.email}">
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Số điện thoại</label>
                            <input type="phone" name="phone" class="form-control" id="phone" value="${currentUser.phone}">
                        </div>
                        <button type="submit" class="btn btn-primary">Lưu</button>
                    </form:form>
                </div>

                <hr/>

                <c:url value="/shipper/info" var="action" />

                <div class="col-md-9">
                    <form:form modelAttribute="shipper" action="${action}">
                        <div class="mb-3">
                            <label for="idCard" class="form-label">Mã số CMND/CCCD</label>
                            <input type="idCard" name="idCard" class="form-control" id="idCard" value="${idCard}">
                        </div>
                        <button type="submit" class="btn btn-primary">Lưu</button>
                    </form:form>
                </div>

                <hr />

                <h3>Lịch sử đơn hàng</h1>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Mã đơn hàng</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col">Ngày đặt</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <th scope="row">${orders.indexOf(order) + 1}</th>
                                <td>${order.id}</td>
                                <c:choose>
                                    <c:when test="${order.status == 'SUCCESS'}">
                                        <td><button class="btn btn-success" disabled="disabled">${order.status}</button></td>
                                    </c:when>
                                    <c:when test="${order.status == 'FAILED'}">
                                        <td><button class="btn btn-danger" disabled="disabled">${order.status}</button></td>
                                    </c:when>
                                    <c:when test="${order.status == 'PENDING'}">
                                        <td><button class="btn btn-primary" disabled="disabled">${order.status}</button></td>
                                    </c:when>
                                    <c:when test="${order.status == 'SHIPPING'}">
                                        <td><button class="btn btn-warning" disabled="disabled">${order.status}</button></td>
                                    </c:when>
                                </c:choose>
                                <td>${order.createdDate}<span><a href="<c:url value='/orderDetail/${order.id}' />">Chi tiết</a></span></td>      
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
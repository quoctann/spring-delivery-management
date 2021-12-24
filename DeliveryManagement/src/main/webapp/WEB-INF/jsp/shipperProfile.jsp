<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Profile -->
<section id="profile">
    <div class="container my-5">
        <div class="row">
            <div class="profile-nav col-md-3">
                <div class="panel">
                    <div class="profile-img ">
                        <a href="#">
                            <img src="/image/Suar.png" class="w-100" alt="">
                        </a>
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

            <!--                 Profile 
                             <div class="profile-info col-md-9">
                                <div class="panel">
                                    <div class="panel-body info-content">
                                        <h1 classs="title">Hồ sơ người dùng</h1>
                                        <div class="row">
                                            <div class="bio-row col-6">
                                                <p><span>Họ và tên đệm </span>: Tôi tên</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>Tên </span>: Là</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>Địa chỉ </span>: ...</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>Ngày sinh</span>: Hôm qua</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>Email </span>: quenroi@konho.com</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>ID </span>:  288822887</p>
                                            </div>
                                            <div class="bio-row col-6">
                                                <p><span>Số điện thoại </span>: 012345678</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> -->

            <!-- Lịch sử đơn hàng -->
            <div class="order-list col-md-9">
                <h1 class="title">Lịch sử đơn hàng</h1>
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
                        <tr>
                            <th scope="row">1</th>
                            <td>12345678</td>
                            <td><button class="btn btn-status success" disabled="disabled">Success</button></td>
                            <td>20/11/2022<span><a href="#">Chi tiết</a></span></td>      
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>12345678</td>
                            <td><button class="btn btn-status pending" disabled="disabled">Waiting</button></td>
                            <td>20/11/2022<span><a href="#">Chi tiết</a></span></td>      
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12345678</td>
                            <td><button class="btn btn-status failed" disabled="disabled">Failed</button></td>
                            <td>20/11/2022<span><a href="#">Chi tiết</a></span></td>      
                        </tr>

                    </tbody>
                </table>

                <hr/>
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

                        <!--                        <div class="mb-3">
                                                    <label for="password" class="form-label">Mật khẩu</label>
                                                    <input type="password" name="password" class="form-control" id="password" placeholder="*******">
                                                </div>
                                                
                                                <div class="mb-3">
                                                    <label for="confirmPassword" class="form-label">Nhập lại mật khẩu</label>
                                                    <input type="confirmPassword" name="confirmPassword" class="form-control" id="confirmPassword" placeholder="*******">
                                                </div>-->

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
            </div>
        </div>
    </div>
</section>
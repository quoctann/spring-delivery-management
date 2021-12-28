<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/orderDetail/${order.id}" var="pick" />

<!-- OrderDetail -->
<section id="orderDetail">
    <div class="container">
        <h1 class="title text-center mt-5 mb-2">Chi tiết Đơn hàng</h1>
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
                <c:if test="${order.shipperId != null}" >
                    <div class="bio-row col-6">
                        <p><span>Shipper nhận đơn </span>: 
                            <a href="<c:url value='/shipper-detail/${order.shipperId.user.id}' />">${order.shipperId.user.firstName} ${order.shipperId.user.lastName}</a>
                        </p>
                    </div>
                </c:if>
                <div class="bio-row col-12">
                    <p><span>Mô tả </span>: ${order.description}</p>
                </div>
            </div>
        </div>
        <c:if test="${order.status == 'PENDING'}" >
            <div class="auction-shipper">
                <h1 class="title text-center mt-5 mb-2">Các shipper đang tham gia đấu giá</h1>
                <div class="sort d-flex align-items-center justify-content-end my-5">
                    <span>Sắp xếp theo :</span>
                    <select class="form-select w-10" aria-label="Default select">
                        <option value="#" selected><a href="#">Sao tăng dần</a></option>
                        <option value="#" selected><a href="#">Sao giảm dần</a></option>
                    </select>
                </div>
                <div class="shipperList">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Ảnh đại diện</th>
                                <th scope="col">Tên</th>
                                <th scope="col">Số tiền</th>
                                <th scope="col">Đánh giá</th>                           
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="s" items="${shippers}" varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.index+1}</th>
                                        <c:if test="${s.getUser().avatar == null}">
                                        <td><img src="<c:url value='/images/default.jpg' />" width="150" height="150" alt=""></td>
                                        </c:if>
                                        <c:if test="${s.getUser().avatar != null}">
                                        <td><img src="<c:url value='${s.getUser().avatar}' />" width="150" height="150" alt=""></td>
                                        </c:if>                           
                                    <td>${s.getUser().getFirstName()}</td>
                                    <td>${s.getpriceByOrderId(order.id)}VND</td>
                                    <td>${s.getAvgRating()} <i class="fa fa-star"></i> <span><a href="<c:url value='/shipper-detail/${s.getUser().id}' />">Thông tin Shipper</a></span></td>
                                    <td><button id="btnPickme" type="button" data="${s.shipperId}" dataP="${s.getpriceByOrderId(order.id)}" data-bs-toggle="modal" data-bs-target="#confirm" class="btn btn-readmore btn-pick">Chọn shipper này</button></td>      
                                </tr>
                            </c:forEach>                       
                        </tbody>
                    </table>
                    <div class="modal  fade" id="confirm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="confirmLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="confirmLabel">Xác nhận chọn shipper này ?</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form:form method="post" action="${pick}" modelAttribute="order" enctype="multipart/form-data" >
                                        <form:input path="shipperId" id="pickme" type="hidden" />
                                        <form:input path="price" id="priceFinal" type="hidden" />
                                        <form:input path="receiverPhone" value="${order.receiverPhone}" id="phone" type="hidden" />
                                        <form:input path="type" value=" ${order.type}" id="type" type="hidden" />
                                        <form:input path="sentFrom" value=" ${order.sentFrom}" id="sentFrom" type="hidden" />
                                        <form:input path="sentTo" value=" ${order.sentTo}" id="sentTo" type="hidden" />                               
                                        <form:input path="description" value=" ${order.description}" id="description" type="hidden" />
                                        <button class="btn btn-submit-form" type="submit">Xác nhận</button>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${order.status == 'SUCCESS'}">
            <c:if test="${order.rateStar == null}">
                <div class="d-flex justify-content-center">
                    <div class="w-50 card d-flex justify-content-center">
                        <div class="card-body">
                            <h3 class="card-title p-3 text-center">Đánh giá đơn hàng</h3>
                            <div class="row card-text">
                                <span class="col-2 d-flex justify-content-center">1 <i class="fas fa-star text-warning"></i></span>
                                <input name="rating" type="range" class="form-range col" min="1" max="5" step="1" id="rating">
                                <span class="col-2 d-flex justify-content-center">5 <i class="fas fa-star text-warning"></i></span>
                            </div>
                            <button onclick="rate(${order.id})" class="btn btn-primary m-4 w-100">Gửi đánh giá</button>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${order.rateStar != null}">
                <div class="d-flex justify-content-center">
                    <div class="w-50 card d-flex justify-content-center">
                        <div class="card-body">
                            <h3 class="card-title p-3 text-center">Bạn đã đánh giá đơn hàng này</h3>
                            <div class="text-center fs-1">
                                <c:forEach begin="1" end="${order.rateStar}">
                                    <span class="fw-bold"><i class="fas fa-star text-warning"></i></span>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:if>
    </div>
</section>

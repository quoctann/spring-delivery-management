<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="shipper-man-page">
    <h4 class="mb-4">Quản lý thông tin shipper</h4>

    <!-- Ô tìm kiếm -->
    <div class="row">
        <form class="col-md-6">
            <div class="input-group">
                <span class="input-group-text"><i class="fas fa-search"></i></span>
                <input name="search" type="text" class="form-control" placeholder="Tìm kiếm">
                <input type="submit" value="Tìm" class="btn btn-primary"/>
            </div>
        </form>

        <form class="col-md-6 row">
            <div class="col-10">
                <select class="form-select" name="filterType">
                    <option selected value="all">Tất cả</option>
                    <option value="pending">Chờ phê duyệt</option>
                    <option value="banned">Bị khóa tài khoản</option>
                    <option value="active">Đang hoạt động</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary col"><i class="fas fa-filter"></i> Lọc</button>
        </form>
    </div>

    <hr />

    <!-- Danh sách shipper -->
    <div class="list-shipper row">
        <%--<c:forEach var = "i" begin = "1" end = "5">--%>
        <c:forEach items="${shipperList}" var="i">
            <div class="p-2 col-xs-12 col-md-3">
                <div class="card  shadow">
                    <div class="card-body">
                        <c:if test="${i[6] != null}">
                            <img src="<c:url value="${i[6]}"/>" class="card-img-top mb-2 rounded" alt="avatar" style="height: 10rem">
                        </c:if>
                        <c:if test="${i[6] == null}">
                            <img src="<c:url value="/images/default.jpg"/>" class="card-img-top mb-2 rounded" alt="avatar" style="height: 10rem">
                        </c:if>
                        <h5 class="card-title">${i[2]} ${i[3]}</h5>
                        <c:if test="${i[10] == 1}">
                            <h6 class="card-subtitle mb-1 text-primary"><i class="fas fa-lock-open me-1"></i> Đang hoạt động</h6>
                        </c:if>
                        <c:if test="${i[10] != 1}">
                            <h6 class="card-subtitle mb-1 text-danger"><i class="fas fa-lock me-1"></i></i> Đã khóa tài khoản</h6>
                        </c:if>
                        <hr/>
                        <p class="card-text">Username: ${i[1]}</p>
                        <p class="card-text">Email: ${i[4]}</p>
                        <p class="card-text">Điện thoại: ${i[5]}</p>
                        <p class="card-text">CMND/CCCD: ${i[8]} </p>
                        <p class="card-text">Ngày tạo: ${i[7]}</p>
                        <p class="card-text">Đánh giá: ${i[9]}<i class="fas fa-star text-warning"></i></p>
                        <div class="d-flex justify-content-center">
                            <div class="btn-group">
                                <button onclick="approveShipper(${currentUser.id}, ${i[0]})" type="button" class="btn btn-success"><i class="fas fa-check me-1"></i></button>
                                <button onclick="deactivateShipper(${i[0]})" type="button" class="btn btn-danger"><i class="fas fa-lock me-1"></i></button>
                                <button onclick="activateShipper(${i[0]})" type="button" class="btn btn-primary"><i class="fas fa-lock-open me-1"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Cụm nút phân trang -->
    <div class="d-flex justify-content-center my-5">
        <nav>
            <ul class="pagination shadow">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>
</div>
<script></script>
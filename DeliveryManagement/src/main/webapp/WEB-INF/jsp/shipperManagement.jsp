<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="shipper-man-page">
    <h4 class="mb-4">Quản lý thông tin shipper</h4>

    <!-- Ô tìm kiếm -->
    <div class="row">
        <div class="col-md-6">
            <div class="input-group">
                <span class="input-group-text"><i class="fas fa-search"></i></span>
                <input name="search" id="search" type="text" class="form-control" placeholder="Tìm kiếm theo username">
                <!--                <input type="submit" value="Tìm" class="btn btn-primary"/>-->
                <button onclick="getAdditionInfo()" class="btn btn-primary">Tìm</button>
            </div>
        </div>

        <div class="col-md-6 row">
            <div class="col-10">
                <select class="form-select" name="filterType" id="filterType">
                    <c:choose>
                        <c:when test="${filterType == null || filterType == 'all'}">
                            <option selected value="all">Tất cả</option>
                            <option value="pending">Chờ phê duyệt</option>
                            <option value="inactive">Bị khóa tài khoản</option>
                            <option value="active">Đang hoạt động</option>
                        </c:when>

                        <c:when test="${filterType == 'pending'}">
                            <option value="all">Tất cả</option>
                            <option selected value="pending">Chờ phê duyệt</option>
                            <option value="inactive">Bị khóa tài khoản</option>
                            <option value="active">Đang hoạt động</option>
                        </c:when>

                        <c:when test="${filterType == 'inactive'}">
                            <option value="all">Tất cả</option>
                            <option value="pending">Chờ phê duyệt</option>
                            <option selected value="inactive">Bị khóa tài khoản</option>
                            <option value="active">Đang hoạt động</option>
                        </c:when>

                        <c:when test="${filterType == 'active'}">
                            <option value="all">Tất cả</option>
                            <option value="pending">Chờ phê duyệt</option>
                            <option value="inactive">Bị khóa tài khoản</option>
                            <option selected value="active">Đang hoạt động</option>
                        </c:when>
                    </c:choose>


                </select>
            </div>
            <button onclick="getAdditionInfo()" type="button" class="btn btn-primary col"><i class="fas fa-filter"></i> Lọc</button>
        </div>
    </div>

    <hr />
    
    <c:if test="${updateSuccess != null}" >
        <div class="alert alert-success">${updateSuccess}</div>
    </c:if>
    <c:if test="${updateFailed != null}" >
        <div class="alert alert-warning">${updateFailed}</div>
    </c:if>

    <!-- Danh sách shipper -->
    <div class="list-shipper row">
        <c:forEach items="${shipperList}" var="i">
            <div class="p-2 col-xs-12 col-md-4">
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
                        <p class="card-text">Ngày tạo: ${i[7]}</p>
                        <p class="card-text">Đánh giá: ${i[9]}<i class="fas fa-star text-warning"></i></p>
                        
                        <c:url value="/admin/shipper" var="action" />
                        
                        <form class="mb-3" action="${action}" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input name="email" type="text" class="form-control" id="email" value="${i[4]}">
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Điện thoại</label>
                                <input name="phone" type="text" class="form-control" id="phone" value="${i[5]}">
                            </div>
                            <div class="mb-3">
                                <label for="idCard" class="form-label">CCCD/CMND</label>
                                <input name="idCard" type="text" class="form-control" id="idCard" value="${i[8]}">
                            </div>
                            <input name="id" id="id" value="${i[0]}" style="display: none" />
                            <button type="submit" class="btn btn-primary w-100"><i class="fas fa-edit me-1"></i> Cập nhật thông tin</button>
                        </form>

                        <c:if test="${i[11] != null}">
                            <div class="alert alert-success"><i class="fas fa-user-check me-1"></i> Đã được phê duyệt</div>
                        </c:if>
                        <c:if test="${i[11] == null}">
                            <div class="alert alert-warning"><i class="fas fa-user-times me-1"></i> Đợi phê duyệt</div>
                        </c:if>
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
    <div class="d-flex justify-content-center my-2">
        <nav>
            <ul class="pagination shadow">
                <c:forEach begin="1" end="${Math.ceil(shipperCount/6)}" var="count">
                    <li class="page-item"><a class="page-link" href="<c:url value="/admin/shipper?page=${count}" />">${count}</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>
<script></script>
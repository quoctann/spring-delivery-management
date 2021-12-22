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
                </select>
            </div>
            <button type="submit" class="btn btn-primary col"><i class="fas fa-filter"></i> Lọc</button>
        </form>
    </div>

    <hr />

    <!-- Danh sách shipper -->
    <div class="list-shipper row">
        <c:forEach var = "i" begin = "1" end = "5">
            <div class="p-2 col-xs-12 col-md-3">
                <div class="card">
                    <div class="card-body">
                        <img src="<c:url value="/images/default.jpg"/>" class="card-img-top mb-2 rounded" alt="...">
                        <h5 class="card-title">Tên shipper</h5>
                        <h6 class="card-subtitle mb-1 text-muted">Trạng thái shipper</h6>
                        <p class="card-text">Username: uname</p>
                        <p class="card-text">Email: @mail</p>
                        <p class="card-text">Điện thoại: 123456789</p>
                        <p class="card-text">CMND/CCCD: 123456789</p>
                        <p class="card-text">Ngày tạo: 25/12/2021</p>
                        <p class="card-text">Đánh giá: 4.0 <i class="fas fa-star text-warning"></i></p>
                        <div class="d-flex justify-content-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-success"><i class="fas fa-check me-1"></i></button>
                                <button type="button" class="btn btn-danger"><i class="fas fa-lock me-1"></i></button>
                                <button type="button" class="btn btn-primary"><i class="fas fa-lock-open me-1"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Cụm nút phân trang -->
    <div class="d-flex justify-content-center">
        <nav>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#rateMe1').mdbRate();
    });
</script>
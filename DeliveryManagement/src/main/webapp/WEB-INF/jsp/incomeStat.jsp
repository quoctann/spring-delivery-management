<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <h4 class="mb-4">Thống kê doanh thu & tần suất giao hàng</h4>

    <div class="row">       
        <div class="col-md-6 row">
            <div class="col">
                <div class="mb-3 row">
                    <label for="fromDate" class="col-sm-3 col-form-label">Từ ngày:</label>
                    <div class="col-sm-9">
                        <input name="fromDate" type="date" class="form-control" id="fromDate">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="toDate" class="col-sm-3 col-form-label">Đến ngày:</label>
                    <div class="col-sm-9">
                        <input name="toDate" type="date" class="form-control" id="toDate">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <button onclick="incomeStat()" class="btn btn-primary form-control mb-3"><i class="fas fa-chart-line me-1"></i> Xem thống kê</button>
            <div class="mb-3 row">
                <label for="fromDate" class="col-sm-3 col-form-label">Loại hàng hóa:</label>
                <div class="col-sm-9">
                    <select name="type" id="type" class="form-select">
                        <option value="1">25x25 (cm)</option>
                        <option value="2">50x50 (cm)</option>
                        <option value="3">100x100 (cm)</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <hr />

    <div class="row">
        <h5 class="text-info mb-3">Thống kê doanh thu theo ngày</h5>
        <div class="col-md-6 col-sm-12">
            <div>
                <canvas id="incomeStatChart"></canvas>
            </div>
        </div>

        <div class="col-md-6 col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Ngày</th>
                        <th>Doanh thu</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${incomeData}" var="data">
                        <tr>
                            <td>${data[0]}/${data[1]}/${data[2]}</td>
                            <td class="currency">${data[4]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <hr />

    <div class="row">
        <h5 class="text-info mb-3">Thống kê số tần suất giao hàng theo ngày</h5>
        <div class="col-md-6 col-sm-12">
            <div>
                <canvas id="orderStatChart"></canvas>
            </div>
        </div>

        <div class="col-md-6 col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Ngày</th>
                        <th>Tổng số đơn hàng thành công</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${incomeData}" var="data">
                        <tr>
                            <td>${data[0]}/${data[1]}/${data[2]}</td>
                            <td>${data[3]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    window.addEventListener("load", function () {
        let price = document.querySelectorAll(".currency");
        for (let i = 0; i < price.length; i++) {
            let d = price[i];
            d.innerText = new Intl.NumberFormat('vi-VN', {
                style: 'currency',
                currency: 'VND'
            }).format(d.innerText);
        }
    });

    let labels = [], info = [], oInfo = [];
    <c:forEach items="${incomeData}" var="data">
        labels.push("${data[0]}/${data[1]}/${data[2]}");
        info.push("${data[4]}");
        oInfo.push("${data[3]}");
    </c:forEach>
        window.addEventListener("load", function () {
            incomeChart("incomeStatChart", labels, info);
            orderChart("orderStatChart", labels, oInfo);
        });
</script>
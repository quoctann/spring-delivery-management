<%-- 
    Document   : auction
    Created on : Dec 20, 2021, 8:07:05 PM
    Author     : beanp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/shipper/auction" var="action" />

<!-- Auction -->
<section id="auction">
    <div class="container">
        <h1 class="title my-5 text-center">Đấu giá</h1>
        <div class="auction-header row mt-5 mb-1">
            <div class="search-bar col-5">
                <form action="">
                    <div class="input-group mb-3">
                        <input type="text" placeholder="Tìm kiếm.." class="form-control" name="keyword" id="keyword"
                               aria-label="search" aria-describedby="basic-addon2">
                        <span class="input-group-text" id="basic-addon2"><Button type="submit"><i
                                    class="fa fa-search"></i></Button></span>
                    </div>
                </form>
            </div>
            <div class="sort col-7 d-flex align-items-center justify-content-end">
                <span>Sắp xếp theo :</span>
                <select id="sort" class="form-select" onchange="location = this.value;" aria-label="Default select">
                    <option value="<c:url value="/shipper/auction?sort=des"/>" >Gần đây</option>
                    <option value="<c:url value="/shipper/auction?sort=asc"/>" >Cũ nhất</option>
                </select>
            </div>
        </div>
        <hr>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Hình ảnh</th>
                    <th scope="col">Chủ đề</th>
                    <th scope="col">Loại hàng</th>
                    <th scope="col">Từ</th>
                    <th scope="col">Đến</th>
                    <th scope="col">Đấu giá</th>
                    <th scope="col">Thời gian</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${orders}" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td><img src="<c:url value='/images/Suar.png' />" width="150" height="150" alt=""></td>
                        <td><b>${o.description}</b></td>
                        <td>Loại ${o.type}</td>
                        <td>${o.sentFrom}</td>
                        <td>${o.sentTo}</td>                      
                        <td><button class="btn btn-primary btnAuction" data="${o.id}" data-bs-toggle="modal" data-bs-target="#auctionModal">Đấu giá</button></td>
                        <td><i id="time">${o.createdDate}</i></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="modal fade" id="auctionModal" tabindex="-1" aria-labelledby="auctionModal" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h5 class="modal-title" id="exampleModalLabel">Đấu giá</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form:form method="post" action="${action}" modelAttribute="auction" >
                            <form:input path="price" id="price" class="input" type="number" step="1000" min="0" />
                            <label for="price">VND</label>
                            <form:input path="orderId" id="orderId" class="input" type="hidden" />
                            <form:input path="shipperId" id="shipperId" value="${shipper_id}" class="input" type="hidden" />
                            <br>
                            <button class="btn btn-readmore" type="submit">Đấu giá</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <div class="pagination d-flex justify-content-center my-5">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${Math.ceil(count/10)}" var="i" >
                        <li class="page-item">
                            <a class="page-link" href="<c:url value="/shipper/auction"/>?page=${i}">
                                    ${i}
                                </a>
                            </li>
                    </c:forEach>                
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</section>
                
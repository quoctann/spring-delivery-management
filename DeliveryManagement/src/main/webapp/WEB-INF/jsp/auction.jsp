<%-- 
    Document   : auction
    Created on : Dec 20, 2021, 8:07:05 PM
    Author     : beanp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <select class="form-select" aria-label="Default select">
                    <option value="#" selected><a href="#">Gần đây</a></option>
                    <option selected><a href="#"></a></option>>
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
                        <td><button class="btn btn-primary btnAuction" data="10" data-bs-toggle="modal" data-bs-target="#auctionModal">Đấu giá</button></td>
                        <td><i id="time">${o.createdDate}</i></td>
                    </tr>
                </c:forEach>
                <!--                <tr>
                                    <th scope="row">1</th>
                                    <td><img src="<c:url value='/images/Suar.png' />" width="150" height="150" alt=""></td>
                                    <td><b>Cần chuyển hàng đi đâu đó</b></td>
                                    <td>Loại 1</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>                      
                                    <td><button class="btn btn-primary btnAuction" data="10" data-bs-toggle="modal" data-bs-target="#auctionModal">Đấu giá</button></td>
                                    <td><i>12 Giờ trước</i></td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td><img src="<c:url value='/images/Suar.png' />" width="150" height="150" alt=""></td>
                                    <td><b>Cần chuyển hàng đi đâu đó</b></td>
                                    <td>Loại 1</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>                      
                                    <td><button class="btn btn-primary btnAuction" data="0" data-bs-toggle="modal" data-bs-target="#auctionModal">Đấu giá</button></td>
                                    <td><i>12 Giờ trước</i></td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td><img src="<c:url value='/images/Suar.png' />" width="150" height="150" alt=""></td>
                                    <td><b>Cần chuyển hàng đi đâu đó</b></td>
                                    <td>Loại 1</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>
                                    <td>123, Xã abc gì đó, Huyện không biết, Thành phố Hồ Chí Minh</td>                      
                                    <td><button class="btn btn-primary btnAuction" data="5" data-bs-toggle="modal" data-bs-target="#auctionModal">Đấu giá</button></td>
                                    <td><i>12 Giờ trước</i></td>
                                </tr>-->
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
                        <form action="">
                            <input id="price" class="input" type="number" step="1000" min="0">
                            <label for="price">VND</label>
                            <br>
                            <button class="btn btn-readmore" type="submit">Đấu giá</button>
                        </form>
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
                            <a class="page-link" href="<c:url value="/auction"/>?page=${i}">
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
                
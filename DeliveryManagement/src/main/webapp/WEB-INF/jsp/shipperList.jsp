<%-- 
    Document   : shipperList
    Created on : Dec 20, 2021, 8:06:07 PM
    Author     : beanp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section id="shipper-list">
        <div class="container">
            <h1 class="title text-center my-5">Shipper</h1>
            <div class="list-header row mt-5 mb-1">
                <div class="search-bar col-5">
                    <form action="">
                        <div class="input-group mb-3">
                            <input type="text" placeholder="Tìm kiếm.." class="form-control" name="search" id="search"
                                aria-label="search" aria-describedby="basic-addon2">
                            <span class="input-group-text" id="basic-addon2"><Button type="submit"><i
                                        class="fa fa-search"></i></Button></span>
                        </div>
                    </form>
                </div>
                <div class="sort col-7 d-flex align-items-center justify-content-end">
                    <span>Sắp xếp theo :</span>
                    <select class="form-select" aria-label="Default select">
                        <option value="#" selected><a href="#">Tên</a></option>
                        <option selected><a href="#">Đánh giá</a></option>>
                    </select>
                </div>
            </div>
            <hr />
            <div class="list-content row">
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
                <!-- list item -->
                <div class="list-item col-3">
                    <div class="card">
                        <img src="/image/Suar.png" class="card-img-top w-70" alt="...">
                        <div class="card-body text-center bg-light">
                            <h5 class="card-title">Tôi là ?</h5>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <a href="#" class="card-link btn btn-readmore">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <!-- End List item block -->
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
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
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
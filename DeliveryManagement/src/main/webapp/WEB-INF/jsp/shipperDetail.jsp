<%-- 
    Document   : shipperProfile
    Created on : Dec 20, 2021, 8:09:23 PM
    Author     : beanp
--%>

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
                            <h2>Tôi tên là</h2>
                            <div class="rate">
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star active"></i>
                                <i class="fa fa-star-half-alt active"></i>
                            </div>
                            <p>Số điện thoại: <a href="tel:+0364552651">0364552***</a></p>
                        </div>
                    </div>
                </div>


                <!-- Bình luận -->
                <div class="comment col-md-9">
                    <h1 class="title">Bình luận và đánh giá</h1>
                    <!-- Đăng nhập rồi mới có -->
                    <div class="row cmt-input align-items-center justify-content-center">
                        <div class="current-user-avatar col-2">
                            <img class="avatar w-100 h-100" src="/image/Suar.png" alt="nothing">
                        </div>
                        <form class="d-flex col-10" action="" method="post">
                            <textarea class="flex-fill input" id="comment" rows="1" type="text" placeholder="Nhập bình luận"></textarea>
                            <button class="btn btn-readmore" type="submit">Bình luận</button>
                        </form>
                    </div>
                    <!-- End input block -->
                    <div class="comment-box row justify-content-end">
                        <div class="comment-item row col-12">
                            <div class="current-user-avatar col-2">
                                <img class="avatar w-100 h-100" src="/image/Suar.png" alt="nothing">
                            </div>
                            <div class="comment-content col-10">
                                <b>Name</b> <span>29/10/2000</span>
                                <br>
                                <div class="comment-text">
                                    Một hai ba bốn năm sáu bảy tám chín mười mười một mười hai mười ba
                                </div>
                            </div>
                        </div>
                        <div class="comment-item row col-12">
                            <div class="current-user-avatar col-2">
                                <img class="avatar w-100 h-100" src="/image/Suar.png" alt="nothing">
                            </div>
                            <div class="comment-content col-10">
                                <b>Name</b> <span>29/10/2000</span>
                                <br>
                                <div class="comment-text">
                                    Một hai ba bốn năm sáu bảy tám chín mười mười một mười hai mười ba, Một hai ba bốn năm sáu bảy tám chín mười mười một mười hai mười ba, Một hai ba bốn năm sáu bảy tám chín mười mười một mười hai mười ba
                                </div>
                            </div>
                        </div>
                        <div class="comment-item row col-12">
                            <div class="current-user-avatar col-2">
                                <img class="avatar w-100 h-100" src="/image/Suar.png" alt="nothing">
                            </div>
                            <div class="comment-content col-10">
                                <b>Name</b> <span>29/10/2000</span>
                                <br>
                                <div class="comment-text">
                                    Một hai ba bốn năm sáu bảy tám chín mười mười một mười hai mười ba
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
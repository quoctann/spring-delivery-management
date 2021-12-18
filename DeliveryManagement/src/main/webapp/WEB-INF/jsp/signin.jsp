<%-- 
    Document   : signin
    Created on : Dec 15, 2021, 3:04:46 PM
    Author     : beanp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/login" var="action" />

<section class="my-5" id="signIn">
    <div class="container">
        <form method="post" action="${action}">
            <h1 class="text-center sign-title">Đăng nhập</h1>
            <div class="form-input text-center">
                <input required='' oninvalid="setCustomValidity(' ')" class="input input-username" type="text"
                       name="username" id="username" placeholder="Tên đăng nhập">
                <br />
                <span class="input-helpText "><i class="fa fa-exclamation-triangle"></i> Không được để trống</span>
            </div>
            <div class="form-input text-center">
                <input class="input input-password" type="password" name="password" id="password"
                       placeholder="Mật khẩu">
                <br />
            </div>
            <button class="btn btn-submit-form" type="submit">Đăng nhập</button>
            <a class="forgotPass text-center d-block" href="#">Quên mật khẩu ?</a>
        </form>
    </div>
</section>

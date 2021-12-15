<%-- 
    Document   : signup
    Created on : Dec 15, 2021, 3:05:49 PM
    Author     : beanp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<section class="my-5" id="signUp">
        <div class="container">
            <form method="post" action="">
                <h1 class="text-center sign-title">Đăng Ký</h1>
                <div class="form-input text-center row justify-content-center">
                    <input class="input input-firstName" required type="text" name="firstName" id="firstName"
                        placeholder="Họ và tên đệm">
                    <input class="input input-lastName" required type="text" name="lastName" id="lastName" placeholder="Tên">
                    <br/>
                </div>
                <div class="form-input text-center">
                    <input class="input input-username" type="text" name="username" id="username"
                        placeholder="Tên đăng nhập">
                    <br />
                </div>
                <div class="form-input text-center">
                    <input class="input input-password" type="password" name="password" id="password"
                        placeholder="Mật khẩu">
                    <br />
                </div>
                <div class="form-input text-center">
                    <input class="input input-confirmPassword" type="password" name="confirmPassword"
                        id="confirmPassword" placeholder="Xác nhận lại mật khẩu">
                    <br />
                    <span class="input-helpText" id="error-confirmPassword"><i class="fa fa-exclamation-triangle"></i> Mật khẩu chưa trùng khớp !</span>
                </div>
                <div class="form-input text-center">
                    <input class="input input-email" type="email" name="email" id="email" placeholder="Email">
                    <br />
                </div>
                <div class="form-input text-center">
                    <input class="input input-phone"
                        pattern="(0|\+84)(\s|\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\d)(\s|\.)?(\d{3})(\s|\.)?(\d{3})"
                        type="text" name="password" id="phone" placeholder="Số điện thoại">
                    <br />
                </div>
                <div class="form-input text-center">
                    <input class="input input-id" pattern="(([0-9]){9}|([0-9]){12})" type="text" name="id" id="id"
                        placeholder="CMND/CCCD">
                    <br />
                </div>
                <div class="form-input text-center">
                    <img id="show-img" width="190" height="250" src="./image/Suar.png" alt="avatar">
                    <br/>
                    <label class="btn-input-img" for="file">Chọn avatar...</label>
                    <input class="input-img d-none" onchange="showAvatar()" type="file" name="file" id="file">
                </div>
                <button class="btn btn-submit-form" type="submit">Đăng Ký</button>
            </form>
        </div>
    </section>

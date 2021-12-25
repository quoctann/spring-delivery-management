<%-- 
    Document   : createOrder
    Created on : Dec 25, 2021, 8:17:30 AM
    Author     : beanp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/createOrder" var="createO" />

 <!-- Đặt đơn -->
    <section class="my-5" id="signUp">
        <div class="container">
            <form:form method="post" action="${createO}" modelAttribute="order">
                <h1 class="text-center sign-title">Đặt đơn</h1>
                <div class="form-input text-center">
                    <form:textarea path="description" class="input" type="text" name="description" id="description" rows="1"
                        placeholder="Mô tả"></form:textarea>
                    <br />
                </div>
                <div class="form-input text-center">
                    <form:input path="receiverPhone" class="input input-phone"
                        pattern="(0|\+84)(\s|\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\d)(\s|\.)?(\d{3})(\s|\.)?(\d{3})"
                        type="text" name="password" id="phone" placeholder="Số điện thoại người nhận" />
                    <br />
                </div>               
                <div class="form-input text-center">
                    <form:input path="sentFrom" class="input" type="text" name="sentFrom" id="sentFrom"
                        placeholder="Nơi gửi" />
                    <br />
                </div>
                <div class="form-input text-center">
                    <form:input path="sentTo" class="input" type="text" name="sentTo" id="sentTo"
                        placeholder="Nơi nhận" />
                    <br />
                </div>
                <div class="form-input text-center d-flex justify-content-center align-items-center">
                    <label for="goodType">Loại :</label>
                    <form:select path="type" id="goodType" class="form-select w-28" aria-label="select type">
                        <option value="1">25x25 (cm)</option>
                        <option value="2">50x50 (cm)</option>
                        <option value="3">100x100 (cm)</option>
                    </form:select>
                </div>
               
                <button class="btn btn-submit-form" type="submit">Tạo đơn</button>
            </form:form>
        </div>
    </section>

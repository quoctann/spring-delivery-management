<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Profile shipper -->
<section id="profile">
    <div class="container my-5">
        <div class="row">
            <div class="profile-nav col-md-3">
                <div class="panel">
                    <div class="profile-img ">
                        <a href="#">
                            <img src="/image/Suar.png" class="w-100" alt="">
                        </a>
                        <p>Thông tin tài xế vận chuyển</p>
                        <h2>${userAsShipperInfo.firstName}</h2>
                        <p>Điểm đánh giá: ${shipperInfo.avgRating}</p>
                        <div class="rate">
                            <c:forEach begin="1" end="${shipperInfo.avgRating}">
                                <i class="fa fa-star active"></i>
                            </c:forEach>
                        </div>
                        <!--<p>Số điện thoại: <a href="tel:+0364552651">0364552***</a></p>-->
                    </div>
                </div>
            </div>


            <!-- Bình luận -->
            <div class="comment col-md-9">
                <h1 class="title">Bình luận</h1>
                <!-- Đăng nhập bằng customer rồi mới có -->
                <c:if test="${currentUser.userRole == 'ROLE_CUSTOMER'}">
                    <div class="row cmt-input align-items-center justify-content-center">
                        <c:if test="${currentUser.avatar == null}">
                            <div class="current-user-avatar col-2">
                                <img class="avatar w-100 h-100" src="<c:url value='/images/default.png' />" alt="nothing">
                            </div>
                        </c:if>
                        <c:if test="${currentUser.avatar != null}">
                            <div class="current-user-avatar col-2">
                                <img class="avatar w-100 h-100" src="${currentUser.avatar}" alt="nothing">
                            </div>
                        </c:if>

                        <form class="d-flex col-10">
                            <textarea class="flex-fill input" id="comment" rows="1" type="text" placeholder="Nhập bình luận"></textarea>
                            <button 
                                class="btn btn-readmore" 
                                type="button" 
                                onclick="addComment(${shipperInfo.shipperId}, '${currentUser.firstName}', '${currentUser.lastName}', '${currentUser.avatar}' )"
                            >Bình luận</button>
                        </form>
                    </div>
                </c:if>
                <!-- End input block -->
                <div class="comment-box row justify-content-end" id="commentBox">
                    <c:forEach items="${shipperInfo.commentSet}" var="comment">
                        <div class="comment-item row col-12">
                            <c:if test="${comment.customerId.user.avatar == null}">
                                <div class="current-user-avatar col-2">
                                    <img class="avatar w-100 h-100" src="<c:url value='/images/default.jpg' />" alt="nothing">
                                </div>
                            </c:if>
                            <c:if test="${comment.customerId.user.avatar != null}">
                                <div class="current-user-avatar col-2">
                                    <img class="avatar w-100 h-100" src="${comment.customerId.user.avatar}" alt="nothing">
                                </div>
                            </c:if>
                            
                            <div class="comment-content col-10 commentDate">
                                <b>${comment.customerId.user.firstName} ${comment.customerId.user.lastName}</b> 
                                <span>${comment.createdDate}</span>
                                <br>
                                <div class="comment-text">${comment.content}</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    window.addEventListener("load", function() {
        let dates = document.querySelectorAll(".commentDate > span");
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
//            console.log("js on detail page")
        }
    });
</script>
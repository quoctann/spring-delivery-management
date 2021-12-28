
// Preloader
window.onload = function() {
  let preloader = document.querySelector(".preloader");
  preloader.style.display = "none";
}

// Pass data to modal
var modalInput = document.querySelector("#price");
var hiddenInput = document.querySelector("#orderId");
var btnAuction = document.querySelectorAll(".btnAuction");
btnAuction.forEach((btn)=> {
  btn.addEventListener("click", () => {
    console.log(btn);
    let data = btn.getAttribute("data");
    hiddenInput.value = data;
  }) 
})

//// Pass data to modal!!!!!
var btnPick = document.querySelectorAll("#btnPickme");
var pickInput = document.querySelector("#pickme");
var price = document.querySelector("#priceFinal");

btnPick.forEach((btn)=> {
  btn.addEventListener("click", () => {
    let data = btn.getAttribute("data");
    let pric = btn.getAttribute("dataP");
    pickInput.value = data;
    price.value = pric;
  })
  })


function showAvatar() {
  var file = document.getElementById("file").files[0];
  var reader = new FileReader();
  var avatarImg = document.getElementById("show-img");
  reader.addEventListener(
    "load",
    function () {
      avatarImg.src = reader.result;
    },
    false
  );
  if (file) {
    reader.readAsDataURL(file);
  }
}

//Trigger lỗi rỗng
// var required_input = document.querySelectorAll('input[required]')
// console.log(required_input);

// required_input.forEach((item)=> {
//   item.addEventListener("onchange", nullErr(item));
// });

// function nullErr(item) {
//   let helpTextId = item.id + "-errNull";
//   let nullErr = document.getElementById(helpTextId);
//   console.log(nullErr);
//   if (!item.value) {
//     item.setCustomValidity("Không được để trống");
//     nullErr.style.display="inline";
//   } else {
//     item.setCustomValidity("");
//     nullErr.style.display="none";
//   }
// }

// Scroll to Top

const scrollToTop = () => {
  window.scrollTo({ top: 0, behavior: 'smooth' });
}

const checkScroll = () => {
  if (document.body.scrollTop > 500 || document.documentElement.scrollTop > 500) {
    document.querySelector(".scrollToTop").style.display = "block";
} else {
     document.querySelector(".scrollToTop").style.display = "none";
}
}

window.onscroll = () => {checkScroll()}

//Animate on scroll
const observer = new IntersectionObserver(entries => {
  entries.forEach(entry => {  
    const item = entry.target.querySelectorAll('.info-item');

    if (entry.isIntersecting) {
      for (let i = 0; i < 4; i++) {
        let cls = '';
        switch (i) {
          case 0 : cls = 'fadeRight'; break;
          case 1 : cls = 'fadeDown'; break;
          case 2 : cls = 'fadeUp'; break;
          case 3 : cls = 'fadeLeft'; break;
        }
        item.item(i).classList.add(cls);
      }
	  return; 
    }

    item.forEach(i => {
      i.classList.remove('fadeUp', 'fadeDown', 'fadeRight', 'fadeLeft');
    })
  });
});

observer.observe(document.querySelector('.info-content'));  

// Confirm password
var password = document.getElementById("password");
var confirm_password = document.getElementById("confirmPassword");
var confirm_password_errorText = document.getElementById("error-confirmPassword");

function validatePassword() {
    console.log(confirm_password_errorText.style.display);

  if (password.value !== confirm_password.value) {
    confirm_password.setCustomValidity("Mật khẩu chưa khớp");
    confirm_password_errorText.style.display = 'inline';
  } else {
    confirm_password.setCustomValidity("");
   confirm_password_errorText.style.display = 'none';
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

/*
 *  +----------------------+
 *  |                      |
 *  |   CÁC CHỨC NĂNG API  |
 *  |                      |
 *  +----------------------+
 */

// Thêm comment trang shipper detail
function addComment(shipperId, firstName, lastName, avatar) {
    fetch("/DeliveryManagement/api/add-comment", {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("comment").value,
            "shipperId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.log(data);
        let area = document.getElementById("commentBox");
        if (avatar === null || avatar === "") {
            avatar = "/DeliveryManagement/images/default.jpg";
        }
        date = new Date(data.createdDate);
        createdDate = moment(date).fromNow();
        area.innerHTML = `
        <div class="comment-item row col-12">
            <div class="current-user-avatar col-2">
                <img class="avatar w-100 h-100" src="${avatar}" alt="nothing">
            </div>
            <div class="comment-content col-10 commentDate">
                <b>${firstName} ${lastName}</b> 
                <span>${createdDate}</span>
                <br>
                <div class="comment-text">${data.content}</div>
            </div>
        </div>
        ` + area.innerHTML;
    });
}


// Khách hàng đánh giá đơn hàng
function rate(orderId) {
    let value = document.getElementById("rating").value;
    if (orderId === null || value === null) {
        alert("Không hợp lệ");
        return;
    }
    
    fetch(`/DeliveryManagement/rate-order/${orderId}?value=${value}`, {
      method: "put"  
    }).then(function(res) {
        return res.status;
    })
    .then(function(data) {
        if (data === 200) {
            alert("Đánh giá thành công!")
            window.location.reload();
        } else if (data === 500)
            alert("Lỗi server!")
        else
            alert("Lỗi không xác định, mã lỗi: ", data);
    });
}


// Shipper cập nhật trạng thái đơn hàng
function updateStatus(orderId, status) {
    
    if (orderId === null || status === null) {
        alert("Không hợp lệ");
        return;
    }
    
    fetch(`/DeliveryManagement/order-status/${orderId}?status=${status}`, {
      method: "put"  
    }).then(function(res) {
        return res.status;
    })
    .then(function(data) {
        if (data === 200) {
            alert("Cập nhật thành công!")
            window.location.reload();
        } else if (data === 500)
            alert("Lỗi server!")
        else
            alert("Lỗi không xác định, mã lỗi: " + data);
    });
}
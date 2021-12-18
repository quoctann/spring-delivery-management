
// Preloader
window.onload = function() {
  let preloader = document.querySelector(".preloader");
  preloader.style.display = "none";
}


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
document.addEventListener('DOMContentLoaded', () => {
  const checkBtn = document.querySelector('.checkbtn');
  const navMenu = document.querySelector('.nav-menu');

  checkBtn.addEventListener('click', () => {
    navMenu.classList.toggle('active');
  });
});
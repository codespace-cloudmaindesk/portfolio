document.addEventListener('DOMContentLoaded', function () {
    initNavToggle();
});

function initNavToggle() {
    const toggle = document.querySelector('.nav-toggle');
    const menu = document.querySelector('.nav-menu');
    if (!toggle || !menu) return;

    toggle.addEventListener('click', function () {
        toggle.classList.toggle('active');
        menu.classList.toggle('active');
    });
}
(function () {

    var toggle;
    var menu;

    function onHamburgerClick() {
        var isOpen = menu.classList.toggle('active');
        toggle.classList.toggle('active', isOpen);
    }

    function closeMenu() {
        menu.classList.remove('active');
        toggle.classList.remove('active');
    }

    function bindLinkClose(link) {
        link.addEventListener('click', closeMenu);
    }

    function onDocClick(e) {
        var clickedInsideMenu   = menu.contains(e.target);
        var clickedOnToggle     = toggle.contains(e.target);
        if (!clickedInsideMenu && !clickedOnToggle) closeMenu();
    }

    function initNav() {
        toggle = document.querySelector('.nav-toggle');
        menu   = document.querySelector('.nav-menu');
        if (!toggle || !menu) return;

        toggle.addEventListener('click', onHamburgerClick);
        menu.querySelectorAll('a').forEach(bindLinkClose);
        document.addEventListener('click', onDocClick);
    }

    window.__appInits = window.__appInits || [];
    window.__appInits.push(initNav);

})();


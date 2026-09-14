(function () {

    var toggle;
    var menu;

    function onHamburgerClick(e) {
        e.stopPropagation();
        var isOpen = menu.classList.toggle('active');
        toggle.classList.toggle('active', isOpen);
    }

    function onHamburgerTouch(e) {
        // Prevent the 300ms click delay on mobile
        e.preventDefault();
        onHamburgerClick(e);
    }

    function closeMenu() {
        menu.classList.remove('active');
        toggle.classList.remove('active');
    }

    function bindLinkClose(link) {
        link.addEventListener('click', closeMenu);
    }

    function onDocClick(e) {
        var clickedInsideMenu = menu.contains(e.target);
        var clickedOnToggle   = toggle.contains(e.target);
        if (!clickedInsideMenu && !clickedOnToggle) closeMenu();
    }

    function initNav() {
        toggle = document.querySelector('.nav-toggle');
        menu   = document.querySelector('.nav-menu');
        if (!toggle || !menu) return;

        // touchstart fires before click – eliminates 300ms tap delay on mobile
        toggle.addEventListener('touchstart', onHamburgerTouch, { passive: false });
        toggle.addEventListener('click', onHamburgerClick);

        menu.querySelectorAll('a').forEach(bindLinkClose);
        document.addEventListener('click', onDocClick);
    }

    // Script is embedded inside the nav fragment — DOM is already ready, init immediately.
    initNav();

})();

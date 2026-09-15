(function () {

    var toggle;
    var menu;
    var overlay;

    function openMenu() {
        menu.classList.add('active');
        toggle.classList.add('active');
        overlay.classList.add('active');
        document.body.style.overflow = 'hidden'; // prevent background scroll
    }

    function closeMenu() {
        menu.classList.remove('active');
        toggle.classList.remove('active');
        overlay.classList.remove('active');
        document.body.style.overflow = '';
    }

    function onHamburgerClick(e) {
        e.stopPropagation();
        var isOpen = menu.classList.contains('active');
        if (isOpen) { closeMenu(); } else { openMenu(); }
    }

    function onHamburgerTouch(e) {
        // Prevent the 300ms click delay on mobile
        e.preventDefault();
        onHamburgerClick(e);
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
        toggle  = document.querySelector('.nav-toggle');
        menu    = document.querySelector('.nav-menu');
        overlay = document.querySelector('.nav-overlay');
        if (!toggle || !menu) return;

        // touchstart fires before click – eliminates 300ms tap delay on mobile
        toggle.addEventListener('touchstart', onHamburgerTouch, { passive: false });
        toggle.addEventListener('click', onHamburgerClick);

        // clicking the overlay closes the drawer
        if (overlay) {
            overlay.addEventListener('click', closeMenu);
            overlay.addEventListener('touchstart', closeMenu, { passive: true });
        }

        menu.querySelectorAll('a').forEach(bindLinkClose);
        document.addEventListener('click', onDocClick);
    }

    // Script is embedded inside the nav fragment — DOM is already ready, init immediately.
    initNav();

})();

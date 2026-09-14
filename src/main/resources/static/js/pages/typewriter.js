(function () {
    var CONFIG = {
        typingSpeed:     90,   
        deletingSpeed:   50,   
        pauseAfterType:  2000, 
        pauseBeforeNext: 400, 
        startDelay:      1000, 
    };


    function merge(base, overrides) {
        var out = {};
        for (var k in base)      { out[k] = base[k]; }
        for (var k in overrides) { out[k] = overrides[k]; }
        return out;
    }

    function nextStep(state, textLength) {
        var roleIndex  = state.roleIndex;
        var charIndex  = state.charIndex;
        var isDeleting = state.isDeleting;
        var roleCount  = state.roleCount;

        if (!isDeleting && charIndex < textLength)
            return { next: merge(state, { charIndex: charIndex + 1 }), delay: CONFIG.typingSpeed };

        if (!isDeleting)
            return { next: merge(state, { isDeleting: true }), delay: CONFIG.pauseAfterType };

        if (isDeleting && charIndex > 0)
            return { next: merge(state, { charIndex: charIndex - 1 }), delay: CONFIG.deletingSpeed };

        return {
            next: merge(state, { isDeleting: false, roleIndex: (roleIndex + 1) % roleCount }),
            delay: CONFIG.pauseBeforeNext,
        };
    }


    function tick(el, roles, state) {
        el.textContent = roles[state.roleIndex].slice(0, state.charIndex);

        var result = nextStep(state, roles[state.roleIndex].length);
        setTimeout(tick.bind(null, el, roles, result.next), result.delay);
    }


    var el = document.getElementById('hero-role');
    if (!el) return;

    var roles = (el.getAttribute('data-roles') || '').split('|').filter(Boolean);
    if (roles.length === 0) return;

    var initialState = { roleIndex: 0, charIndex: 0, isDeleting: false, roleCount: roles.length };

    setTimeout(tick.bind(null, el, roles, initialState), CONFIG.startDelay);

})();



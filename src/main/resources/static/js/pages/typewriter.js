(function () {
    function getNextState(state, textLength) {
        const { roleIndex, charIndex, isDeleting } = state;
        const next = { ...state };
        let delay;

        if (!isDeleting) {
            if (charIndex < textLength) {
                next.charIndex = charIndex + 1;
                delay = TYPEWRITER_CONFIG.typingSpeed;
            } else {
                next.isDeleting = true;
                delay = TYPEWRITER_CONFIG.pauseAfterTyping;
            }
        } else {
            if (charIndex > 0) {
                next.charIndex = charIndex - 1;
                delay = TYPEWRITER_CONFIG.deletingSpeed;
            } else {
                next.isDeleting = false;
                next.roleIndex = (roleIndex + 1) % state.roleCount;
                delay = TYPEWRITER_CONFIG.pauseBeforeNext;
            }
        }

        return { next, delay };
    }

    function runAnimation(element, roles, state) {
        const currentText = roles[state.roleIndex];
        element.textContent = currentText.slice(0, state.charIndex);

        const { next, delay } = getNextState(state, currentText.length);
        setTimeout(() => runAnimation(element, roles, next), delay);
    }

    const element = document.getElementById('hero-role');
    if (!element) return;

    const rolesAttr = element.getAttribute('data-roles');
    if (!rolesAttr) return;

    const roles = rolesAttr.split('|').filter(Boolean);
    if (roles.length === 0) return;

    const initialState = { roleIndex: 0, charIndex: 0, isDeleting: false, roleCount: roles.length };

    setTimeout(() => runAnimation(element, roles, initialState), TYPEWRITER_CONFIG.startDelay);
})();
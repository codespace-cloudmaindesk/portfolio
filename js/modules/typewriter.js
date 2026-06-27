const settings = {
    typingSpeed: 90,
    deletingSpeed: 50,
    pauseAfterTyping: 2000,
    pauseBeforeNext: 400,
    startDelay: 1000
};

function getNextState(state, textLength) {
    const { roleIndex, charIndex, isDeleting } = state;

    let next = { ...state };
    let delay;

    switch (true) {

        case !isDeleting && charIndex < textLength:
            next.charIndex++;
            delay = settings.typingSpeed;
            break;

        case !isDeleting && charIndex === textLength:
            next.isDeleting = true;
            delay = settings.pauseAfterTyping;
            break;

        case isDeleting && charIndex > 0:
            next.charIndex--;
            delay = settings.deletingSpeed;
            break;

        case isDeleting && charIndex === 0:
            next.isDeleting = false;
            next.roleIndex = roleIndex + 1;
            delay = settings.pauseBeforeNext;
            break;
        }

    return { next, delay };
}

function runAnimation(element, roles, state) {
    const currentText = roles[state.roleIndex % roles.length];

    element.textContent = currentText.slice(0, state.charIndex);

    const { next, delay } = getNextState(state, currentText.length);

    setTimeout(() => runAnimation(element, roles, next), delay);
}

export async function typeWriter(id, file) {

    try {
        const response = await fetch(file);
        const roles = await response.json();

        const element = document.getElementById(id);
        if (!element) throw new Error(`Element #${id} not found`);

       const initialState = {
            roleIndex: 0,
            charIndex: 0,
            isDeleting: false
        };
        setTimeout(() => {
            runAnimation(element, roles, initialState);
        }, settings.startDelay);

        return { id, status: "success" };

    } catch (error) {
        console.error(`Failed to load ${file}`, error);
        return { id, status: "failed", error };
    }
}

       
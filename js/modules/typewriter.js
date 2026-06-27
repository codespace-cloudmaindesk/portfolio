export async function typeWriter(id, file) {
    try {
        const response = await fetch(file);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        const roles = await response.json();

        const element = document.getElementById(id);
        if (!element) return { id, status: "skipped" };

        const settings = {
            typingSpeed: 90,
            deletingSpeed: 50,
            pauseAfterTyping: 2000,
            pauseBeforeNext: 400,
            startDelay: 1200,
        };

        let roleIndex = 0;
        let characterIndex = 0;
        let isDeleting = false;

        function animate() {
            const currentRole = roles[roleIndex];
            characterIndex += isDeleting ? -1 : 1;
            element.textContent = currentRole.slice(0, characterIndex);

            let delay = isDeleting ? settings.deletingSpeed : settings.typingSpeed;

            if (!isDeleting && characterIndex === currentRole.length) {
                isDeleting = true;
                delay = settings.pauseAfterTyping;
            } else if (isDeleting && characterIndex === 0) {
                isDeleting = false;
                roleIndex = (roleIndex + 1) % roles.length;
                delay = settings.pauseBeforeNext;
            }

            setTimeout(animate, delay);
        }

        setTimeout(animate, settings.startDelay);
        return { id, status: "success" };

    } catch (error) {
        console.error(`[typewriter] Failed to load "${file}":`, error);
        return { id, status: "failed", error };
    }
}
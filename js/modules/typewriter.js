export async function typeWriter(id, file) {

    try {
        console.log("TypeWriter started");

        const response = await fetch(file);
        const roles = await response.json();

        const element = document.getElementById(id);

        const settings = {
            typingSpeed: 90,
            deletingSpeed: 50,
            pauseAfterTyping: 2000,
            pauseBeforeNext: 400,
            startDelay: 1200
        };

        let roleIndex = 0;
        let characterIndex = 0;
        let isDeleting = false;

        function animate() {

            const currentRole = roles[roleIndex];

            if (isDeleting) {
                characterIndex--;
            } else {
                characterIndex++;
            }

            element.textContent = currentRole.slice(0, characterIndex);

            let delay = isDeleting
                ? settings.deletingSpeed
                : settings.typingSpeed;

            if (!isDeleting && characterIndex === currentRole.length) {
                isDeleting = true;
                delay = settings.pauseAfterTyping;
            }

            else if (isDeleting && characterIndex === 0) {
                isDeleting = false;
                roleIndex = (roleIndex + 1) % roles.length;
                delay = settings.pauseBeforeNext;
            }
            setTimeout(animate, delay);
        }
        setTimeout(() => {
            animate();
        }, settings.startDelay);

        return { id, status: "success" };

    } catch (error) {
        console.error(`Failed to load ${file}`, error);
        return { id, status: "failed", error };
    }
}
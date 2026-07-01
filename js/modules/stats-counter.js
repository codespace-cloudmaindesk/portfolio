const ANIMATION_DURATION_MS = 1500;
const ANIMATION_STEPS = 30;

export function animateKPIs() {
    const stepTime = ANIMATION_DURATION_MS / ANIMATION_STEPS;

    document.querySelectorAll(".kpi-value").forEach(kpi => {
        const target = Number(kpi.dataset.target);
        const suffix = kpi.dataset.suffix ?? "";
        const increment = target / ANIMATION_STEPS;
        let current = 0;

        const timer = setInterval(() => {
            current += increment;
            const reachedTarget = current >= target;

            kpi.textContent = (reachedTarget ? target : Math.floor(current)) + suffix;
            if (reachedTarget) clearInterval(timer);
        }, stepTime);
    });
}

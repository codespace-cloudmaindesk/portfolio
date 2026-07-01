import { loadComponent } from "./modules/component-loader.js";
import { initMobileNav } from "./modules/nav-toggle.js";
import { animateKPIs } from "./modules/stats-counter.js";
import { typeWriter } from "./modules/typewriter-animation.js";
import { loadAbout } from "./modules/about-content-loader.js";

const COMPONENTS = [
    { id: "navigation-placeholder", file: "components/navigation.html" },
    { id: "hero-placeholder", file: "components/hero.html" },
    { id: "about-placeholder", file: "about.html" },
    { id: "about-kpi-container", file: "components/metrics.html", onLoad: animateKPIs },
];

async function loadComponents() {
    const results = [];

    for (const { id, file, onLoad } of COMPONENTS) {
        const result = await loadComponent(id, file);
        if (result.status === "success") onLoad?.();
        results.push(result);
    }

    return results;
}

async function initFeatures() {
    const tasks = [];

    if (document.getElementById("hero-typed-role")) {
        tasks.push(typeWriter("hero-typed-role", "assets/data/roles.json"));
    }

    const isAboutPage =
        document.getElementById("about-heading") &&
        document.getElementById("about-biography") &&
        document.getElementById("about-skills-section");

    if (isAboutPage) {
        tasks.push(
            loadAbout(
                "about-heading",
                "about-biography",  
                "about-skills-section", 
                "assets/data/about.json"
            )
        );
    }

    return Promise.allSettled(tasks);
}

async function bootstrapApp() {
    const componentResults = await loadComponents();
    initMobileNav();
    const featureResults = await initFeatures();
    console.log("[APP INIT]", { componentResults, featureResults });
}

document.addEventListener("DOMContentLoaded", bootstrapApp);
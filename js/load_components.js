import { typeWriter } from "./modules/typewriter.js";
import { loadAbout } from "./modules/about.js";

async function loadComponent(id, file) {
    try {
        const response = await fetch(file);
        const html = await response.text();

        const el = document.getElementById(id)
        if (!el) throw new Error(`Element #${id} not found`);
        el.innerHTML = html;

        return { id, status: "success" };

    } catch (error) {
        console.error(`Failed to load ${file}`, error);
        return { id, status: "failed", error };
    }
}

 async function initFeatures() {
    return Promise.allSettled([
        typeWriter("typed-role", "assets/data/roles.json"),
        loadAbout("about-title", "about-content", "about-skills", "assets/data/about.json")
    ]);
}

async function bootstrapApp() {
    try {
        await loadComponent("navbar", "components/navigation.html");

        const results = await initFeatures();
        console.log("[APP INIT]", results);

    } catch (error) {
        console.error("[BOOTSTRAP FAILED]", error);
    }
}

document.addEventListener("DOMContentLoaded", bootstrapApp);
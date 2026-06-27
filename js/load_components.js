import { loadComponent } from "./modules/loader.js";
import { setActiveNav } from "./modules/nav.js";
import { typeWriter } from "./modules/typewriter.js";
import { loadAbout } from "./modules/about.js";


const PAGE_TASKS = {
    "index.html": () => [ typeWriter("typed-role", "assets/data/roles.json"),],
    "about.html": () => [ loadAbout("about-title", "about-content", "assets/data/about.json"),],
};

document.addEventListener("DOMContentLoaded", async () => {
    await loadComponent("navbar", "components/navigation.html");
    setActiveNav();

    const page = location.pathname.split("/").pop() || "index.html";
    const tasks = PAGE_TASKS[page];

    if (tasks) {
        const results = await Promise.allSettled(tasks());
        results
            .filter(r => r.status === "rejected")
            .forEach(r => console.error("[page init] Task failed:", r.reason));
    }
});
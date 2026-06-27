import { typeWriter } from "./modules/typewriter.js";
import { loadAbout } from "./modules/about.js";

document.addEventListener("DOMContentLoaded", async () => {

    async function loadComponent(id, file) {
        try {
            const response = await fetch(file);
            const html = await response.text();
            document.getElementById(id).innerHTML = html;
            return { id, status: "success" };
        } catch (error) {
            console.error(`Failed to load ${file}`, error);
            return { id, status: "failed", error };
        }
    }
    await loadComponent("navbar", "components/navigation.html");
    
    const results = await Promise.allSettled([
        typeWriter("typed-role", "assets/data/roles.json"),
        loadAbout("about-title", "about-content", "assets/data/about.json")
    ]);
    console.log(results);
});
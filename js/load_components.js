import { typeWriter } from "./modules/typewriter.js";

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

    const results = await Promise.allSettled([
        loadComponent("navbar", "components/navigation.html"),
        typeWriter("typed-role", "assets/data/roles.json")
    ]);
    console.log(results);
});
document.addEventListener("DOMContentLoaded", async () => {

    async function loadComponent(id, file) {
        const response = await fetch(file);
        const html = await response.text();
        document.getElementById(id).innerHTML = html;
    }

    await loadComponent("navbar", "components/navigation.html");
    await loadComponent("footer", "components/footer.html");

});
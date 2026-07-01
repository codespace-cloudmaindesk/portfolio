export async function loadComponent(id, file) {
    const el = document.getElementById(id);
    if (!el) return { id, status: "skipped" };

    try {
        const response = await fetch(file);
        if (!response.ok) {
            throw new Error(`HTTP ${response.status} — ${file}`);
        }

        el.innerHTML = await response.text();
        return { id, status: "success" };

    } catch (error) {
        console.error(`Failed to load ${file}`, error);
        return { id, status: "failed", error };
    }
}

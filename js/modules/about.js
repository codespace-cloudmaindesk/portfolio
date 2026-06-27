export async function loadAbout(titleId, contentId, file) {
    const titleEl = document.getElementById(titleId);
    const container = document.getElementById(contentId);
    if (!titleEl || !container) return { titleId, status: "skipped" }; // ← guard

    try {
        const response = await fetch(file);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        const data = await response.json();

        titleEl.textContent = data.title;
        container.innerHTML = data.content
            .map(text => `<p>${text}</p>`)
            .join("");

        return { titleId, status: "success" };
    } catch (error) {
        console.error(`[about] Failed to load "${file}":`, error);
        return { titleId, status: "failed", error };
    }
}
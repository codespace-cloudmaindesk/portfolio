function renderContent(container, content) {
    container.innerHTML = "";

    content.forEach(item => {
        let element;

        switch (item.type ?? "text") {
            case "heading":
                element = document.createElement("h3");
                element.textContent = item.value;
                break;

            case "list":
                element = document.createElement("li");
                element.textContent = item.value;
                break;

            case "text":
            default:
                element = document.createElement("p");
                element.textContent = item.value ?? item;
                break;
        }

        container.appendChild(element);
    });
}

export async function loadAbout(titleId, contentId, file) {
    try {
        const response = await fetch(file);
        const data = await response.json();

        const titleEl = document.getElementById(titleId);
        const contentEl = document.getElementById(contentId);

        if (!titleEl || !contentEl) { throw new Error("Target elements not found");}

        titleEl.textContent = data.title;

        renderContent(contentEl, data.content);

        return { titleId, status: "success" };

    } catch (error) {
        console.error(`Failed to load ${file}`, error);

        return { titleId, status: "failed", error};
    }
}
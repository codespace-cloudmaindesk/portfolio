export async function loadAbout(titleId, contentId, file) {

    try {

        const response = await fetch(file);
        const data = await response.json();

        document.getElementById(titleId).textContent = data.title;
        const container = document.getElementById(contentId);

        container.innerHTML = "";

        data.content.forEach(text => {
            const paragraph = document.createElement("p");
            paragraph.textContent = text;
            container.appendChild(paragraph);
        });
        return { titleId, status: "success" };
    } catch (error) {
        console.error(`Failed to load ${file}`, error);
        return { titleId, status: "failed", error
        };
    }
}
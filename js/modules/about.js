function renderContent(container, content) {
    container.innerHTML = "";

    content.forEach(item => {
        const type  = item.type ?? "text";
        const value = item.value ?? item;

        switch (type) {
            case "heading":{
                const h1 = document.createElement("h1");
                h1.textContent = value;
                break;
            }
            case "list":{
                let ul = container.lastElementChild;
                if (ul?.tagName !== "UL") {
                    ul = document.createElement("ul");
                    container.appendChild(ul);
                }
                const li = document.createElement("li");
                li.textContent = value;
                ul.appendChild(li);
                break;
            }
            case "text":{
                const p = document.createElement("p");
                p.textContent = value;
                container.appendChild(p);
                break;
            }
            default: {}
        }
    });
}

function renderSkills(skillsId) {
    const skillsEl = document.getElementById(skillsId);
    if (!skillsEl) return;
 
    requestAnimationFrame(() => {
        requestAnimationFrame(() => {
            skillsEl.querySelectorAll(".skill-fill").forEach(bar => {
                bar.style.width = bar.dataset.level + "%";
            });
        });
    });
}

export async function loadAbout(titleId, contentId, skillsId, file) {
    const titleEl   = document.getElementById(titleId);
    const contentEl = document.getElementById(contentId);
    if (!titleEl || !contentEl) {
        console.error(`[about] Elements #${titleId} or #${contentId} not found`);
        return { titleId, status: "skipped" };
    }
 
    try {
        const response = await fetch(file);
        if (!response.ok) throw new Error(`HTTP ${response.status} — ${file}`);
        const data = await response.json();
 
        titleEl.textContent = data.title;
        renderContent(contentEl, data.content);
        renderSkills(skillsId);
 
        return { titleId, status: "success" };
 
    } catch (error) {
        console.error(`[about] Failed to load "${file}":`, error);
        return { titleId, status: "failed", error };
    }
}
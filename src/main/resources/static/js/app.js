window.__appInits = window.__appInits || [];

function callFn(fn) { fn(); }

function bootAll() {
    window.__appInits.forEach(callFn);
}

document.addEventListener('DOMContentLoaded', bootAll);
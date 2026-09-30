(function () {
  'use strict';

  /* ── Configuration ── */
  var CONFIG = {
    containerId: 'skills-list',
    duration:    1400,
    threshold:   0.2
  };

  var reduceMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

  /* ── Easing: fast start, slow finish ── */
  function easeOutExpo(t) {
    return t === 1 ? 1 : 1 - Math.pow(2, -10 * t);
  }

  /* ── Animate a single skill item ──
     Drives fill width, percentage text, AND percentage position
     in the same rAF loop so everything stays in perfect sync. */
  function animateSkillItem(li) {
    var fill = li.querySelector('.skill-progress-fill');
    var pct  = li.querySelector('.skill-pct');

    if (!fill) return;

    var targetWidth = parseInt(fill.getAttribute('data-width'), 10) || 0;
    var targetCount = pct
      ? (parseInt(pct.getAttribute('data-target'), 10) || targetWidth)
      : targetWidth;

    /* Disable CSS transition — JS drives width each frame instead */
    fill.style.transition = 'none';
    fill.style.width = '0%';

    if (pct) {
      pct.textContent = '0%';
      pct.style.left  = '0%';
    }

    /* Reduced motion: jump straight to final values */
    if (reduceMotion) {
      fill.style.width = targetWidth + '%';
      if (pct) {
        pct.textContent = targetCount + '%';
        pct.style.left  = targetWidth + '%';
      }
      return;
    }

    var start    = performance.now();
    var duration = CONFIG.duration;

    function tick(now) {
      var progress = Math.min((now - start) / duration, 1);
      var eased    = easeOutExpo(progress);
      var currentWidth = eased * targetWidth;

      fill.style.width = currentWidth + '%';

      if (pct) {
        pct.textContent = Math.round(eased * targetCount) + '%';
        pct.style.left  = currentWidth + '%';
      }

      if (progress < 1) {
        requestAnimationFrame(tick);
      }
    }

    requestAnimationFrame(tick);
  }

  /* ── Animate every <li> inside the skills container ── */
  function animateAll(container) {
    var items = container.querySelectorAll('li');
    items.forEach(animateSkillItem);
  }

  /* ── Entry point ── */
  function init() {
    var container = document.getElementById(CONFIG.containerId);
    if (!container) return;

    /* Reduced motion or no observer support: animate immediately */
    if (reduceMotion || !('IntersectionObserver' in window)) {
      animateAll(container);
      return;
    }

    var observer = new IntersectionObserver(
      function (entries, obs) {
        entries.forEach(function (entry) {
          if (!entry.isIntersecting) return;
          animateAll(container);
          obs.unobserve(entry.target);
        });
      },
      { threshold: CONFIG.threshold }
    );

    observer.observe(container);
  }

  init();

})();

/* home.js — Metric counter animation */

(function () {
  'use strict';

  /* ── Utility: easeOutExpo for a decelerating feel ──────── */
  function easeOutExpo(t) {
    return t === 1 ? 1 : 1 - Math.pow(2, -10 * t);
  }

  /* ── Utility: count-up animation using rAF ─────────────── */
  function countUp(el, target, duration) {
    if (target === 0) {
      el.textContent = '0';
      return;
    }

    var start = performance.now();

    function tick(now) {
      var elapsed = now - start;
      var progress = Math.min(elapsed / duration, 1);
      var easedProgress = easeOutExpo(progress);
      var current = Math.round(easedProgress * target);

      el.textContent = current;

      if (progress < 1) {
        requestAnimationFrame(tick);
      } else {
        el.textContent = target;
      }
    }

    requestAnimationFrame(tick);
  }

  /* ── IntersectionObserver for home metrics ────────────────── */
  var metricsObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        var countEls = entry.target.querySelectorAll('.js-count');
        countEls.forEach(function (el) {
          var target = parseInt(el.getAttribute('data-target'), 10) || 0;
          countUp(el, target, 1400);
        });
        metricsObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.2 });

  var metricsSection = document.querySelector('.home-metrics');
  if (metricsSection) {
    metricsObserver.observe(metricsSection);
  }

  /* ── Also observe .kpi-grid for the standalone metrics page ─ */
  var kpiGrid = document.querySelector('.kpi-grid');
  if (kpiGrid) {
    metricsObserver.observe(kpiGrid);
  }
})();

/* home.js — Metric counter animation */

(function () {
  'use strict';

  /* ── Utility: count-up animation ─────────────────────────── */
  function countUp(el, target, duration) {
    var step = (target / duration) * 16;
    var current = 0;
    var timer = setInterval(function () {
      current += step;
      if (current >= target) {
        current = target;
        clearInterval(timer);
      }
      el.textContent = Math.round(current);
    }, 16);
  }

  /* ── IntersectionObserver for home metrics ────────────────── */
  var metricsObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        entry.target.querySelectorAll('.js-count').forEach(function (el) {
          var target = parseInt(el.getAttribute('data-target'), 10) || 0;
          countUp(el, target, 1200);
        });
        metricsObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.3 });

  var metricsSection = document.querySelector('.home-metrics');
  if (metricsSection) metricsObserver.observe(metricsSection);

})();


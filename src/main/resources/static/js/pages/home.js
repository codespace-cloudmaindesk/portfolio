/* home.js — KPI counter animation + skill bar animation */

(function () {
  'use strict';

  /* ── Utility: count-up animation ─────────────────────────── */
  function countUp(el, target, suffix, duration) {
    var start = 0;
    var step = (target / duration) * 16;
    var current = 0;
    var timer = setInterval(function () {
      current += step;
      if (current >= target) {
        current = target;
        clearInterval(timer);
      }
      el.textContent = Math.round(current) + suffix;
    }, 16);
  }

  /* ── Utility: animate skill progress fills ────────────────── */
  function animateSkills() {
    document.querySelectorAll('.skill-progress-fill').forEach(function (fill) {
      var width = fill.getAttribute('data-width') || '0%';
      fill.style.width = width;
    });
  }

  /* ── IntersectionObserver for KPI strip ──────────────────── */
  var kpiObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        entry.target.querySelectorAll('.kpi-number').forEach(function (el) {
          var target = parseInt(el.getAttribute('data-target'), 10) || 0;
          var suffix = el.getAttribute('data-suffix') || '';
          countUp(el, target, suffix, 1200);
        });
        kpiObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.3 });

  var kpiStrip = document.querySelector('.kpi-strip');
  if (kpiStrip) kpiObserver.observe(kpiStrip);

  /* ── IntersectionObserver for skill bars ─────────────────── */
  var skillObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        animateSkills();
        skillObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.2 });

  var skillsList = document.getElementById('skills-list');
  if (skillsList) skillObserver.observe(skillsList);

})();

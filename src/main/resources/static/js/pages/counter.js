(function () {
  'use strict';

  /* ── Configuration ── */
  var CONFIG = {
    selector:  '.js-count',
    duration:  1400,
    threshold: 0.2
  };

  var reduceMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

  /* ── Easing: fast start, slow finish ── */
  function easeOutExpo(t) {
    return t === 1 ? 1 : 1 - Math.pow(2, -10 * t);
  }

  /* ── Animation: counts one element from 0 to its target ── */
  function countUp(el, target, duration) {
    var start = performance.now();

    function tick(now) {
      var progress = Math.min((now - start) / duration, 1);
      el.textContent = Math.round(easeOutExpo(progress) * target);

      if (progress < 1) {
        requestAnimationFrame(tick);
      }
    }

    requestAnimationFrame(tick);
  }

  /* ── Reads the target value from the markup ── */
  function getTarget(el) {
    return parseInt(el.getAttribute('data-target'), 10) || 0;
  }

  /* ── Observer callback: start each counter when it becomes visible ── */
  function onIntersect(entries, observer) {
    entries.forEach(function (entry) {
      if (!entry.isIntersecting) return;

      countUp(entry.target, getTarget(entry.target), CONFIG.duration);
      observer.unobserve(entry.target);
    });
  }

  /* ── Setup: only runs when animating is appropriate ── */
  function init() {

    var counters = document.querySelectorAll(CONFIG.selector);
    if (counters.length === 0) return

    if (reduceMotion || !('IntersectionObserver' in window)) {
      counters.forEach(function (el) {
        el.textContent = getTarget(el);
      });
      return;
    }
    var observer = new IntersectionObserver(onIntersect, { threshold: CONFIG.threshold });

    counters.forEach(function (el) {
      el.textContent = '0';
      observer.observe(el);
    });
  }

  init();

})();
// Add JavaScript functionality here if needed

// Example: Scroll to top of page on load
window.onload = function() {
    window.scrollTo(0, 0);
};

// Example: Smooth scroll to sections (if needed)
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});

const scenarios = {
    bleeding: {
        title: "Bleeding (ರಕ್ತಸ್ರಾವ)",
        steps: [
            "Apply direct pressure to the wound with a clean cloth.",
            "Elevate the injured part above heart level if possible.",
            "If bleeding doesn't stop, apply a firmer bandage.",
            "Seek medical help immediately."
        ]
    },
    heart_attack: {
        title: "Heart Attack (ಹೃದಯಾಘಾತ)",
        steps: [
            "Make the person sit down and stay calm.",
            "Loosen any tight clothing.",
            "Ask if they take chest pain medication.",
            "Call emergency services (108) immediately."
        ]
    },
    snake_bite: {
        title: "Snake Bite (ಹಾವು ಕಡಿತ)",
        steps: [
            "Keep the person calm and still.",
            "Remove any jewelry or tight clothing.",
            "Keep the bitten area below heart level.",
            "Do NOT cut the wound or try to suck out venom."
        ]
    }
};

window.showScenario = function(id) {
    const scenario = scenarios[id] || scenarios.bleeding;
    const screen = document.getElementById('demo-screen');
    
    let stepsHtml = scenario.steps.map((step, index) => `
        <div style="margin-bottom: 1rem; padding: 0.8rem; background: white; border-radius: 8px; border-left: 4px solid #10b981; font-size: 0.9rem;">
            <strong>Step ${index + 1}:</strong><br>${step}
        </div>
    `).join('');

    screen.innerHTML = `
        <div class="mockup-header" style="display:flex; align-items:center; justify-content: space-between; padding: 0.5rem 1rem;">
            <button onclick="resetDemo()" style="background:none; border:none; color:white; font-size:1.2rem; cursor:pointer;">←</button>
            <span style="font-size:0.9rem">${scenario.title}</span>
            <div style="width:20px"></div>
        </div>
        <div style="padding: 1rem; animation: fadeIn 0.3s ease-out;">
            ${stepsHtml}
            <button onclick="resetDemo()" class="btn btn-primary" style="width:100%; margin-top: 1rem; font-size: 0.8rem;">Finish Demo</button>
        </div>
    `;
};

window.resetDemo = function() {
    const screen = document.getElementById('demo-screen');
    screen.innerHTML = `
        <div class="mockup-header">Pratham-Chikitse</div>
        <div class="demo-list" style="padding: 1rem; animation: fadeIn 0.3s ease-out;">
            <div class="mockup-tile" onclick="showScenario('bleeding')"><span>🩹</span> Bleeding</div>
            <div class="mockup-tile" onclick="showScenario('heart_attack')"><span>🫀</span> Heart Attack</div>
            <div class="mockup-tile" onclick="showScenario('snake_bite')"><span>🐍</span> Snake Bite</div>
            <div class="mockup-tile" onclick="showScenario('burns')"><span>🔥</span> Burns</div>
            <div class="mockup-tile" onclick="showScenario('electric_shock')"><span>⚡</span> Electric Shock</div>
            <p style="text-align:center; font-size: 0.8rem; margin-top: 1rem; color: #64748b;">(Click a scenario to start demo)</p>
        </div>
    `;
};

// Scroll Reveal
const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = "1";
            entry.target.style.transform = "translateY(0)";
        }
    });
}, { threshold: 0.1 });

document.querySelectorAll('.card').forEach(card => {
    card.style.opacity = "0";
    card.style.transform = "translateY(20px)";
    card.style.transition = "all 0.6s ease-out";
    observer.observe(card);
});

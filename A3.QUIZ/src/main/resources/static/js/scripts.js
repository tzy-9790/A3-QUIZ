function abrirModalLogin() {
    document.getElementById('login-modal-overlay').classList.remove('esconder');
    document.getElementById('modal-username').classList.remove('esconder');
    document.getElementById('modal-password').classList.add('esconder');
    document.getElementById('input-username').value = ""; // Limpa o campo
    document.getElementById('input-password').value = "";
}

function fecharModalLogin() {
    document.getElementById('login-modal-overlay').classList.add('esconder');
}

function verificarUsername() {
    const inputUser = document.getElementById('input-username').value.trim();

    if (inputUser === "") {
        const numAleatorio = Math.floor(1000 + Math.random() * 9000);
        const userSorteado = "Agente_" + numAleatorio;

        sessionStorage.setItem("jogadorAtual", userSorteado);

        window.location.href = "/modos"; 
    } else {
        document.getElementById('display-agent-name').innerText = inputUser;
        document.getElementById('modal-username').classList.add('esconder');
        document.getElementById('modal-password').classList.remove('esconder');
    }
}
function fazerLogin() {
    const inputUser = document.getElementById('input-username').value.trim();
    const inputPass = document.getElementById('input-password').value.trim();

    if (inputPass === "") {
        alert("Sistemas de segurança exigem uma senha.");
        return;
    }

    sessionStorage.setItem("jogadorAtual", inputUser);
    window.location.href = "/modos";
}
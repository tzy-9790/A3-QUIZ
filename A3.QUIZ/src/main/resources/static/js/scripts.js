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
async function fazerLogin() {
    const inputUser = document.getElementById('input-username').value.trim();
    const inputPass = document.getElementById('input-password').value.trim();

    if (inputPass === "") {
        alert("Sistemas de segurança exigem uma senha.");
        return;
    }

    // NOVA LÓGICA: Em vez de entrar direto, pergunta ao Java (Spring Boot)
    try {
        const response = await fetch('/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 
                username: inputUser, 
                password: inputPass 
            })
        });

        if (response.ok) {
            // Se o Java retornou OK (200), a senha está certa ou a conta foi criada
            sessionStorage.setItem("jogadorAtual", inputUser);
            window.location.href = "/modos";
        } else {
            // Se o Java retornou erro (ex: 401 Unauthorized), a senha está errada
            alert("ACESSO NEGADO: Senha incorreta para o agente " + inputUser);
            // Opcional: Limpar o campo de senha para ele tentar de novo
            document.getElementById('input-password').value = "";
        }
    } catch (error) {
        console.error("Erro ao conectar ao sistema de segurança:", error);
        alert("Erro de conexão com o servidor central.");
    }
}
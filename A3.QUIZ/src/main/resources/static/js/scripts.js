function abrirModalLogin() {
    document.getElementById('login-modal-overlay').classList.remove('esconder');
    document.getElementById('modal-username').classList.remove('esconder');
    document.getElementById('modal-password').classList.add('esconder');
    document.getElementById('input-username').value = "";
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
        sessionStorage.setItem("jogadorAtual", inputUser); 
        
        document.getElementById('display-agent-name').innerText = inputUser;
        document.getElementById('modal-username').classList.add('esconder');
        document.getElementById('modal-password').classList.remove('esconder');
        
        document.getElementById('login-error-msg').style.display = 'none';
        document.getElementById('input-password').value = ""; 
    }
}

async function fazerLogin() {
    const window_password = document.getElementById('input-password');
    const senha = window_password.value.trim();
    const btn = document.querySelector('#modal-password .btn-jogar-modal');
    const erroCaixa = document.getElementById('login-error-msg');
    const jogadorAtual = sessionStorage.getItem("jogadorAtual"); 

    erroCaixa.style.display = 'none';

    if (!senha) {
        erroCaixa.innerHTML = "Acesso negado: A senha é obrigatória.";
        erroCaixa.style.display = 'block';
        return;
    }

    const textoOriginal = btn.innerText;
    btn.innerText = "AUTENTICANDO..."; 
    btn.disabled = true; 
    btn.style.opacity = "0.7";

    try {
        const payloadJSON = JSON.stringify({ 
            username: jogadorAtual, 
            password: senha 
        });

        const resposta = await fetch('/api/users/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: payloadJSON
        });

        if (resposta.ok) {
            window.location.href = "/modos";
        } 
        else if (resposta.status === 404 || resposta.status === 409) {
            const respostaRegistro = await fetch('/api/users/registrar', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: payloadJSON
            });

            if (respostaRegistro.ok) {
                window.location.href = "/modos";
            } else {
                erroCaixa.innerHTML = "Erro: Não foi possível registar o novo USER. Tente novamente mais tarde.";
                erroCaixa.style.display = 'block';
                btn.innerText = textoOriginal;
                btn.disabled = false;
                btn.style.opacity = "1";
            }
        } 
        else {
            erroCaixa.innerHTML = "Senha incorreta. Tente novamente.";
            erroCaixa.style.display = 'block';
            
            btn.innerText = textoOriginal;
            btn.disabled = false;
            btn.style.opacity = "1";
            window_password.value = "";
        }
    } catch (error) {
        erroCaixa.innerHTML = "Erro: Estamos enfrentando dificuldades técnicas. Tente novamente mais tarde.";
        erroCaixa.style.display = 'block';
        
        btn.innerText = textoOriginal;
        btn.disabled = false;
        btn.style.opacity = "1";
    }
}
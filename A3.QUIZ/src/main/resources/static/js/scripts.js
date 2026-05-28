function mudarTela(idDaNovaTela) {
    // 1. Lista todas as seções que representam telas
    const telas = ['tela-home', 'tela-modos', 'tela-jogo'];

    // 2. Esconde todas elas
    telas.forEach(tela => {
        document.getElementById(tela).style.display = 'none';
    });

    // 3. Mostra apenas a tela desejada
    document.getElementById(idDaNovaTela).style.display = 'block';
}
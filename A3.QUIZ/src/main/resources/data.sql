INSERT INTO questoes (modo, instrucao, midia_esquerda, midia_direita, lado_ia, mensagem_correto, mensagem_errado)
VALUES ('image', 'SELECIONE A IMAGEM FEITA POR IA', '/imagens/quiz/imagem1-ia.jpg', '/imagens/quiz/imagem1-real.jpg', 'left', 'CORRETO: Esta imagem apresenta inconsistência em texturas superficiais e padrões de ruído gerados por redes neurais.', 'ERRADO: Esse registro fotográfico possui granulação óptica analógica e metadados legítimos.');

INSERT INTO questoes (modo, instrucao, midia_esquerda, midia_direita, lado_ia, mensagem_correto, mensagem_errado)
VALUES ('video', 'SELECIONE O VÍDEO GERADO POR IA', '/imagens/quiz/video1-real.mp4', '/imagens/quiz/video1-ia.mp4', 'right', 'CORRETO: Identificados artefatos espaciais e falhas de interpolação profunda características de Deepfake.', 'ERRADO: O sensor óptico capturou a variação biológica e a iluminação natural perfeitamente.');

INSERT INTO questoes (modo, instrucao, midia_esquerda, midia_direita, lado_ia, mensagem_correto, mensagem_errado)
VALUES ('audio', 'SELECIONE O ÁUDIO SINTETIZADO POR IA', '/imagens/quiz/audio1-ia.mp4', '/imagens/quiz/audio1-real.mp4', 'left', 'CORRETO: A frequência acústica exibe compressão metálica e ausência de respiração típica de clonagem de voz neural.', 'ERRADO: Espectro vocal limpo, apresentando ruído de fundo analógico e ressonância humana autêntica.');
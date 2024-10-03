-- CRIAÇÃO E UTILIZAÇÃO
create database bdlocadora;
use bdlocadora;

-- TABELA TIPO_PAGAMENTO
CREATE TABLE TIPO_PAGAMENTO (
    idTipo_Pagamento INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

-- TABELA CLIENTE
CREATE TABLE CLIENTE (
    idCliente INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    rua VARCHAR(45),
    complemento VARCHAR(45),
    bairro VARCHAR(45),
    cep VARCHAR(9),
    cidade VARCHAR(45),
    uf VARCHAR(2),
    telefone VARCHAR(16)
);

-- TABELA DEPENDENTE
CREATE TABLE DEPENDENTE (
    idDependente INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    idCliente INT NOT NULL,
    CONSTRAINT DEPENDENTE_idCliente_fk FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

-- TABELA CATEGORIA
CREATE TABLE CATEGORIA (
    idCategoria INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

-- TABELA CLASSIFICACAO
CREATE TABLE CLASSIFICACAO (
    idClassificacao INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    prazoDevolucao INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL
);

-- TABELA MÍDIA
CREATE TABLE MIDIA (
    idMidia INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    valorMidia DECIMAL(10,2) NOT NULL
);

-- TABELA STATUS
CREATE TABLE STATUS (
    idStatus INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

-- TABELA FILME
CREATE TABLE FILME (
    idFilme INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    sinopse VARCHAR(45),
    duracao INT,
    idClassificacao INT NOT NULL,
    idCategoria INT NOT NULL,
    CONSTRAINT FILME_idClassificacao_fk FOREIGN KEY (idClassificacao) REFERENCES CLASSIFICACAO(idClassificacao),
    CONSTRAINT FILME_idCategoria_fk FOREIGN KEY (idCategoria) REFERENCES CATEGORIA(idCategoria)
);

-- TABELA EXEMPLAR
CREATE TABLE EXEMPLAR (
    idExemplar INT PRIMARY KEY,
    idFilme INT NOT NULL,
    idMidia INT NOT NULL,
    idStatus INT NOT NULL,
    CONSTRAINT EXEMPLAR_idFilme_fk FOREIGN KEY (idFilme) REFERENCES FILME(idFilme),
    CONSTRAINT EXEMPLAR_idMidia_fk FOREIGN KEY (idMidia) REFERENCES MIDIA(idMidia),
    CONSTRAINT EXEMPLAR_idStatus_fk FOREIGN KEY (idStatus) REFERENCES STATUS(idStatus)
);

-- TABELA LOCACAO
CREATE TABLE LOCACAO (
    idLocacao INT PRIMARY KEY,
    dataLocacao DATE NOT NULL,
    valorTotal DECIMAL(10,2),
    idCliente INT NOT NULL,
    idTipo_Pagamento INT NOT NULL,
    idDependente INT,
    CONSTRAINT LOCACAO_idCliente_fk FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente),
    CONSTRAINT LOCACAO_idTipoPagamento_fk FOREIGN KEY (idTipo_Pagamento) REFERENCES TIPO_PAGAMENTO(idTipo_Pagamento), 
    CONSTRAINT LOCACAO_idDependente_fk FOREIGN KEY (idDependente) REFERENCES DEPENDENTE(idDependente)
);

-- TABELA MULTA
CREATE TABLE MULTA (
    idMulta INT PRIMARY KEY,
    dataMulta DATE NOT NULL,
    valorMulta DECIMAL(10,2),
    qtdDiasAtraso INT,
    valorTotalMulta DECIMAL(10,2),
    idDevolucao INT NOT NULL,
    CONSTRAINT MULTA_idDevolucao_fk FOREIGN KEY (idDevolucao) REFERENCES DEVOLUCAO(idDevolucao)
);

-- TABELA RESERVA
CREATE TABLE RESERVA (
    idReserva INT PRIMARY KEY,
    idExemplar INT NOT NULL,
    dataReserva DATE NOT NULL,
    idCliente INT NOT NULL,
    CONSTRAINT RESERVA_idExemplar_fk FOREIGN KEY (idExemplar) REFERENCES EXEMPLAR(idExemplar),
    CONSTRAINT RESERVA_idCliente_fk FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

-- TABELA RETIRADA
CREATE TABLE RETIRADA (
    idRetirada INT PRIMARY KEY,
    idLocacao INT NOT NULL,
    idExemplar INT NOT NULL,
    valorUnitario DECIMAL(10,2),
    dataDevolucaoPrevista DATE,
    CONSTRAINT RETIRADA_idLocacao_fk FOREIGN KEY (idLocacao) REFERENCES LOCACAO(idLocacao),
    CONSTRAINT RETIRADA_idExemplar_fk FOREIGN KEY (idExemplar) REFERENCES EXEMPLAR(idExemplar)
);

-- TABELA DEVOLUÇÃO
CREATE TABLE DEVOLUCAO (
    idDevolucao INT PRIMARY KEY,
    dataDevolucao DATE,
    idRetirada INT NOT NULL,
    CONSTRAINT DEVOLUCAO_idRetirada_fk FOREIGN KEY (idRetirada) REFERENCES RETIRADA(idRetirada)
);

-- TABELA ATOR
CREATE TABLE ATOR (
    idAtor INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

-- RELACIONAMENTO FILME/ATOR
CREATE TABLE FILME_HAS_ATOR (
    idFilme INT NOT NULL,
    idAtor INT NOT NULL,
    CONSTRAINT FILME_HAS_ATOR_idFilme_fk FOREIGN KEY (idFilme) REFERENCES FILME(idFilme),
    CONSTRAINT FILME_HAS_ATOR_idAtor_fk FOREIGN KEY (idAtor) REFERENCES ATOR(idAtor)
);
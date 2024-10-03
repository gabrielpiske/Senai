-- CRIAÇÃO E UTILIZAÇÃO
create database bdlojacds;
use bdlojacds;

-- TABELA CATEGORIA
CREATE TABLE Categoria(
	idCategoria INT PRIMARY KEY,
    nome VARCHAR(45)       
);

-- TABELA GÊNERO
CREATE TABLE Genero(
	idGenero INT PRIMARY KEY,
    nome VARCHAR(45)
);

-- TABELA GRAVADORA
CREATE TABLE Gravadora(
	idGravadora INT PRIMARY KEY,
    nome VARCHAR(45),
    endereco VARCHAR(150)
);
-- TABELA ARTISTA
CREATE TABLE Artista(
	idArtista INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    dataNascimento DATE NOT NULL,
    idGenero INT NOT NULL,
    idArtistaInpiracao INT,
    idGravadora INT NOT NULL,
    CONSTRAINT Artista_idGenero_fk FOREIGN KEY (idGenero) REFERENCES genero(idGenero),
    CONSTRAINT Artista_ArtistaInpiracao_fk FOREIGN KEY (idArtistaInpiracao) REFERENCES artista(idArtista),
    CONSTRAINT Artista_idGravadora_fk FOREIGN KEY (idGravadora) REFERENCES gravadora(idGravadora)
);

-- TABELA CD
CREATE TABLE CD(
	idCD INT PRIMARY KEY,
    titulo VARCHAR(45) NOT NULL,
    idCategoria INT,
    idArtista INT,
    quantidade INT,
    CONSTRAINT CD_idArtista_fk FOREIGN KEY (idArtista) REFERENCES artista(idArtista),
    CONSTRAINT CD_idCategoria_fk FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria)
);

-- TABELA MUSICA
CREATE TABLE Musica(
	idMusica INT PRIMARY KEY,
    titulo VARCHAR(45),
    idCD INT,
    faixa INT NOT NULL,
    idGenero INT NOT NULL,
    CONSTRAINT musica_idCD_fk FOREIGN KEY (idCD) REFERENCES CD(idCD),
    CONSTRAINT musica_idGenero_fk FOREIGN KEY (idGenero) REFERENCES genero(idGenero)
);

-- TABELA AUTOR
CREATE TABLE Autor(
	idAutor INT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(14) NOT NULL
);

-- RELACIONAMENTO MUSICA/AUTOR
CREATE TABLE Musica_has_Autor(
	idMusica INT,
    idAutor INT,
    CONSTRAINT musica_has_autor_idMusica_fk FOREIGN KEY (idMusica) REFERENCES musica(idMusica),
    CONSTRAINT musica_has_autor_idAutor_fk FOREIGN KEY (idAutor) REFERENCES autor(idAutor)
);

-- TABELA TELEFONE
CREATE TABLE Telefone(
	idTelefone INT PRIMARY KEY,
    telefone VARCHAR(16),
    idGravadora INT,
    CONSTRAINT telefone_gravadora_fk FOREIGN KEY (idGravadora) REFERENCES gravadora(idGravadora)
);

-- TABELA VENDEDOR
CREATE TABLE Vendedor(
	idVendedor INT PRIMARY KEY,
    nome VARCHAR(45),
    idGravadora INT,
    CONSTRAINT vendedor_gravadora_fk FOREIGN KEY (idGravadora) REFERENCES gravadora(idGravadora)
);
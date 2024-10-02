create database bdnotafiscal;
use bdnotafiscal;

create table NotaFiscal(
	idNotaFiscal int primary key,
	dataEmissao date not null,
    totalNota decimal not null,
    idCliente int not null,
    idVendedor int not null,
    constraint NotaFiscal_idCliente_fk foreign key (idCliente) references Cliente (idCliente),
    constraint NotaFiscal_idVendedor_fk foreign key (idVendedor) references Vendedor (idVendedor)
);

create table Cliente(
	idCliente int primary key,
    nome varchar(45) not null,
    endereco varchar(100) not null
);

create table Vendedor(
	idVendedor int primary key,
    nome varchar(45) not null
);

create table Produto(
	idProduto int primary key,
    descricao varchar(45) not null,
    unidade varchar(2) not null,
    preco decimal not null
);
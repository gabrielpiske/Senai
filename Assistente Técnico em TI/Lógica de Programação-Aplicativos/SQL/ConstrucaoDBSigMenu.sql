CREATE DATABASE `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `categoria` (
  `codCategoria` int(11) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`codCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cidade` (
  `codCidade` int(11) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  PRIMARY KEY (`codCidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `fone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `entrada` (
  `codEntrada` int(11) NOT NULL,
  `Transportadora_coddTransportadora` int(11) NOT NULL,
  `dataped` date NOT NULL,
  `dataentr` date NOT NULL,
  `total` double NOT NULL,
  `frete` double NOT NULL,
  `numnf` int(11) NOT NULL,
  `imposto` double NOT NULL,
  PRIMARY KEY (`codEntrada`),
  KEY `fk_Entrada_Transportadora1_idx` (`Transportadora_coddTransportadora`),
  CONSTRAINT `fk_Entrada_Transportadora1` FOREIGN KEY (`Transportadora_coddTransportadora`) REFERENCES `transportadora` (`coddTransportadora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `fornecedor` (
  `codFornecedor` int(11) NOT NULL,
  `Cidade_codCidade` int(11) NOT NULL,
  `fornecedor` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `num` int(11) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cep` char(9) NOT NULL,
  `contato` varchar(45) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `insc` varchar(45) NOT NULL,
  `tel` char(14) NOT NULL,
  PRIMARY KEY (`codFornecedor`),
  KEY `fk_Fornecedor_Cidade_idx` (`Cidade_codCidade`),
  CONSTRAINT `fk_Fornecedor_Cidade` FOREIGN KEY (`Cidade_codCidade`) REFERENCES `cidade` (`codCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `itementrada` (
  `codItemEntrada` int(11) NOT NULL,
  `Produto_CodProduto` int(11) NOT NULL,
  `Entrada_codEntrada` int(11) NOT NULL,
  `lote` varchar(45) NOT NULL,
  `qtde` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codItemEntrada`),
  KEY `fk_ItemEntrada_Entrada1_idx` (`Entrada_codEntrada`),
  KEY `fk_ItemEntrada_Produto1_idx` (`Produto_CodProduto`),
  CONSTRAINT `fk_ItemEntrada_Entrada1` FOREIGN KEY (`Entrada_codEntrada`) REFERENCES `entrada` (`codEntrada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemEntrada_Produto1` FOREIGN KEY (`Produto_CodProduto`) REFERENCES `produto` (`CodProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `itemsaida` (
  `codItemSaida` int(11) NOT NULL,
  `Saida_codSaida` int(11) NOT NULL,
  `Produto_CodProduto` int(11) NOT NULL,
  `lote` varchar(45) NOT NULL,
  `qtde` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codItemSaida`),
  KEY `fk_ItemSaida_Produto1_idx` (`Produto_CodProduto`),
  KEY `fk_ItemSaida_Saida1_idx` (`Saida_codSaida`),
  CONSTRAINT `fk_ItemSaida_Produto1` FOREIGN KEY (`Produto_CodProduto`) REFERENCES `produto` (`CodProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemSaida_Saida1` FOREIGN KEY (`Saida_codSaida`) REFERENCES `saida` (`codSaida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `loja` (
  `codLoja` int(11) NOT NULL,
  `Cidade_codCidade` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `num` int(11) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `tel` char(14) NOT NULL,
  `insc` varchar(45) NOT NULL,
  `cnpj` char(18) NOT NULL,
  PRIMARY KEY (`codLoja`,`Cidade_codCidade`),
  KEY `fk_Loja_Cidade1_idx` (`Cidade_codCidade`),
  CONSTRAINT `fk_Loja_Cidade1` FOREIGN KEY (`Cidade_codCidade`) REFERENCES `cidade` (`codCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `produto` (
  `CodProduto` int(11) NOT NULL,
  `Categoria_codCategoria` int(11) NOT NULL,
  `Fornecedor_codFornecedor` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `peso` double NOT NULL,
  `controlado` tinyint(4) NOT NULL,
  `qtdemin` int(11) NOT NULL,
  PRIMARY KEY (`CodProduto`),
  KEY `fk_Produto_Categoria1_idx` (`Categoria_codCategoria`),
  KEY `fk_Produto_Fornecedor1_idx` (`Fornecedor_codFornecedor`),
  CONSTRAINT `fk_Produto_Categoria1` FOREIGN KEY (`Categoria_codCategoria`) REFERENCES `categoria` (`codCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Fornecedor1` FOREIGN KEY (`Fornecedor_codFornecedor`) REFERENCES `fornecedor` (`codFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `saida` (
  `codSaida` int(11) NOT NULL,
  `Loja_codLoja` int(11) NOT NULL,
  `Transportadora_coddTransportadora` int(11) NOT NULL,
  `total` double NOT NULL,
  `frete` double NOT NULL,
  `imposto` double NOT NULL,
  PRIMARY KEY (`codSaida`,`Transportadora_coddTransportadora`),
  KEY `fk_Saida_Transportadora1_idx` (`Transportadora_coddTransportadora`),
  KEY `fk_Saida_Loja1_idx` (`Loja_codLoja`),
  CONSTRAINT `fk_Saida_Loja1` FOREIGN KEY (`Loja_codLoja`) REFERENCES `loja` (`codLoja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Saida_Transportadora1` FOREIGN KEY (`Transportadora_coddTransportadora`) REFERENCES `transportadora` (`coddTransportadora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbcliente` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `fone` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `ende` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=12350 DEFAULT CHARSET=utf8;

CREATE TABLE `tbfornecedor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tele` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `tbproduto` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `unidade` varchar(100) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `tbuser` (
  `idtbuser` int(11) NOT NULL,
  `nmuser` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `priv` varchar(1) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `transportadora` (
  `coddTransportadora` int(11) NOT NULL,
  `Cidade_codCidade` int(11) NOT NULL,
  `transportadora` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `num` int(11) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cep` char(9) NOT NULL,
  `cnpj` char(18) NOT NULL,
  `insc` varchar(45) NOT NULL,
  `contato` varchar(45) NOT NULL,
  `tel` varchar(14) NOT NULL,
  PRIMARY KEY (`coddTransportadora`,`Cidade_codCidade`),
  KEY `fk_Transportadora_Cidade1_idx` (`Cidade_codCidade`),
  CONSTRAINT `fk_Transportadora_Cidade1` FOREIGN KEY (`Cidade_codCidade`) REFERENCES `cidade` (`codCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

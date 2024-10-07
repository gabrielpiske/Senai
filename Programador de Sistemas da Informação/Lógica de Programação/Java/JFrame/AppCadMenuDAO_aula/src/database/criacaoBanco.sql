create database db_cad;
use db_cad;

create table cliente(
	id int primary key,
    nome varchar(45) not null,
    telefone varchar(16) not null,
    email varchar(100) not null,
    endereco varchar(255) not null
);
INSERT INTO cliente (id, nome, telefone, email, endereco) VALUES
(1, 'João Silva', '123456789', 'joao.silva@example.com', 'Rua A, 123'),
(2, 'Maria Souza', '987654321', 'maria.souza@example.com', 'Rua B, 456'),
(3, 'Pedro Oliveira', '234567890', 'pedro.oliveira@example.com', 'Rua C, 789'),
(4, 'Ana Lima', '876543210', 'ana.lima@example.com', 'Rua D, 101'),
(5, 'Lucas Santos', '345678901', 'lucas.santos@example.com', 'Rua E, 112'),
(6, 'Mariana Costa', '765432109', 'mariana.costa@example.com', 'Rua F, 131'),
(7, 'Bruno Pereira', '456789012', 'bruno.pereira@example.com', 'Rua G, 415'),
(8, 'Juliana Rocha', '654321098', 'juliana.rocha@example.com', 'Rua H, 161'),
(9, 'Gustavo Fernandes', '567890123', 'gustavo.fernandes@example.com', 'Rua I, 718'),
(10, 'Camila Almeida', '432109876', 'camila.almeida@example.com', 'Rua J, 192'),
(11, 'Renato Ribeiro', '678901234', 'renato.ribeiro@example.com', 'Rua K, 210'),
(12, 'Patrícia Monteiro', '321098765', 'patricia.monteiro@example.com', 'Rua L, 237'),
(13, 'Carlos Mendes', '789012345', 'carlos.mendes@example.com', 'Rua M, 264'),
(14, 'Fernanda Martins', '210987654', 'fernanda.martins@example.com', 'Rua N, 291'),
(15, 'Ricardo Gomes', '890123456', 'ricardo.gomes@example.com', 'Rua O, 318'),
(16, 'Isabela Carvalho', '109876543', 'isabela.carvalho@example.com', 'Rua P, 345'),
(17, 'Felipe Barros', '901234567', 'felipe.barros@example.com', 'Rua Q, 372'),
(18, 'Aline Borges', '098765432', 'aline.borges@example.com', 'Rua R, 399'),
(19, 'André Nunes', '012345678', 'andre.nunes@example.com', 'Rua S, 426'),
(20, 'Tatiana Farias', '234567891', 'tatiana.farias@example.com', 'Rua T, 453');


create table produto(
	id int primary key,
    descricao varchar(255) not null,
    unidade varchar(255) not null,
    quantidade decimal(10,2) not null,
    preco decimal(10,2) not null
);
INSERT INTO produto (id, descricao, unidade, quantidade, preco) VALUES
(1, 'Teclado Mecânico', 'un', 150, 250.00),
(2, 'Mouse Óptico', 'un', 300, 120.00),
(3, 'Monitor LED 24"', 'un', 80, 900.00),
(4, 'Headset Gamer', 'un', 200, 350.00),
(5, 'Notebook i7 16GB RAM', 'un', 50, 4500.00),
(6, 'Smartphone 128GB', 'un', 120, 2500.00),
(7, 'Tablet 10"', 'un', 100, 1800.00),
(8, 'Impressora Multifuncional', 'un', 60, 700.00),
(9, 'Cadeira Gamer', 'un', 90, 850.00),
(10, 'Placa de Vídeo 8GB', 'un', 40, 2800.00),
(11, 'Processador i9', 'un', 30, 3200.00),
(12, 'HD Externo 1TB', 'un', 250, 400.00),
(13, 'Memória RAM 16GB', 'un', 180, 500.00),
(14, 'Fonte 750W', 'un', 70, 600.00),
(15, 'SSD 512GB', 'un', 200, 600.00),
(16, 'Gabinete ATX', 'un', 50, 400.00),
(17, 'Webcam Full HD', 'un', 120, 250.00),
(18, 'Roteador Wi-Fi 6', 'un', 100, 450.00),
(19, 'Carregador Portátil 20,000mAh', 'un', 300, 150.00),
(20, 'Adaptador USB-C', 'un', 400, 80.00);


create table fornecedor(
	id int primary key,
    empresa varchar(255) not null,
    contato varchar(255) not null,
    telefone varchar(255) not null,
    email varchar(255) not null
);
INSERT INTO fornecedor (id, empresa, contato, telefone, email) VALUES
(1, 'Tech Solutions Ltda', 'João Almeida', '11987654321', 'joao.almeida@techsol.com'),
(2, 'Alpha Supplies', 'Maria Fernanda', '21976543210', 'maria.fernanda@alphasup.com'),
(3, 'Global Import', 'Carlos Pereira', '31965432109', 'carlos.pereira@globalimport.com'),
(4, 'Fast Delivery', 'Ana Clara', '41954321098', 'ana.clara@fastdelivery.com'),
(5, 'Eco Materials', 'Lucas Martins', '51943210987', 'lucas.martins@ecomaterials.com'),
(6, 'Blue Tech', 'Juliana Souza', '61932109876', 'juliana.souza@bluetech.com'),
(7, 'Mega Distribuidora', 'Paulo Costa', '71921098765', 'paulo.costa@megadist.com'),
(8, 'Supreme Supplies', 'Claudia Mendes', '81910987654', 'claudia.mendes@supremesup.com'),
(9, 'Prime Foods', 'Renato Farias', '91909876543', 'renato.farias@primefoods.com'),
(10, 'Green Earth Ltda', 'Fernanda Lima', '11987654322', 'fernanda.lima@greenearth.com'),
(11, 'Best Electronics', 'André Gonçalves', '21976543211', 'andre.goncalves@bestelectronics.com'),
(12, 'Quick Transport', 'Mariana Rocha', '31965432110', 'mariana.rocha@quicktransport.com'),
(13, 'Smart Office', 'Bruno Nunes', '41954321099', 'bruno.nunes@smartoffice.com'),
(14, 'Max Trade', 'Camila Ribeiro', '51943210988', 'camila.ribeiro@maxtrade.com'),
(15, 'NextGen Services', 'Felipe Barbosa', '61932109877', 'felipe.barbosa@nextgen.com'),
(16, 'Quality Parts', 'Carla Dias', '71921098766', 'carla.dias@qualityparts.com'),
(17, 'Nova Supplies', 'Rodrigo Silva', '81910987655', 'rodrigo.silva@novasupplies.com'),
(18, 'Elite Logistics', 'Patrícia Moraes', '91909876544', 'patricia.moraes@elitelogistics.com'),
(19, 'Bright Materials', 'Eduardo Campos', '11987654323', 'eduardo.campos@brightmaterials.com'),
(20, 'Global Connect', 'Tatiana Santos', '21976543212', 'tatiana.santos@globalconnect.com');
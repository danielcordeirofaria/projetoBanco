CREATE DATABASE db_banco;

use db_banco;

CREATE TABLE tbl_cliente(
    id_cliente INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    cpf_cliente varchar(20) unique NOT NULL,
    telefone_cliente varchar(20) unique NOT NULL
);

CREATE TABLE tbl_conta(
    numero_conta INTEGER AUTO_INCREMENT PRIMARY KEY,
    agencia INTEGER not null,
    tipo_conta INTEGER,
    saldo double,
    id_cliente INTEGER not null,
    constraint fk_tbl_cliente foreign key(id_cliente) references tbl_cliente(id_cliente)
);

CREATE TABLE tbl_movimentacao(
    num_seq INTEGER AUTO_INCREMENT PRIMARY KEY,
    data_operacao date not null,
    valor double not null,
    tipo_operacao INTEGER not null,
    descricao varchar(255),
    numero_conta INTEGER not null,
    constraint fk_tbl_conta foreign key(numero_conta) references tbl_conta(numero_conta)
);

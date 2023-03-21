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


-- Exemplo de inserção de dados

{
    "numeroConta": null,
    "agencia": 1649,
    "tipoConta": 1,
    "saldo": 0.00,
    "titular": {
        "idCliente": 1
    }
}

MYSQLDATABASE: railway

MYSQLHOST: containers-us-west-114.railway.app

MYSQLPASSWORD: t22eBEGHosdmJOpiiZ91

MYSQLPORT: 7541

MYSQLUSER: root
-- Script Banco de Dados Completo -- 

-- Acessando o usu�rio master --
USE master
GO

-- Criando o DATABASE --
CREATE DATABASE DB_DIBREINN
GO

-- Selecionando o DATABASE para criar as tabelas -- 
USE DB_DIBREINN
GO

-- Criando a TB_UNIDADE --
CREATE TABLE TB_UNIDADE
(
ID_UNIDADE VARCHAR(25) NOT NULL,
CNPJ VARCHAR (20)NOT NUll,
TIPO BIT NOT NULL,
LOGRADOURO VARCHAR (50),
NUM INT,
CEP VARCHAR (20),
COMPLEMENTO VARCHAR(50),
BAIRRO VARCHAR (30),
CIDADE VARCHAR(20),
ESTADO CHAR(2),

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_UNIDADE_ID_UNIDADE PRIMARY KEY (ID_UNIDADE),

-- Definindo regra de integridade --
CONSTRAINT UQ_TB_UNIDADE_CNPJ UNIQUE (CNPJ)
)
GO



-- Criando a TB_PESSOA -- 
CREATE TABLE TB_PESSOA
(
ID_PESSOA INT IDENTITY(1,1) NOT NULL,
NOME VARCHAR (15),
SOBRENOME VARCHAR (25),
SEXO CHAR (1),
RG VARCHAR (15),
CPF VARCHAR(15),
DATANASC DATE,
TELEFONE VARCHAR(15),
CEL VARCHAR (15),
EMAIL VARCHAR(35),
TIPO CHAR(1),
NEWSLETTER BIT,

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_PESSOA_ID_PESSOA PRIMARY KEY (ID_PESSOA),

-- Definindo regras de integridade --
CONSTRAINT UQ_TB_PESSOA_CPF UNIQUE (CPF),
CONSTRAINT CK_CADASTROS_SEXO CHECK (SEXO IN ('F','M'))
)
GO

-- Criando a TB_FUNCIONARIO --
CREATE TABLE TB_FUNCIONARIO
(
ID_PESSOA INT NOT NULL,
ID_UNIDADE VARCHAR(25),
DEPARTAMENTO VARCHAR (15),
CARGO VARCHAR (30),
SALARIO DECIMAL (10,2),
SENHA VARCHAR(20)

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_FUCIONARIO_ID_PESSOA PRIMARY KEY (ID_PESSOA),

-- Definindo as Chaves Estrangeiras --
CONSTRAINT FK_TB_FUNCIONARIO_ID_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES TB_PESSOA(ID_PESSOA),
CONSTRAINT FK_TB_FUNCIONARIO_ID_UNIDADE FOREIGN KEY (ID_UNIDADE) REFERENCES TB_UNIDADE(ID_UNIDADE),

-- Defininado regras de integridade --
CONSTRAINT CK_CADASTROS_SALARIO CHECK (SALARIO >= 0)
)
GO

-- Criando a TB_HOSPEDE --
CREATE TABLE TB_HOSPEDE
(
ID_PESSOA INT NOT NULL,
N_CARTAO VARCHAR (20)

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_HOSPEDE_ID_PESSOA PRIMARY KEY (ID_PESSOA)
-- Definindo a Chave Estrangeira --
CONSTRAINT FK_TB_HOSPEDE_ID_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES TB_PESSOA(ID_PESSOA)
)
GO


-- Criando a TB_ENDERECO --
CREATE TABLE TB_ENDERECO
(
ID_PESSOA INT NOT NULL,
LOGRADOURO VARCHAR (50),
NUM INT,
CEP VARCHAR (20),
COMPLEMENTO VARCHAR(50),
BAIRRO VARCHAR (30),
CIDADE VARCHAR(20),
ESTADO CHAR(2),
PAIS VARCHAR (30),

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_ENDERECO_ID_PESSOA PRIMARY KEY (ID_PESSOA),
-- Definindo a Chave Estrangeira --
CONSTRAINT FK_TB_ENDERECO_ID_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES TB_PESSOA(ID_PESSOA),
)
GO

-- Criando a TB_QUARTO --
CREATE TABLE TB_QUARTO
(
ID_QUARTO INT IDENTITY(1,1)NOT NULL,
VALOR_DIARIA DECIMAL(10,2),
OCUPADO BIT,
NUMERO INT,
ANDAR VARCHAR(10),
RAMAL VARCHAR (10)

-- Definindo a Chave Primaria --
CONSTRAINT PK_TB_QUARTO_ID_QUARTO PRIMARY KEY (ID_QUARTO)
)
GO









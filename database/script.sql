DROP TABLE CP1_EMPRESA CASCADE CONSTRAINTS;

DROP TABLE CP1_CONVENIO CASCADE CONSTRAINTS;

DROP TABLE CP1_AREA_ATUACAO CASCADE CONSTRAINTS;

DROP TABLE CP1_UNIDADE CASCADE CONSTRAINTS;

DROP TABLE CP1_ENDERECO_UNIDADE CASCADE CONSTRAINTS;

DROP TABLE CP1_MEDICO_UNIDADE CASCADE CONSTRAINTS;

DROP TABLE CP1_MEDICO CASCADE CONSTRAINTS;

DROP TABLE CP1_CLIENTE CASCADE CONSTRAINTS;

DROP TABLE CP1_ENDERECO_CLIENTE CASCADE CONSTRAINTS;

DROP TABLE CP1_COMORBIDADE CASCADE CONSTRAINTS;

DROP TABLE CP1_HISTORICO_SAUDE_CLIENTE CASCADE CONSTRAINTS;

DROP TABLE CP1_HISTORICO_HOSPITAL_CLIENTE CASCADE CONSTRAINTS;

DROP TABLE CP1_CIDADE CASCADE CONSTRAINTS;

DROP TABLE CP1_ESTADO CASCADE CONSTRAINTS;

DROP TABLE CP1_ESTADO_CIVIL CASCADE CONSTRAINTS;

DROP SEQUENCE CP1_ESTADO_SEQ;

DROP SEQUENCE CP1_CIDADE_SEQ;

DROP SEQUENCE CP1_ESTADO_CIVIL_SEQ;

DROP SEQUENCE CP1_EMPRESA_SEQ;

DROP SEQUENCE CP1_CONVENIO_SEQ;

DROP SEQUENCE CP1_AREA_ATUACAO_SEQ;

DROP SEQUENCE CP1_UNIDADE_SEQ;

DROP SEQUENCE CP1_ENDERECO_UNIDADE_SEQ;

DROP SEQUENCE CP1_MEDICO_SEQ;

DROP SEQUENCE CP1_MEDICO_UNIDADE_SEQ;

DROP SEQUENCE CP1_CLIENTE_SEQ;

DROP SEQUENCE CP1_ENDERECO_CLIENTE_SEQ;

DROP SEQUENCE CP1_COMORBIDADE_SEQ;

DROP SEQUENCE CP1_HISTORICO_SAUDE_CLIENTE_SEQ;

DROP SEQUENCE CP1_HISTORICO_HOSPITAL_CLIENTE_SEQ;

CREATE SEQUENCE CP1_ESTADO_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_CIDADE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_EMPRESA_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_CONVENIO_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_AREA_ATUACAO_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_UNIDADE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_ENDERECO_UNIDADE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_MEDICO_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_MEDICO_UNIDADE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_ESTADO_CIVIL_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_ENDERECO_CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_COMORBIDADE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_HISTORICO_SAUDE_CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE CP1_HISTORICO_HOSPITAL_CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE CP1_ESTADO (
    ID NUMBER DEFAULT CP1_ESTADO_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(20)
);

CREATE TABLE CP1_CIDADE (
    ID NUMBER DEFAULT CP1_CIDADE_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(20),
    ESTADO_ID NUMBER,
    FOREIGN KEY (ESTADO_ID) REFERENCES CP1_ESTADO(ID)
);

CREATE TABLE CP1_EMPRESA (
    ID NUMBER DEFAULT CP1_EMPRESA_SEQ.NEXTVAL PRIMARY KEY,
    CNPJ VARCHAR(20),
    NOME VARCHAR(100),
    TIPO VARCHAR(100),
    TELEFONE VARCHAR(20),
    EMAIL VARCHAR(100)
);

CREATE TABLE CP1_CONVENIO (
    ID NUMBER DEFAULT CP1_CONVENIO_SEQ.NEXTVAL PRIMARY KEY,
    EMPRESA_ID NUMBER,
    NOME VARCHAR(100),
    VALOR FLOAT(53),
    TIPO_SERVICO VARCHAR(100),
    COBERTURA VARCHAR(100),
    CONTATO VARCHAR(100),
    VALIDADE DATE,
    FOREIGN KEY (EMPRESA_ID) REFERENCES CP1_EMPRESA(ID)
);

CREATE TABLE CP1_AREA_ATUACAO (
    ID NUMBER DEFAULT CP1_AREA_ATUACAO_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(100)
);

CREATE TABLE CP1_UNIDADE (
    ID NUMBER DEFAULT CP1_UNIDADE_SEQ.NEXTVAL PRIMARY KEY,
    EMPRESA_ID NUMBER,
    AREA_ATUACAO_ID NUMBER,
    NOME VARCHAR(100),
    TELEFONE VARCHAR(20),
    EMAIL VARCHAR(100),
    TIPO VARCHAR(100),
    CAPACIDADE NUMBER,
    FOREIGN KEY (EMPRESA_ID) REFERENCES CP1_EMPRESA(ID),
    FOREIGN KEY (AREA_ATUACAO_ID) REFERENCES CP1_AREA_ATUACAO(ID)
);

CREATE TABLE CP1_ENDERECO_UNIDADE (
    ID NUMBER DEFAULT CP1_ENDERECO_UNIDADE_SEQ.NEXTVAL PRIMARY KEY,
    UNIDADE_ID NUMBER UNIQUE NOT NULL,
    RUA VARCHAR(100),
    NUMERO VARCHAR(10),
    CEP VARCHAR(20),
    CIDADE_ID NUMBER,
    FOREIGN KEY (UNIDADE_ID) REFERENCES CP1_UNIDADE(ID),
    FOREIGN KEY (CIDADE_ID) REFERENCES CP1_CIDADE(ID)
);

CREATE TABLE CP1_MEDICO (
    ID NUMBER DEFAULT CP1_MEDICO_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(100),
    TELEFONE VARCHAR(20),
    EMAIL VARCHAR(100),
    ESPECIALIDADE VARCHAR(100),
    CRM VARCHAR(20)
);

CREATE TABLE CP1_MEDICO_UNIDADE (
    ID NUMBER DEFAULT CP1_MEDICO_UNIDADE_SEQ.NEXTVAL PRIMARY KEY,
    MEDICO_ID NUMBER NOT NULL,
    UNIDADE_ID NUMBER NOT NULL,
    HORARIO_ATENDIMENTO VARCHAR(100),
    FOREIGN KEY (MEDICO_ID) REFERENCES CP1_MEDICO(ID),
    FOREIGN KEY (UNIDADE_ID) REFERENCES CP1_UNIDADE(ID)
);

CREATE TABLE CP1_ESTADO_CIVIL (
    ID NUMBER DEFAULT CP1_ESTADO_CIVIL_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(20)
);

CREATE TABLE CP1_CLIENTE (
    ID NUMBER DEFAULT CP1_CLIENTE_SEQ.NEXTVAL PRIMARY KEY,
    RG VARCHAR(20),
    NOME VARCHAR(100),
    SEXO CHAR(1) CHECK (SEXO IN ('M', 'F', 'O')),
    TELEFONE VARCHAR(20),
    EMAIL VARCHAR(100),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(20),
    CONVENIO_ID NUMBER,
    ESTADO_CIVIL_ID NUMBER,
    FOREIGN KEY (CONVENIO_ID) REFERENCES CP1_CONVENIO(ID),
    FOREIGN KEY (ESTADO_CIVIL_ID) REFERENCES CP1_ESTADO_CIVIL(ID)
);

CREATE TABLE CP1_ENDERECO_CLIENTE (
    ID NUMBER DEFAULT CP1_ENDERECO_CLIENTE_SEQ.NEXTVAL PRIMARY KEY,
    CLIENTE_ID NUMBER UNIQUE NOT NULL,
    RUA VARCHAR(100),
    NUMERO VARCHAR(10),
    CEP VARCHAR(20),
    CIDADE_ID NUMBER,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CP1_CLIENTE(ID),
    FOREIGN KEY (CIDADE_ID) REFERENCES CP1_CIDADE(ID)
);

CREATE TABLE CP1_COMORBIDADE (
    ID NUMBER DEFAULT CP1_COMORBIDADE_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR(100)
);

CREATE TABLE CP1_HISTORICO_SAUDE_CLIENTE (
    ID NUMBER DEFAULT CP1_HISTORICO_SAUDE_CLIENTE_SEQ.NEXTVAL PRIMARY KEY,
    CLIENTE_ID NUMBER UNIQUE NOT NULL,
    COMORBIDADE_ID NUMBER,
    DATA_REGISTRO DATE,
    FUMA NUMBER(1) CHECK (FUMA IN (0, 1)),
    OBSERVACOES VARCHAR(100),
    FOREIGN KEY (CLIENTE_ID) REFERENCES CP1_CLIENTE(ID),
    FOREIGN KEY (COMORBIDADE_ID) REFERENCES CP1_COMORBIDADE(ID)
);

CREATE TABLE CP1_HISTORICO_HOSPITAL_CLIENTE (
    ID NUMBER DEFAULT CP1_HISTORICO_HOSPITAL_CLIENTE_SEQ.NEXTVAL PRIMARY KEY,
    CLIENTE_ID NUMBER UNIQUE NOT NULL,
    DATA_REGISTRO DATE,
    HISTORICO_MEDICO VARCHAR(100),
    EXAMES_REALIZADOS VARCHAR(100),
    MEDICAMENTOS_PRESCRITOS VARCHAR(100),
    OBSERVACOES VARCHAR(100),
    FOREIGN KEY (CLIENTE_ID) REFERENCES CP1_CLIENTE(ID)
);

INSERT INTO CP1_ESTADO (
    NOME
) VALUES (
    'São Paulo'
);

INSERT INTO CP1_ESTADO (
    NOME
) VALUES (
    'Rio de Janeiro'
);

INSERT INTO CP1_ESTADO (
    NOME
) VALUES (
    'Minas Gerais'
);

INSERT INTO CP1_ESTADO (
    NOME
) VALUES (
    'Paraná'
);

INSERT INTO CP1_ESTADO (
    NOME
) VALUES (
    'Santa Catarina'
);

INSERT INTO CP1_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'São Paulo',
    1
);

INSERT INTO CP1_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Rio de Janeiro',
    2
);

INSERT INTO CP1_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Belo Horizonte',
    3
);

INSERT INTO CP1_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Curitiba',
    4
);

INSERT INTO CP1_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Florianópolis',
    5
);

INSERT INTO CP1_EMPRESA (
    CNPJ,
    NOME,
    TIPO,
    TELEFONE,
    EMAIL
) VALUES (
    '12345678901234',
    'Empresa X',
    'Saúde',
    '11223344',
    'empresa.x@email.com'
);

INSERT INTO CP1_EMPRESA (
    CNPJ,
    NOME,
    TIPO,
    TELEFONE,
    EMAIL
) VALUES (
    '98765432109876',
    'Empresa Y',
    'Saúde',
    '55443322',
    'empresa.y@email.com'
);

INSERT INTO CP1_EMPRESA (
    CNPJ,
    NOME,
    TIPO,
    TELEFONE,
    EMAIL
) VALUES (
    '98765432101234',
    'Empresa Z',
    'Saúde',
    '55443311',
    'empresa.y@email.com'
);

INSERT INTO CP1_EMPRESA (
    CNPJ,
    NOME,
    TIPO,
    TELEFONE,
    EMAIL
) VALUES (
    '98765432101235',
    'Empresa G',
    'Saúde',
    '55444411',
    'empresa.y@email.com'
);

INSERT INTO CP1_EMPRESA (
    CNPJ,
    NOME,
    TIPO,
    TELEFONE,
    EMAIL
) VALUES (
    '98765432102222',
    'Empresa H',
    'Saúde',
    '88443311',
    'empresa.y@email.com'
);

INSERT INTO CP1_CONVENIO (
    EMPRESA_ID,
    NOME,
    VALOR,
    TIPO_SERVICO,
    COBERTURA,
    CONTATO,
    VALIDADE
) VALUES (
    1,
    'Convenio A',
    500.00,
    'Consulta Médica',
    'Consultas e exames básicos',
    'contato@convenioa.com',
    TO_DATE('2025-12-31', 'YYYY-MM-DD')
);

INSERT INTO CP1_CONVENIO (
    EMPRESA_ID,
    NOME,
    VALOR,
    TIPO_SERVICO,
    COBERTURA,
    CONTATO,
    VALIDADE
) VALUES (
    2,
    'Convenio B',
    800.00,
    'Consulta e Exames',
    'Consultas, exames básicos e especializados',
    'contato@conveniob.com',
    TO_DATE('2026-06-30', 'YYYY-MM-DD')
);

INSERT INTO CP1_CONVENIO (
    EMPRESA_ID,
    NOME,
    VALOR,
    TIPO_SERVICO,
    COBERTURA,
    CONTATO,
    VALIDADE
) VALUES (
    2,
    'Convenio B',
    600.00,
    'Consulta e Exames',
    'Consultas, exames básicos e especializados',
    'contato@conveniob.com',
    TO_DATE('2026-06-30', 'YYYY-MM-DD')
);

INSERT INTO CP1_CONVENIO (
    EMPRESA_ID,
    NOME,
    VALOR,
    TIPO_SERVICO,
    COBERTURA,
    CONTATO,
    VALIDADE
) VALUES (
    3,
    'Convenio C',
    700.00,
    'Cirurgia',
    'Procedimentos cirúrgicos e acompanhamento pós-operatório',
    'contato@convenioc.com',
    TO_DATE('2027-01-15', 'YYYY-MM-DD')
);

INSERT INTO CP1_CONVENIO (
    EMPRESA_ID,
    NOME,
    VALOR,
    TIPO_SERVICO,
    COBERTURA,
    CONTATO,
    VALIDADE
) VALUES (
    4,
    'Convenio D',
    800.00,
    'Fisioterapia',
    'Sessões de fisioterapia e acompanhamento especializado',
    'contato@conveniod.com',
    TO_DATE('2026-12-31', 'YYYY-MM-DD')
);

INSERT INTO CP1_AREA_ATUACAO (
    NOME
) VALUES (
    'Cardiologia'
);

INSERT INTO CP1_AREA_ATUACAO (
    NOME
) VALUES (
    'Clínica Geral'
);

INSERT INTO CP1_AREA_ATUACAO (
    NOME
) VALUES (
    'Pediatria'
);

INSERT INTO CP1_AREA_ATUACAO (
    NOME
) VALUES (
    'Ortopedia'
);

INSERT INTO CP1_AREA_ATUACAO (
    NOME
) VALUES (
    'Ginecologia'
);

INSERT INTO CP1_UNIDADE (
    EMPRESA_ID,
    NOME,
    TELEFONE,
    EMAIL,
    TIPO,
    CAPACIDADE,
    AREA_ATUACAO_ID
) VALUES (
    1,
    'Unidade A',
    '11223344',
    'unidade.a@email.com',
    'Hospital',
    100,
    1
);

INSERT INTO CP1_UNIDADE (
    EMPRESA_ID,
    NOME,
    TELEFONE,
    EMAIL,
    TIPO,
    CAPACIDADE,
    AREA_ATUACAO_ID
) VALUES (
    2,
    'Unidade B',
    '55443322',
    'unidade.b@email.com',
    'Hospital',
    150,
    2
);

INSERT INTO CP1_UNIDADE (
    EMPRESA_ID,
    NOME,
    TELEFONE,
    EMAIL,
    TIPO,
    CAPACIDADE,
    AREA_ATUACAO_ID
) VALUES (
    2,
    'Unidade B',
    '22334455',
    'unidade.b@email.com',
    'Clínica',
    50,
    3
);

INSERT INTO CP1_UNIDADE (
    EMPRESA_ID,
    NOME,
    TELEFONE,
    EMAIL,
    TIPO,
    CAPACIDADE,
    AREA_ATUACAO_ID
) VALUES (
    3,
    'Unidade C',
    '33445566',
    'unidade.c@email.com',
    'Consultório',
    20,
    4
);

INSERT INTO CP1_UNIDADE (
    EMPRESA_ID,
    NOME,
    TELEFONE,
    EMAIL,
    TIPO,
    CAPACIDADE,
    AREA_ATUACAO_ID
) VALUES (
    4,
    'Unidade D',
    '44556677',
    'unidade.d@email.com',
    'Laboratório',
    30,
    5
);

INSERT INTO CP1_ENDERECO_UNIDADE (
    UNIDADE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    1,
    'Rua da Unidade A',
    '789',
    '54321-098',
    1
);

INSERT INTO CP1_ENDERECO_UNIDADE (
    UNIDADE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    2,
    'Rua da Unidade B',
    '101',
    '98765-432',
    2
);

INSERT INTO CP1_ENDERECO_UNIDADE (
    UNIDADE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    3,
    'Avenida Principal',
    '200',
    '12345-678',
    3
);

INSERT INTO CP1_ENDERECO_UNIDADE (
    UNIDADE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    4,
    'Rua da Unidade D',
    '50',
    '54321-876',
    4
);

INSERT INTO CP1_ENDERECO_UNIDADE (
    UNIDADE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    5,
    'Avenida Central',
    '300',
    '13579-246',
    5
);

INSERT INTO CP1_MEDICO (
    NOME,
    TELEFONE,
    EMAIL,
    ESPECIALIDADE,
    CRM
) VALUES (
    'Dr. José Santos',
    '11223344',
    'jose.santos@email.com',
    'Cardiologia',
    '12345'
);

INSERT INTO CP1_MEDICO (
    NOME,
    TELEFONE,
    EMAIL,
    ESPECIALIDADE,
    CRM
) VALUES (
    'Dra. Ana Oliveira',
    '55443322',
    'ana.oliveira@email.com',
    'Clínica Geral',
    '54321'
);

INSERT INTO CP1_MEDICO (
    NOME,
    TELEFONE,
    EMAIL,
    ESPECIALIDADE,
    CRM
) VALUES (
    'Dr. Marcos Santos',
    '99887766',
    'marcos.santos@email.com',
    'Ortopedia',
    '12345'
);

INSERT INTO CP1_MEDICO (
    NOME,
    TELEFONE,
    EMAIL,
    ESPECIALIDADE,
    CRM
) VALUES (
    'Dra. Carolina Mendes',
    '77665544',
    'carolina.mendes@email.com',
    'Pediatria',
    '54321'
);

INSERT INTO CP1_MEDICO (
    NOME,
    TELEFONE,
    EMAIL,
    ESPECIALIDADE,
    CRM
) VALUES (
    'Dr. Pedro Alves',
    '33221100',
    'pedro.alves@email.com',
    'Cardiologia',
    '67890'
);

INSERT INTO CP1_MEDICO_UNIDADE (
    MEDICO_ID,
    UNIDADE_ID,
    HORARIO_ATENDIMENTO
) VALUES (
    1,
    1,
    'Segunda a Sexta, 08:00 - 17:00'
);

INSERT INTO CP1_MEDICO_UNIDADE (
    MEDICO_ID,
    UNIDADE_ID,
    HORARIO_ATENDIMENTO
) VALUES (
    2,
    2,
    'Segunda a Sexta, 09:00 - 18:00'
);

INSERT INTO CP1_MEDICO_UNIDADE (
    MEDICO_ID,
    UNIDADE_ID,
    HORARIO_ATENDIMENTO
) VALUES (
    3,
    3,
    'Segunda a Sexta, 08:00 - 17:00'
);

INSERT INTO CP1_MEDICO_UNIDADE (
    MEDICO_ID,
    UNIDADE_ID,
    HORARIO_ATENDIMENTO
) VALUES (
    4,
    4,
    'Segunda a Sábado, 10:00 - 20:00'
);

INSERT INTO CP1_MEDICO_UNIDADE (
    MEDICO_ID,
    UNIDADE_ID,
    HORARIO_ATENDIMENTO
) VALUES (
    5,
    5,
    'Segunda a Quinta, 07:00 - 16:00; Sexta, 07:00 - 12:00'
);

INSERT INTO CP1_ESTADO_CIVIL (
    NOME
) VALUES (
    'Solteiro'
);

INSERT INTO CP1_ESTADO_CIVIL (
    NOME
) VALUES (
    'Casado'
);

INSERT INTO CP1_ESTADO_CIVIL (
    NOME
) VALUES (
    'Divorciado'
);

INSERT INTO CP1_ESTADO_CIVIL (
    NOME
) VALUES (
    'Viúvo'
);

INSERT INTO CP1_CLIENTE (
    RG,
    NOME,
    SEXO,
    TELEFONE,
    EMAIL,
    DATA_NASCIMENTO,
    CPF,
    ESTADO_CIVIL_ID,
    CONVENIO_ID
) VALUES (
    '123456789',
    'João da Silva',
    'M',
    '11223344',
    'joao.silva@email.com',
    TO_DATE('1990-01-01', 'YYYY-MM-DD'),
    '123.456.789-00',
    1,
    1
);

INSERT INTO CP1_CLIENTE (
    RG,
    NOME,
    SEXO,
    TELEFONE,
    EMAIL,
    DATA_NASCIMENTO,
    CPF,
    ESTADO_CIVIL_ID,
    CONVENIO_ID
) VALUES (
    '987654321',
    'Maria Souza',
    'F',
    '55443322',
    'maria.souza@email.com',
    TO_DATE('1985-05-10', 'YYYY-MM-DD'),
    '987.654.321-00',
    2,
    2
);

INSERT INTO CP1_CLIENTE (
    RG,
    NOME,
    SEXO,
    TELEFONE,
    EMAIL,
    DATA_NASCIMENTO,
    CPF,
    ESTADO_CIVIL_ID,
    CONVENIO_ID
) VALUES (
    '123456789',
    'João Silva',
    'M',
    '99887766',
    'joao.silva@email.com',
    TO_DATE('1990-08-20', 'YYYY-MM-DD'),
    '123.456.789-00',
    3,
    1
);

INSERT INTO CP1_CLIENTE (
    RG,
    NOME,
    SEXO,
    TELEFONE,
    EMAIL,
    DATA_NASCIMENTO,
    CPF,
    ESTADO_CIVIL_ID,
    CONVENIO_ID
) VALUES (
    '234567890',
    'Ana Oliveira',
    'F',
    '77665544',
    'ana.oliveira@email.com',
    TO_DATE('1980-03-15', 'YYYY-MM-DD'),
    '234.567.890-00',
    4,
    3
);

INSERT INTO CP1_CLIENTE (
    RG,
    NOME,
    SEXO,
    TELEFONE,
    EMAIL,
    DATA_NASCIMENTO,
    CPF,
    ESTADO_CIVIL_ID,
    CONVENIO_ID
) VALUES (
    '345678901',
    'Carlos Pereira',
    'M',
    '33221100',
    'carlos.pereira@email.com',
    TO_DATE('1975-12-05', 'YYYY-MM-DD'),
    '345.678.901-00',
    4,
    4
);

INSERT INTO CP1_ENDERECO_CLIENTE (
    CLIENTE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    1,
    'Rua dos Clientes',
    '123',
    '12345-678',
    1
);

INSERT INTO CP1_ENDERECO_CLIENTE (
    CLIENTE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    2,
    'Avenida das Flores',
    '456',
    '54321-098',
    2
);

INSERT INTO CP1_ENDERECO_CLIENTE (
    CLIENTE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    3,
    'Rua das Palmeiras',
    '789',
    '12345-678',
    3
);

INSERT INTO CP1_ENDERECO_CLIENTE (
    CLIENTE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    4,
    'Avenida Central',
    '101',
    '87654-321',
    4
);

INSERT INTO CP1_ENDERECO_CLIENTE (
    CLIENTE_ID,
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID
) VALUES (
    5,
    'Rua dos Girassóis',
    '222',
    '13579-246',
    5
);

INSERT INTO CP1_COMORBIDADE (
    NOME
) VALUES (
    'Hipertensão'
);

INSERT INTO CP1_COMORBIDADE (
    NOME
) VALUES (
    'Diabetes'
);

INSERT INTO CP1_COMORBIDADE (
    NOME
) VALUES (
    'Asma'
);

INSERT INTO CP1_COMORBIDADE (
    NOME
) VALUES (
    'Depressão'
);

INSERT INTO CP1_COMORBIDADE (
    NOME
) VALUES (
    'Obesidade'
);

INSERT INTO CP1_HISTORICO_SAUDE_CLIENTE (
    CLIENTE_ID,
    COMORBIDADE_ID,
    DATA_REGISTRO,
    FUMA,
    OBSERVACOES
) VALUES (
    1,
    1,
    TO_DATE('2020-01-01', 'YYYY-MM-DD'),
    0,
    'Sem observações'
);

INSERT INTO CP1_HISTORICO_SAUDE_CLIENTE (
    CLIENTE_ID,
    COMORBIDADE_ID,
    DATA_REGISTRO,
    FUMA,
    OBSERVACOES
) VALUES (
    2,
    2,
    TO_DATE('2021-03-15', 'YYYY-MM-DD'),
    1,
    'Sem observações'
);

INSERT INTO CP1_HISTORICO_SAUDE_CLIENTE (
    CLIENTE_ID,
    COMORBIDADE_ID,
    DATA_REGISTRO,
    FUMA,
    OBSERVACOES
) VALUES (
    3,
    3,
    TO_DATE('2022-01-10', 'YYYY-MM-DD'),
    0,
    'Cliente tem episódios ocasionais de asma'
);

INSERT INTO CP1_HISTORICO_SAUDE_CLIENTE (
    CLIENTE_ID,
    COMORBIDADE_ID,
    DATA_REGISTRO,
    FUMA,
    OBSERVACOES
) VALUES (
    4,
    4,
    TO_DATE('2022-05-20', 'YYYY-MM-DD'),
    1,
    'Cliente está sob medicação para controle da pressão arterial'
);

INSERT INTO CP1_HISTORICO_SAUDE_CLIENTE (
    CLIENTE_ID,
    COMORBIDADE_ID,
    DATA_REGISTRO,
    FUMA,
    OBSERVACOES
) VALUES (
    5,
    5,
    TO_DATE('2023-09-05', 'YYYY-MM-DD'),
    0,
    'Cliente está em acompanhamento psicológico regular'
);

INSERT INTO CP1_HISTORICO_HOSPITAL_CLIENTE (
    CLIENTE_ID,
    DATA_REGISTRO,
    HISTORICO_MEDICO,
    EXAMES_REALIZADOS,
    MEDICAMENTOS_PRESCRITOS,
    OBSERVACOES
) VALUES (
    1,
    TO_DATE('2022-01-01', 'YYYY-MM-DD'),
    'Cirurgia de apendicite em 2015',
    'Exames de rotina',
    'Paracetamol',
    'Nenhuma observação'
);

INSERT INTO CP1_HISTORICO_HOSPITAL_CLIENTE (
    CLIENTE_ID,
    DATA_REGISTRO,
    HISTORICO_MEDICO,
    EXAMES_REALIZADOS,
    MEDICAMENTOS_PRESCRITOS,
    OBSERVACOES
) VALUES (
    2,
    TO_DATE('2023-07-20', 'YYYY-MM-DD'),
    'Internação por pneumonia',
    'Exames de sangue',
    'Antibióticos',
    'Nenhuma observação'
);

INSERT INTO CP1_HISTORICO_HOSPITAL_CLIENTE (
    CLIENTE_ID,
    DATA_REGISTRO,
    HISTORICO_MEDICO,
    EXAMES_REALIZADOS,
    MEDICAMENTOS_PRESCRITOS,
    OBSERVACOES
) VALUES (
    3,
    TO_DATE('2022-05-10', 'YYYY-MM-DD'),
    'Cirurgia de emergência de apendicite',
    'Tomografia computadorizada, exames de sangue',
    'Analgésicos, antibióticos',
    'Recuperação satisfatória'
);

INSERT INTO CP1_HISTORICO_HOSPITAL_CLIENTE (
    CLIENTE_ID,
    DATA_REGISTRO,
    HISTORICO_MEDICO,
    EXAMES_REALIZADOS,
    MEDICAMENTOS_PRESCRITOS,
    OBSERVACOES
) VALUES (
    4,
    TO_DATE('2023-01-15', 'YYYY-MM-DD'),
    'Fratura de tornozelo',
    'Raio-X, ressonância magnética',
    'Analgésicos, anti-inflamatórios',
    'Cliente em reabilitação fisioterapêutica'
);

INSERT INTO CP1_HISTORICO_HOSPITAL_CLIENTE (
    CLIENTE_ID,
    DATA_REGISTRO,
    HISTORICO_MEDICO,
    EXAMES_REALIZADOS,
    MEDICAMENTOS_PRESCRITOS,
    OBSERVACOES
) VALUES (
    5,
    TO_DATE('2023-09-30', 'YYYY-MM-DD'),
    'Infarto agudo do miocárdio',
    'Eletrocardiograma, angiografia coronariana',
    'Antiagregantes plaquetários, estatinas',
    'Cliente em monitoramento cardíaco regular'
);

SELECT
    *
FROM
    CP1_CLIENTE;

SELECT
    C.NOME,
    CO.NOME
FROM
    CP1_CLIENTE  C
    JOIN CP1_CONVENIO CO
    ON C.CONVENIO_ID = CO.ID;
CREATE TABLE PERSON
(
    id           SERIAL PRIMARY KEY NOT NULL,
    firstName    CHARACTER VARYING,
    lastName     CHARACTER VARYING,
    age          INTEGER,
    nationalCode CHARACTER VARYING,
    deletedDate  INTEGER
);

CREATE TABLE accountType
(
    id    SERIAL PRIMARY KEY NOT NULL,
    type  CHARACTER VARYING  NOT NULL,
    value INTEGER            NOT NULL
);

CREATE TABLE ACCOUNT
(
    id            SERIAL PRIMARY KEY NOT NULL,
    accountNO     CHARACTER VARYING  NOT NULL UNIQUE,
    password      CHARACTER VARYING  NOT NULL,
    balance       DOUBLE PRECISION DEFAULT 50000,
    personId      INTEGER            NOT NULL REFERENCES PERSON (id),
    accountTypeId INTEGER            NOT NULL REFERENCES accountType (id)
);

CREATE TABLE transactionStatus
(
    id     SERIAL PRIMARY KEY NOT NULL,
    status CHARACTER VARYING  NOT NULL,
    value  INTEGER            NOT NULL
);

CREATE TABLE transactionType
(
    id    SERIAL PRIMARY KEY NOT NULL,
    type  CHARACTER VARYING  NOT NULL,
    value INTEGER            NOT NULL
);

CREATE TABLE transaction
(
    id                  SERIAL PRIMARY KEY NOT NULL,
    amount              DOUBLE PRECISION,
    createdDate         timestamp          not null,
    accountId           INTEGER            NOT NULL REFERENCES ACCOUNT (id),
    transactionStatusId INTEGER            NOT NULL REFERENCES transactionStatus (id),
    transactionTypeId   INTEGER            NOT NULL REFERENCES transactionType (id)

);

CREATE TABLE deposit
(
    id                  SERIAL PRIMARY KEY NOT NULL,
    amount              DOUBLE PRECISION,
    createdDate         timestamp          not null,
    accountId           INTEGER            NOT NULL REFERENCES ACCOUNT (id),
    transactionStatusId INTEGER            NOT NULL REFERENCES transactionStatus (id),
    transactionTypeId   INTEGER            NOT NULL REFERENCES transactionType (id)

);

CREATE TABLE withdraw
(
    id                  SERIAL PRIMARY KEY NOT NULL,
    amount              DOUBLE PRECISION,
    createdDate         timestamp          not null,
    accountId           INTEGER            NOT NULL REFERENCES ACCOUNT (id),
    transactionStatusId INTEGER            NOT NULL REFERENCES transactionStatus (id),
    transactionTypeId   INTEGER            NOT NULL REFERENCES transactionType (id)

);

INSERT INTO accountType (type, value) values ('Current', 1);
INSERT INTO accountType (type, value) values ('Savings', 2);
INSERT INTO accountType (type, value) values ('Salary', 3);

SELECT * FROM accountType;

INSERT INTO transactionType (type, value) VALUES ('Transfer', 0);
INSERT INTO transactionType (type, value) VALUES ('Deposit', 1);
INSERT INTO transactionType (type, value) VALUES ('Withdraw', -1);

SELECT * FROM transactionType;

INSERT INTO transactionStatus (status, value) VALUES ('COMPLETED', 1);
INSERT INTO transactionStatus (status, value) VALUES ('IN PROGRESS', 2);
INSERT INTO transactionStatus (status, value) VALUES ('FAILED', 3);
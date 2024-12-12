#!/bin/bash
set -e

# Create data-base-1 and seed data
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE "database1";
\c "database1"
    CREATE TABLE users
    (
        id       VARCHAR(100) PRIMARY KEY,
        name     VARCHAR(100)       NOT NULL,
        username VARCHAR(50) UNIQUE NOT NULL,
        surname  VARCHAR(100)       NOT NULL
    );
    INSERT INTO users (id , name, username, surname)
    VALUES
        ('example-user-id-1', 'John', 'jdoe', 'Doe'),
        ('example-user-id-2', 'Jane', 'jane_smith', 'Smith');
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE "database2";
\c "database2"
    CREATE TABLE user_table
    (
        ldap_login VARCHAR(100) PRIMARY KEY,
        name       VARCHAR(255) NOT NULL,
        surname    VARCHAR(255) NOT NULL
    );
    INSERT INTO employees (ldap_login, name, surname)
    VALUES ('example-ldap_login-1', 'Alice Johnson', 'Manager'),
           ('example-ldap_login-2', 'Bob Brown', 'Developer');
EOSQL

CREATE TABLE user_table
(
    ldap_login VARCHAR(100) PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL
);
INSERT INTO employees (ldap_login, name, surname)
VALUES ('example-ldap_login-1', 'Alice Johnson', 'Manager'),
       ('example-ldap_login-2', 'Bob Brown', 'Developer');
CREATE TABLE users
(
    id       VARCHAR(100) NOT NULL PRIMARY KEY,
    name     VARCHAR(100)       NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    surname  VARCHAR(100)       NOT NULL
);

INSERT INTO users (id, name, username, surname)
VALUES ('example-user-id-1', 'John', 'jdoe', 'Doe'),
       ('example-user-id-2', 'Jane', 'jane_smith', 'Smith');
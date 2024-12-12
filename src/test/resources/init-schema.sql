CREATE TABLE users
(
    user_id       VARCHAR(100) NOT NULL PRIMARY KEY,
    login     VARCHAR(100)       NOT NULL,
    first_name VARCHAR(50) UNIQUE NOT NULL,
    last_name  VARCHAR(100)       NOT NULL
);
INSERT INTO users (user_id, login, first_name, last_name)
VALUES ('example-user-id-1', 'John', 'jdoe', 'Doe'),
       ('example-user-id-2', 'Jane', 'jane_smith', 'Smith');
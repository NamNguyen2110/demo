CREATE TABLE users
(
    id     int NOT NULL AUTO_INCREMENT,
    username   varchar(225),
    created_at timestamp,
    updated_at timestamp,
    created_by timestamp,
    updated_by timestamp,
    PRIMARY KEY (ID)
);
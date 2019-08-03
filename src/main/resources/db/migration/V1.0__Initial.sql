CREATE SEQUENCE users_id_seq;
CREATE TABLE users (
    Id bigint NOT NULL DEFAULT NEXTVAL('users_id_seq'),
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id)
);
ALTER  SEQUENCE users_id_seq OWNED BY users.id;

CREATE SEQUENCE seats_id_seq;
CREATE TABLE seats (
    Id bigint NOT NULL DEFAULT NEXTVAL('seats_id_seq'),
    price DECIMAL NOT NULL,
    availability BOOLEAN NOT NULL,
    PRIMARY KEY (Id)
);
ALTER  SEQUENCE seats_id_seq OWNED BY seats.id;

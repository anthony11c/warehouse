CREATE TABLE article(
    id serial NOT NULL UNIQUE PRIMARY KEY,
    price DECIMAL(5,2) NOT NULL
);

CREATE TABLE action(
    id serial NOT NULL PRIMARY KEY,
    date_start VARCHAR(30) NOT NULL,
    id_article serial NOT NULL UNIQUE,
    FOREIGN KEY (id_article) REFERENCES article(id)
);

CREATE TABLE part(
    id UUID NOT NULL PRIMARY KEY,
    date VARCHAR(20) NOT NULL,
    articleId serial NOT NULL UNIQUE,
    FOREIGN KEY (articleId) REFERENCES article(id)
);

CREATE TABLE car(
    id serial NOT NULL PRIMARY KEY,
    nameCar VARCHAR(30) NOT NULL,
    idPart UUID NOT NULL,
    FOREIGN KEY (idPart) REFERENCES part(id)
);

CREATE TABLE brand(
    id serial NOT NULL PRIMARY KEY,
    nameBrand VARCHAR(30) NOT NULL,
    idCar serial NOT NULL,
    FOREIGN KEY (idCar) REFERENCES  car(id)
);
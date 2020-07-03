CREATE TABLE brand(
    id serial NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE car(
    id serial NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    idBrand serial NOT NULL,
    FOREIGN KEY (idBrand) REFERENCES brand(id)
);

CREATE TABLE part(
    id serial NOT NULL PRIMARY KEY,
    serialNumber VARCHAR(15) NOT NULL,
    idCar serial NOT NULL,
    idArticle serial NOT NULL UNIQUE,
    FOREIGN KEY (idCar) REFERENCES car(id)
);

CREATE TABLE article(
    id serial NOT NULL UNIQUE PRIMARY KEY,
    price DECIMAL(7,2) NOT NULL
);

CREATE TABLE action(
    id serial NOT NULL PRIMARY KEY,
    date_start VARCHAR(30) NOT NULL,
    id_article serial NOT NULL UNIQUE,
    FOREIGN KEY (id_article) REFERENCES article(id)
);
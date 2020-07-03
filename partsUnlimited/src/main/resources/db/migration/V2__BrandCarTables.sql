CREATE TABLE car(
    id INT NOT NULL PRIMARY KEY,
    nameCar VARCHAR(30) NOT NULL,
    idPart UUID NOT NULL,
    FOREIGN KEY (idPart) REFERENCES part(id)
);

CREATE TABLE brand(
    id UUID NOT NULL PRIMARY KEY,
    nameBrand VARCHAR(30) NOT NULL,
    idCar INT NOT NULL,
    FOREIGN KEY (idCar) REFERENCES  car(id)
);

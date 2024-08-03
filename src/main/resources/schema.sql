CREATE TABLE IF NOT EXISTS Mascota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fecha_Nac DATE,
    raza VARCHAR(50),
    peso DOUBLE,
    has_chip BOOLEAN,
    url_foto VARCHAR(100)
);

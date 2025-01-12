CREATE TABLE usuarios(
id bigint NOT NULL AUTO_INCREMENT,
userNames VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
idProfile bigint NOT NULL,
username VARCHAR(100) NOT NULL,
primary key(id)
);
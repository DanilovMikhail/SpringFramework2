SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  description TEXT NOT NULL,
  cost decimal(19,2) NOT NULL,
  path_image tinytext NOT null,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO users (username,password,first_name,last_name,email)
VALUES
('admin','$2a$10$CGamJWPYokRss2FX6WcBJOgFIDKyUoCYnrGtepfVQyDSTdngSxrzK','admin','admin','admin@mail.ru');

SET FOREIGN_KEY_CHECKS = 1;
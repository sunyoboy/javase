CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';
GRANT INSERT, DELETE, UPDATE, SELECT ON *.* TO 'user'@'localhost';
OR
GRANT ALL ON *.* TO 'user'@'localhost';
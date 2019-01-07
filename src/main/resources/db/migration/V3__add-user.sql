CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255),reg_date DATE, upd_date DATE);

INSERT INTO users (
username,
encoded_password,
reg_date,
upd_date
) 
VALUES (
'user1',
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user2', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user3', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user4', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user5', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user6', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

INSERT INTO users (
username, 
encoded_password,
reg_date,
upd_date
) VALUES (
'user7', 
'$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

ALTER TABLE customers ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';

ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;
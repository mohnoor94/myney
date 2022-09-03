CREATE TABLE
  accounts (
    id char(36) NOT NULL,
    name varchar(255) NOT NULL,
    balance decimal(10, 0) NOT NULL DEFAULT '0',
    currency varchar(5) NOT NULL DEFAULT 'USD',
    created_at datetime NOT NULL,
    PRIMARY KEY (id)
  );


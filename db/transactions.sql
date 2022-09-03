CREATE TABLE
  transactions (
    id char(36) NOT NULL,
    senderAccountId char(36) NOT NULL,
    receiverAccountId char(36) NOT NULL,
    amount decimal(10, 0) NOT NULL DEFAULT '0',
    currency varchar(255) NOT NULL DEFAULT 'USD',
    created_at datetime NOT NULL,
    PRIMARY KEY (id)
  );
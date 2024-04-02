CREATE TABLE IF NOT EXISTS transactions(
    uuid VARCHAR(35) NOT NULL PRIMARY KEY,
    origin_id VARCHAR(35) NOT NULL,
    destination_id VARCHAR(35) NOT NULL,
    amount DECIMAL(10,2) NOT NULL DEFAULT 0.0,
    status VARCHAR(10) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (origin_id) REFERENCES users_accounts(uuid),
    FOREIGN KEY (destination_id) REFERENCES users_accounts(uuid)
);
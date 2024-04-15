ALTER TABLE roles
    ADD deleted BIT(1) NULL;

ALTER TABLE roles
    MODIFY deleted BIT (1) NOT NULL;

ALTER TABLE token
    ADD deleted BIT(1) NULL;

ALTER TABLE token
    MODIFY deleted BIT (1) NOT NULL;

ALTER TABLE user
    ADD deleted BIT(1) NULL;

ALTER TABLE user
    MODIFY deleted BIT (1) NOT NULL;

ALTER TABLE roles
DROP
COLUMN is_deleted;

ALTER TABLE token
DROP
COLUMN is_deleted;

ALTER TABLE user
DROP
COLUMN is_deleted;
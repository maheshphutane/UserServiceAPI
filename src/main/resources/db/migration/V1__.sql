CREATE TABLE roles
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) NOT NULL,
    role_id    BIGINT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE token
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) NOT NULL,
    value      VARCHAR(255) NULL,
    user_id    BIGINT NULL,
    expiry_at  datetime NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

CREATE TABLE user
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime NULL,
    updated_at        datetime NULL,
    is_deleted        BIT(1) NOT NULL,
    email             VARCHAR(255) NULL,
    username          VARCHAR(255) NULL,
    hashed_pass       VARCHAR(255) NULL,
    is_email_verified BIT(1) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_roles_list
(
    user_id       BIGINT NOT NULL,
    roles_list_id BIGINT NOT NULL
);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user_roles_list
    ADD CONSTRAINT fk_userollis_on_roles FOREIGN KEY (roles_list_id) REFERENCES roles (id);

ALTER TABLE user_roles_list
    ADD CONSTRAINT fk_userollis_on_user FOREIGN KEY (user_id) REFERENCES user (id);
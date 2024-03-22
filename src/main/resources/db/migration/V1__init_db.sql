CREATE TABLE category
(
    id   BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_mentors
(
    id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentors PRIMARY KEY (id)
);

CREATE TABLE jt_students
(
    id BIGINT NOT NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_jt_students PRIMARY KEY (id)
);

CREATE TABLE jt_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE msc_mentors
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_mentors PRIMARY KEY (id)
);

CREATE TABLE msc_students
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_msc_students PRIMARY KEY (id)
);

CREATE TABLE msc_tas
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email_id   VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_msc_tas PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE orders_products
(
    orders_id   BINARY(16) NOT NULL,
    products_id BINARY(16) NOT NULL
);

CREATE TABLE prices
(
    id       BINARY(16) NOT NULL,
    currency VARCHAR(255) NULL,
    value DOUBLE NULL,
    CONSTRAINT pk_prices PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    category_id   BINARY(16) NOT NULL,
    price_id      BINARY(16) NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id       BIGINT NOT NULL,
    dtype    VARCHAR(31) NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE tbc_mentors
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_mentors PRIMARY KEY (id)
);

CREATE TABLE tbc_students
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_students PRIMARY KEY (id)
);

CREATE TABLE tbc_tas
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email_id   VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_tas PRIMARY KEY (id)
);

CREATE TABLE tbc_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_users PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FK_JT_MENTORS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_students
    ADD CONSTRAINT FK_JT_STUDENTS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES prices (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_order FOREIGN KEY (orders_id) REFERENCES orders (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_product FOREIGN KEY (products_id) REFERENCES product (id);
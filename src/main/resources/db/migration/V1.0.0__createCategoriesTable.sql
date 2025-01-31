CREATE TABLE IF NOT EXISTS category(
    id BIGINT NOT NULL,
    name VARCHAR(50),
    category_id BIGINT,
    PRIMARY KEY(id),
    CONSTRAINT fk_category FOREIGN KEY(category_id) REFERENCES category(id)
)
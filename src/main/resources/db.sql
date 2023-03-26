CREATE TABLE products
(
    id    int NOT NULL AUTO_INCREMENT,
    name  VARCHAR(100),
    price NUMERIC,
    PRIMARY KEY (id)
);

CREATE TABLE carts
(
    id    int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE product_cart
(
    product_id int NOT NULL,
    cart_id    int NOT NULL,
    PRIMARY KEY (cart_id, product_id),
    FOREIGN KEY (cart_id) REFERENCES carts (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
CREATE TABLE IF NOT EXISTS CUSTOMERS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age INT NOT NULL CHECK (age >= 0),
    phone_number VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS ORDERS (
    id SERIAL PRIMARY KEY,
    date DATE,
    customer_id INT REFERENCES CUSTOMERS(id),
    product_name VARCHAR(100),
    amount INT
);
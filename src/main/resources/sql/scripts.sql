CREATE TABLE IF NOT EXISTS vegetables (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    vegname VARCHAR(50) NOT NULL,
    quantity NUMERIC(10,2),
    user_name VARCHAR(50)
);

CREATE TABLE public.fruits (
    id SERIAL PRIMARY KEY,
    fruitname VARCHAR(100) NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    user_name VARCHAR(100) NOT NULL
);

CREATE TABLE snacks (
    snack_id SERIAL PRIMARY KEY,
    snack_name VARCHAR(100) NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    user_name VARCHAR(100) NOT NULL
);

CREATE TABLE clothes (
    cloth_id SERIAL PRIMARY KEY,
    cloth_name VARCHAR(100) NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    user_name VARCHAR(100) NOT NULL
);

CREATE TABLE cars (
    id SERIAL PRIMARY KEY, 
    carname VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    color VARCHAR(50),
    user_name VARCHAR(100) NOT NULL
);

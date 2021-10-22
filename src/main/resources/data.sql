DROP TABLE IF EXISTS recipes;

CREATE TABLE recipes
(
    id          INT PRIMARY KEY,
    title       VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL
);

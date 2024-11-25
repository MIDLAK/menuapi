
CREATE TABLE dish (
	dish_id  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	name	 VARCHAR(64) NOT NULL,
	price    numeric(8,2) NOT NULL,
	isActive BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE ingredient_type (
    ingredient_type_id VARCHAR(32) PRIMARY KEY,
    name	           VARCHAR(64) NOT NULL
);

CREATE TABLE ingredient (
    ingredient_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name	      VARCHAR(64) NOT NULL,
    price         numeric(8,2) NOT NULL,
    type          VARCHAR(32) REFERENCES ingredient_type(ingredient_type_id)
);

-- разбивочная
CREATE TABLE dish_ingredient (
    dish_id       UUID REFERENCES dish(dish_id),
    ingredient_id UUID REFERENCES ingredient(ingredient_id),
    PRIMARY KEY (dish_id, ingredient_id)
);

-- тестовые начальные данные
INSERT INTO dish(name, price)
VALUES ('шаурма деревенская', 255.12),
	  ('шаурма микс', 340.25),
	  ('сырный суп', 100.00);

INSERT INTO ingredient_type(ingredient_type_id, name)
VALUES ('ALLERGENIC', 'Алергенный'),
      ('HYPOALLERGENIC', 'Гипоаллергенный');

INSERT INTO ingredient(name, price, type)
VALUES ('сыр', 5.5, 'ALLERGENIC'),
	  ('лаваш', 10.25, 'HYPOALLERGENIC');

INSERT INTO dish_ingredient(dish_id, ingredient_id)
VALUES ((SELECT dish_id FROM dish WHERE name='шаурма деревенская'), (SELECT ingredient_id FROM ingredient WHERE name='сыр')),
       ((SELECT dish_id FROM dish WHERE name='шаурма деревенская'), (SELECT ingredient_id FROM ingredient WHERE name='лаваш')),
       ((SELECT dish_id FROM dish WHERE name='шаурма микс'), (SELECT ingredient_id FROM ingredient WHERE name='сыр')),
       ((SELECT dish_id FROM dish WHERE name='шаурма микс'), (SELECT ingredient_id FROM ingredient WHERE name='лаваш')),
       ((SELECT dish_id FROM dish WHERE name='сырный суп'), (SELECT ingredient_id FROM ingredient WHERE name='сыр'));

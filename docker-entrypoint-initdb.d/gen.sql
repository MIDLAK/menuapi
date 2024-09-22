
CREATE TABLE dish (
	dish_id	    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	name		VARCHAR(64) NOT NULL
);

-- тестовые начальные данные
INSERT INTO dish(name)
VALUES ('шаурма деревенская'),
	  ('шаурма микс'),
	  ('сырный суп');
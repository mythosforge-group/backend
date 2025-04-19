INSERT INTO users (username, password, email) VALUES
  ('gandalf', 'senha123', 'gandalf@middleearth.com'),
  ('frodo', 'precious456', 'frodo@shire.com');

INSERT INTO campaigns (title, description, owner_id) VALUES
  ('A Sociedade do Anel', 'A jornada começa em Valfenda', 1),
  ('A Queda de Númenor', 'O destino dos homens se aproxima', 2);


INSERT INTO characters (name, background, campaign_id) VALUES
  ('Aragorn', 'Ranger do norte, herdeiro de Isildur', 1),
  ('Elrond', 'Lorde de Valfenda', 1),
  ('Sauron', 'O Senhor do Escuro', 2);
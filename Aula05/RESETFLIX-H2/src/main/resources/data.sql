INSERT INTO atores (id, nome) VALUES
  (1, 'Leonardo DiCaprio'),
  (2, 'Matthew McConaughey'),
  (3, 'Jamie Foxx');

 INSERT INTO diretores (id, nome) VALUES
    (1, 'Martin Scorcese'),
    (2, 'Quentin Tarantino'),
    (3, 'Christopher Nolan');

 INSERT INTO filmes (id, genero, nome, diretor_id) VALUES
    (1, 'FICCAO_CIENTIFICA', 'Interestelar', 3),
    (2, 'ACAO', 'Django Livre', 2),
    (3, 'SUSPENSE', 'O Regresso', 3);

  INSERT INTO FILMES_ATORES (FILMES_ID, ATORES_ID) VALUES
  (1, 2),
  (2, 3),
  (3, 1),
 (2, 1);


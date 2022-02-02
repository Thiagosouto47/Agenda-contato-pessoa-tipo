INSERT INTO pessoa(id, nome, cpf, rg, sexo) VALUES
(1, 'Thiago Antonio', '042.588.112-11', '311914-11','M'),
(2, 'Lucas Silva', '006.268.202-12', '562414-08','M'),
(3, 'Eliane Nunes', '043.888.315-20', '511218-11','F'),
(4, 'Marcos racer', '056.688.117-05', '313414-51','M')
;
INSERT INTO contato(id, descr_contato, pessoa_id, tipo_id) VALUES
(1, 'thiagocsouto@gmail.com', 1, 1),
(2, '1211', 2, 2),
(3, '98881-1211', 3, 3),
(4, '@Marco_racer', 4, 4)
;
INSERT INTO tipo(id, tipo_contato) VALUES
(1, 'Email'),
(2, 'Tefelone Fixo'),
(3, 'Telefone celular'),
(4, 'Rede social')
;

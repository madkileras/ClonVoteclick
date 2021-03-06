INSERT INTO public.institutions(id, name) VALUES (1,'Tricel Feusach' );
INSERT INTO public.institutions(id, name) VALUES (2,'Tricel CEII' );
INSERT INTO public.institutions(id, name) VALUES (3,'Gobierno' );
INSERT INTO public.institutions(id, name) VALUES (4,'CEII 2017' );
INSERT INTO public.institutions(id, name) VALUES (5,'DIINF');

INSERT INTO public.voters(id, name, rut) VALUES (1, 'Nicolas Paredes Angulo', '18702792-6');
INSERT INTO public.voters(id, name, rut) VALUES (2, 'Natalia Guzman', '20789987-9');
INSERT INTO public.voters(id, name, rut) VALUES (3, 'Enrique Aviles Moroso', '19668754-1');
INSERT INTO public.voters(id, name, rut) VALUES (4, 'Cristian Sepulveda Cabas', '17502537-9');
INSERT INTO public.voters(id, name, rut) VALUES (5, 'Camilo Ayala Lopez', '11841742-0');
INSERT INTO public.voters(id, name, rut) VALUES (6, 'Marcela Gatica Zamorano', '13987741-5');

INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (1, 2);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (1, 4);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (2, 4);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (2, 2);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (3, 1);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (3, 2);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (4, 3);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (5, 3);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (1, 3);
INSERT INTO public.voter_vinculated(voter_id, institution_id) VALUES (6, 3);

INSERT INTO public.votations(id, title, votation_type, institution_id,init_date,end_date) VALUES (1, 'Votacion centro alumnos informatica 2018', 'por bloque',2,'11/12/2017 00:00:00','11/12/2017 00:00:00');
INSERT INTO public.votations(id, title, votation_type, institution_id,init_date,end_date) VALUES (2, 'Votacion paseo fin de año', 'preferencial',4,'11/12/2017 00:00:00','11/12/2017 00:00:00');
INSERT INTO public.votations(id, title, votation_type, institution_id,init_date,end_date) VALUES (3, 'Votacion delegado de genero CEII 2017', 'alternativa',3,'11/12/2017 00:00:00','11/12/2017 00:00:00');
INSERT INTO public.votations(id, title, votation_type, institution_id,init_date,end_date) VALUES (4, 'Votacion nuevo integrante de cultura CEII', 'por bloque', 2,'11/12/2017 00:00:00','11/12/2017 00:00:00');
INSERT INTO public.votations(id, title, votation_type, institution_id,init_date,end_date) VALUES (5, 'Votacion gerente tingeso', 'por bloque', 1,'11/12/2017 00:00:00','11/12/2017 00:00:00');

INSERT INTO public.options(option_id, text, votation_id) VALUES (1, 'lista glinux', 1);
INSERT INTO public.options(option_id, text, votation_id) VALUES (2, 'paralelista', 1);
INSERT INTO public.options(option_id, text, votation_id) VALUES (3, 'Cabaña cerca de playa', 2);
INSERT INTO public.options(option_id, text, votation_id) VALUES (11, 'Quincho por fin de semana', 2);
INSERT INTO public.options(option_id, text, votation_id) VALUES (4, 'Diego Mellis', 4);
INSERT INTO public.options(option_id, text, votation_id) VALUES (5, 'Luis Migryk', 4);
INSERT INTO public.options(option_id, text, votation_id) VALUES (6, 'Mario Alvarez', 5);
INSERT INTO public.options(option_id, text, votation_id) VALUES (7, 'Planta', 5);
INSERT INTO public.options(option_id, text, votation_id) VALUES (8, 'Victor Maripangui', 3);
INSERT INTO public.options(option_id, text, votation_id) VALUES (9, 'Cristobal Donoso', 3);
INSERT INTO public.options(option_id, text, votation_id) VALUES (10, 'Feñita', 3);

INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (1, 5);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (2, 4);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (3, 3);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (4, 2);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (5, 1);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (3, 2);
INSERT INTO public.votation_voter(votation_id, voter_id) VALUES (1, 1);


INSERT INTO public.votes(vote_id, votations_id) VALUES (1, 1);
INSERT INTO public.votes(vote_id, votations_id) VALUES (2, 1);
INSERT INTO public.votes(vote_id, votations_id) VALUES (3, 4);
INSERT INTO public.votes(vote_id, votations_id) VALUES (4, 3);
INSERT INTO public.votes(vote_id, votations_id) VALUES (5, 5);


INSERT INTO movie(id,name,genre,release_year,director)
VALUES (1,'Movie 1','HORROR','2000','Best Director'),
       (2,'Movie 2','COMEDY','2000','Best Director'),
       (3,'Movie 3','ACTION','2000','Best Director'),
       (4,'Movie 4','ROMANCE','2000','Best Director');

INSERT INTO actor(id,name,birth_date)
VALUES (1,'Actor 1','2000-01-01'),
       (2,'Actor 2','1999-01-01'),
       (3,'Actor 3','1998-01-01'),
       (4,'Actor 4','1997-01-01');

INSERT INTO movie_actor(movie_id,actor_id)
VALUES (3,2),
       (3,3)
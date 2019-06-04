INSERT INTO auth_user_group VALUES (null,'user','user');
INSERT INTO auth_user_group VALUES (null,'admin','user1');

INSERT INTO skill VALUES (1,'Java',8);
INSERT INTO skill VALUES (2,'Spring Boot',2);

INSERT INTO user VALUES (1,'Software Engineer','Software Engineer',1,'password','2019-05-06',4,'user');
INSERT INTO user VALUES (2,'Sr Software Engineer','Sr Software Engineer',1,'password','2019-05-06',6,'user1');

INSERT INTO user_skill VALUES (1,NULL,4,5,'2019-05-06',1,1);
INSERT INTO user_skill VALUES (2,NULL,6,4,'2019-05-05',1,2);
INSERT INTO user_skill VALUES (3,NULL,9,9,'2019-05-04',2,2);
INSERT INTO user_skill VALUES (4,'Production used is zero',2,5,'2019-05-03',2,1);

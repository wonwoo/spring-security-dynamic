insert  into `resources`(`ID`,`NAME`) values (1,'/user');
insert  into `resources`(`ID`,`NAME`) values (2,'/admin');
insert  into `resources`(`ID`,`NAME`) values (3,'/home');

insert  into `role`(`ROLE_ID`,`ROLE_NAME`) values (1,'ROLE_ADMIN');
insert  into `role`(`ROLE_ID`,`ROLE_NAME`) values (2,'ROLE_USER');

insert  into `role_resource`(`ID`,`ROLE_ID`,`RESOURCE_ID`) values (1,1,2);
insert  into `role_resource`(`ID`,`ROLE_ID`,`RESOURCE_ID`) values (2,2,1);
insert  into `role_resource`(`ID`,`ROLE_ID`,`RESOURCE_ID`) values (3,1,3);
insert  into `role_resource`(`ID`,`ROLE_ID`,`RESOURCE_ID`) values (7,2,3);
--insert  into `role_resource`(`ID`,`ROLE_ID`,`RESOURCE_ID`) values (8,1,1);

--password : wonwoo
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (1,'wonwoo','$2a$10$qU0G1mvP3m0dKeFXhIVmnOwnshJw99tIPOI78sCyB8b1gHUeqN7YO');
--password : kevin
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (2,'kevin','$2a$10$02QvKDF8I9cz8aaYayGJ/ufssT8EhCrk5oQ9lggva4rw28/sBSph6');
--password : denied
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (3,'denied','$2a$10$LNRVEvhgrqmf.xZQsXqAtOwPUuEeryns.J3q8PUSa7H7fclkN2/xO');

insert  into `authorities`(`ID`,`USER_ID`,`USER_ROLE`) values (1,1,1);
insert  into `authorities`(`ID`,`USER_ID`,`USER_ROLE`) values (2,2,2);
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


insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (1,'wonwoo','wonwoo');
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (2,'kevin','kevin');
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (3,'denied','denied');

insert  into `authorities`(`ID`,`USER_ID`,`USER_ROLE`) values (1,1,1);
insert  into `authorities`(`ID`,`USER_ID`,`USER_ROLE`) values (2,2,2);
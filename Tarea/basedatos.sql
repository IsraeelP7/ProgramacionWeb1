
drop schema if exists `israel_fes_aragon`;


create schema  if not exists `israel_fes_aragon` default  character set utf8 collate  utf8_spanish2_ci;
USE `israel_fes_aragon`; 


CREATE TABLE  `PERSONA`(
`nombre_usuario` text not null,
`carrera` text not null,
`no_cuenta` int(10) not null,
`direccion` text not null,
`telefono` varchar (10) not null,
`email` text not null,
`password` varchar (10) not null,
`fecha_registro` datetime not null default current_timestamp,
`permisos` int (11) not null default '2'
)engine=Innodb default charset=utf8;

insert into `PERSONA`(`nombre_usuario`, `carrera`,`no_cuenta`,`direccion`,`telefono`,`email`,`password`,`fecha_registro`,`permisos`)values
('Aaron Velasco','ico','413112576','gloria 15','561267500','elaaron@gmail.com','123456','2020-05-12 17:40:00',2),
('Israel Prieto','ico','319023718','calle 45','5627519983','israel18223@gmail.com','5627519983','2022-05-12 21:45:00',2);


alter table `persona`
  add primary key (`no_cuenta`);
commit;



SELECT * FROM PERSONA;


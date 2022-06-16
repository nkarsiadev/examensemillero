/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     16/6/2022 9:51:56                            */
/*==============================================================*/


drop table if exists ROLES;

drop table if exists USUARIOS;

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
create table ROLES
(
   ID_ROL               int not null,
   NAME_ROL             varchar(50),
   STATUS_ROL           varchar(50),
   primary key (ID_ROL)
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS
(
   ID_USUARIO           int not null,
   NAME_USUARIO         varchar(50),
   LAST_NAME_USUARIO    varchar(50),
   EMAIL_USUARIO        varchar(50),
   PASSWORD_USUARIO     varchar(150),
   EDAD_USUARIO         int,
   STATUS               varchar(50),
   primary key (ID_USUARIO)
);


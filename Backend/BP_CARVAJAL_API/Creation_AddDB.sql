/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     16/6/2022 9:38:12                            */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"USER"') and o.name = 'FK_USER_RELATIONS_ROL')
alter table "USER"
   drop constraint FK_USER_RELATIONS_ROL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ROL')
            and   type = 'U')
   drop table ROL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"USER"')
            and   name  = 'RELATIONSHIP_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index "USER".RELATIONSHIP_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"USER"')
            and   type = 'U')
   drop table "USER"
go

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL (
   ID_ROL               int                  not null,
   NAME_ROL             varchar(50)          null,
   STATUS_ROL           varchar(50)          null,
   constraint PK_ROL primary key nonclustered (ID_ROL)
)
go

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table "USER" (
   USER_ID              int                  not null,
   ID_ROL               int                  not null,
   USER_NAME            varchar(100)         null,
   USER_LAST_NAME       varchar(100)         null,
   USER_EMAIL           varchar(100)         null,
   USER_PASSWORD        varchar(500)         null,
   USER_AGE             int                  null,
   USER_STATUS          varchar(10)          null,
   constraint PK_USER primary key nonclustered (USER_ID)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on "USER" (
ID_ROL ASC
)
go

alter table "USER"
   add constraint FK_USER_RELATIONS_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
go



select * from "USER";

insert into "USER" (USER_ID,ID_ROL,USER_NAME,USER_LAST_NAME,USER_EMAIL,USER_PASSWORD,USER_AGE,USER_STATUS) 
VALUES (1,1,'Abigail','Carvajal','agcarvajal@espe.edu.ec','123456789',25,'HABILITADO');
insert into "USER" (USER_ID,ID_ROL,USER_NAME,USER_LAST_NAME,USER_EMAIL,USER_PASSWORD,USER_AGE,USER_STATUS) 
VALUES (2,2,'Nicole','Carvajal','ncarvajal244@puce.edu.ec','123456789',25,'HABILITADO');

insert into ROL (ID_ROL,NAME_ROL,STATUS_ROL) VALUES (1,'Administrador','ACTIVO');
insert into ROL (ID_ROL,NAME_ROL,STATUS_ROL) VALUES (2,'Gerente','ACTIVO');
insert into ROL (ID_ROL,NAME_ROL,STATUS_ROL) VALUES (3,'Administrativo','ACTIVO');

select user_name from "USER" where USER_EMAIL ='agcarvajal@espe.edu.ec' and USER_PASSWORD = '1234567810';
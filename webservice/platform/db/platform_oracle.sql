prompt PL/SQL Developer import file
prompt Created on 2016年12月26日 by leoja
set feedback off
set define off
prompt Dropping SYSTEM_APK_VERSION...
drop table SYSTEM_APK_VERSION cascade constraints;
prompt Dropping SYSTEM_DICT...
drop table SYSTEM_DICT cascade constraints;
prompt Dropping SYSTEM_FILE...
drop table SYSTEM_FILE cascade constraints;
prompt Dropping SYSTEM_LOGS...
drop table SYSTEM_LOGS cascade constraints;
prompt Dropping SYSTEM_MENU...
drop table SYSTEM_MENU cascade constraints;
prompt Dropping SYSTEM_MESSAGE...
drop table SYSTEM_MESSAGE cascade constraints;
prompt Dropping SYSTEM_ORG...
drop table SYSTEM_ORG cascade constraints;
prompt Dropping SYSTEM_RESOURCE...
drop table SYSTEM_RESOURCE cascade constraints;
prompt Dropping SYSTEM_ROLE...
drop table SYSTEM_ROLE cascade constraints;
prompt Dropping SYSTEM_ROLE_MENU...
drop table SYSTEM_ROLE_MENU cascade constraints;
prompt Dropping SYSTEM_ROLE_RESOURCE...
drop table SYSTEM_ROLE_RESOURCE cascade constraints;
prompt Dropping SYSTEM_ROLE_USER...
drop table SYSTEM_ROLE_USER cascade constraints;
prompt Dropping SYSTEM_USER...
drop table SYSTEM_USER cascade constraints;
prompt Dropping SYSTEM_USER_ORG...
drop table SYSTEM_USER_ORG cascade constraints;
prompt Creating SYSTEM_APK_VERSION...
create table SYSTEM_APK_VERSION
(
  ID          VARCHAR2(64),
  VERSION     VARCHAR2(64),
  URL         VARCHAR2(64),
  UPDATE_DATE DATE,
  VERSIONCODE NUMBER
)
;

prompt Creating SYSTEM_DICT...
create table SYSTEM_DICT
(
  ID          VARCHAR2(64),
  VALUE       VARCHAR2(64),
  NO          VARCHAR2(64) not null,
  PARENT_NO   VARCHAR2(64),
  TYPE        VARCHAR2(20),
  NOTE        VARCHAR2(640),
  CONTENT     VARCHAR2(640),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_FILE...
create table SYSTEM_FILE
(
  ID          VARCHAR2(64) not null,
  FILE_NAME   VARCHAR2(64),
  FILE_CODE   VARCHAR2(64),
  FILE_DEC    VARCHAR2(400),
  FILE_SIZE   INTEGER,
  FILE_TYPE   VARCHAR2(10),
  STATUS      VARCHAR2(6) default '105001',
  IS_DEL      CHAR(1) default '0',
  FILE_URL    VARCHAR2(200),
  CATEGORY    VARCHAR2(2),
  CREATE_TIME DATE,
  UPDATE_TIME DATE,
  CREATE_USER VARCHAR2(64),
  UPDATE_USER VARCHAR2(64)
)
;
comment on table SYSTEM_FILE
  is '保存上传的文件信息';
comment on column SYSTEM_FILE.ID
  is '唯一标识';
comment on column SYSTEM_FILE.FILE_NAME
  is '上传文件名称';
comment on column SYSTEM_FILE.FILE_CODE
  is '业务主键';
comment on column SYSTEM_FILE.FILE_DEC
  is '上传文件描述';
comment on column SYSTEM_FILE.FILE_SIZE
  is '上传文件大小';
comment on column SYSTEM_FILE.FILE_TYPE
  is '上传文件类型';
comment on column SYSTEM_FILE.STATUS
  is '状态：0，可用；1，不可用';
comment on column SYSTEM_FILE.IS_DEL
  is '是否删除：0，未删除；1，删除';
comment on column SYSTEM_FILE.FILE_URL
  is '文件存放地址';
comment on column SYSTEM_FILE.CATEGORY
  is '所属菜单类目';
comment on column SYSTEM_FILE.CREATE_TIME
  is '文件上传时间';
comment on column SYSTEM_FILE.UPDATE_TIME
  is '文件修改时间';
alter table SYSTEM_FILE
  add constraint PK_SYSTEM_FILE primary key (ID);

prompt Creating SYSTEM_LOGS...
create table SYSTEM_LOGS
(
  ID        NUMBER,
  USER_CODE VARCHAR2(64),
  LOG_TIME  DATE,
  LOG_TYPE  VARCHAR2(12),
  LOG_INFO  VARCHAR2(500),
  LOG_IP    VARCHAR2(200)
)
;
comment on table SYSTEM_LOGS
  is '系统日志表';
comment on column SYSTEM_LOGS.USER_CODE
  is '用户ID';
comment on column SYSTEM_LOGS.LOG_TIME
  is '操作时间';
comment on column SYSTEM_LOGS.LOG_TYPE
  is '日志类型';
comment on column SYSTEM_LOGS.LOG_INFO
  is '日志内容';
comment on column SYSTEM_LOGS.LOG_IP
  is 'IP地址';

prompt Creating SYSTEM_MENU...
create table SYSTEM_MENU
(
  ID          VARCHAR2(64) not null,
  NAME        VARCHAR2(60),
  URL         VARCHAR2(128),
  PARENT_ID   VARCHAR2(64),
  TYPE        VARCHAR2(12),
  PERMISSION  VARCHAR2(128),
  STATUS      VARCHAR2(12) not null,
  IMG_URL     VARCHAR2(256),
  ORDER_ID    NUMBER(8,2),
  MENU_CODE   VARCHAR2(64),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;
comment on table SYSTEM_MENU
  is '系统菜单表';
comment on column SYSTEM_MENU.ID
  is '主键';
comment on column SYSTEM_MENU.NAME
  is '菜单名称';
comment on column SYSTEM_MENU.URL
  is '菜单';
comment on column SYSTEM_MENU.PARENT_ID
  is '父节点';
comment on column SYSTEM_MENU.TYPE
  is '类型';
comment on column SYSTEM_MENU.PERMISSION
  is '权限';
comment on column SYSTEM_MENU.STATUS
  is '状态';
comment on column SYSTEM_MENU.IMG_URL
  is '图片保存路径';
comment on column SYSTEM_MENU.ORDER_ID
  is '排序序号';
comment on column SYSTEM_MENU.UPDATE_TIME
  is '修改时间';
comment on column SYSTEM_MENU.CREATE_TIME
  is '创建时间';
comment on column SYSTEM_MENU.CREATE_USER
  is '创建人';

prompt Creating SYSTEM_MESSAGE...
create table SYSTEM_MESSAGE
(
  ID           VARCHAR2(64) not null,
  TITLE        VARCHAR2(640),
  TYPE         VARCHAR2(12),
  SENDER       VARCHAR2(64),
  RECIPIENT    VARCHAR2(640),
  CONTENT      VARCHAR2(640),
  TIMES        DATE,
  MESSAGE_CODE VARCHAR2(64),
  UPDATE_TIME  DATE,
  UPDATE_USER  VARCHAR2(64),
  CREATE_TIME  DATE,
  CREATE_USER  VARCHAR2(64)
)
;
comment on column SYSTEM_MESSAGE.TITLE
  is '消息标题';
comment on column SYSTEM_MESSAGE.TYPE
  is '消息类型';
comment on column SYSTEM_MESSAGE.SENDER
  is '发送人';
comment on column SYSTEM_MESSAGE.RECIPIENT
  is '接收人';
comment on column SYSTEM_MESSAGE.CONTENT
  is '消息内容';
comment on column SYSTEM_MESSAGE.TIMES
  is '时间';
comment on column SYSTEM_MESSAGE.MESSAGE_CODE
  is '消息编码';

prompt Creating SYSTEM_ORG...
create table SYSTEM_ORG
(
  ID          VARCHAR2(64),
  ORG_CODE    VARCHAR2(64),
  ORG_NAME    VARCHAR2(64),
  PARENT_ID   VARCHAR2(64),
  DEL_FLAG    VARCHAR2(12),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_RESOURCE...
create table SYSTEM_RESOURCE
(
  ID            VARCHAR2(64) not null,
  NAME          VARCHAR2(200),
  URL           VARCHAR2(200),
  MENU_CODE     VARCHAR2(64),
  TYPE          VARCHAR2(100),
  PERMISSION    VARCHAR2(200),
  SHOW_IN_FRONT VARCHAR2(100),
  PIC_NAME      VARCHAR2(200),
  RES_CODE      VARCHAR2(64),
  RES_TYPE      VARCHAR2(12),
  UPDATE_TIME   DATE,
  UPDATE_USER   VARCHAR2(64),
  CREATE_TIME   DATE,
  CREATE_USER   VARCHAR2(64)
)
;
comment on column SYSTEM_RESOURCE.NAME
  is '权限名称';
comment on column SYSTEM_RESOURCE.MENU_CODE
  is '关联菜单';
comment on column SYSTEM_RESOURCE.TYPE
  is 'url 或者是 button';
comment on column SYSTEM_RESOURCE.PERMISSION
  is '权限字符串';
comment on column SYSTEM_RESOURCE.SHOW_IN_FRONT
  is '是否展示在前台';
comment on column SYSTEM_RESOURCE.PIC_NAME
  is '菜单图标名称（图片名称）';
comment on column SYSTEM_RESOURCE.RES_CODE
  is '资源编编码 保证命名能见名知意 知道是那些权限';
comment on column SYSTEM_RESOURCE.RES_TYPE
  is '资源类型(0为系统资源，1为业务资源)';

prompt Creating SYSTEM_ROLE...
create table SYSTEM_ROLE
(
  ID          VARCHAR2(64) not null,
  ROLE_CODE   VARCHAR2(10),
  ROLE_NAME   VARCHAR2(100) not null,
  DESCRIBE    VARCHAR2(640),
  DEL_FLAG    VARCHAR2(12),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_ROLE_MENU...
create table SYSTEM_ROLE_MENU
(
  ID          VARCHAR2(64) not null,
  MENU_CODE   VARCHAR2(64),
  ROLE_CODE   VARCHAR2(64),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_ROLE_RESOURCE...
create table SYSTEM_ROLE_RESOURCE
(
  ID          VARCHAR2(64) not null,
  STATUS      VARCHAR2(12) default 1,
  ROLE_CODE   VARCHAR2(64),
  RES_CODE    VARCHAR2(64),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;
comment on column SYSTEM_ROLE_RESOURCE.STATUS
  is '0：生效  1：无效';
comment on column SYSTEM_ROLE_RESOURCE.ROLE_CODE
  is '角色编码';
comment on column SYSTEM_ROLE_RESOURCE.RES_CODE
  is '资源编码';
comment on column SYSTEM_ROLE_RESOURCE.UPDATE_TIME
  is '修改时间';
comment on column SYSTEM_ROLE_RESOURCE.UPDATE_USER
  is '修改人';
comment on column SYSTEM_ROLE_RESOURCE.CREATE_TIME
  is '创建时间';
comment on column SYSTEM_ROLE_RESOURCE.CREATE_USER
  is '创建人';

prompt Creating SYSTEM_ROLE_USER...
create table SYSTEM_ROLE_USER
(
  ID          VARCHAR2(64) not null,
  ROLE_CODE   VARCHAR2(64),
  USER_CODE   VARCHAR2(64),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_USER...
create table SYSTEM_USER
(
  ID          VARCHAR2(64) not null,
  USER_CODE   VARCHAR2(64),
  USER_NAME   VARCHAR2(64),
  PASSWORD    VARCHAR2(64),
  DEL_FLAG    VARCHAR2(12),
  STATUS      VARCHAR2(12),
  JOB_NUM     VARCHAR2(64),
  CELL_PHONE  VARCHAR2(64),
  ICON        VARCHAR2(128),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;

prompt Creating SYSTEM_USER_ORG...
create table SYSTEM_USER_ORG
(
  ID          VARCHAR2(64) not null,
  USER_CODE   VARCHAR2(64),
  ORG_CODE    VARCHAR2(64),
  UPDATE_TIME DATE,
  UPDATE_USER VARCHAR2(64),
  CREATE_TIME DATE,
  CREATE_USER VARCHAR2(64)
)
;
comment on column SYSTEM_USER_ORG.ID
  is 'ID';
comment on column SYSTEM_USER_ORG.USER_CODE
  is '用户编码';
comment on column SYSTEM_USER_ORG.ORG_CODE
  is '部门编码';

prompt Loading SYSTEM_APK_VERSION...
prompt Table is empty
prompt Loading SYSTEM_DICT...
insert into SYSTEM_DICT (ID, VALUE, NO, PARENT_NO, TYPE, NOTE, CONTENT, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('2', '失效', '2', '1', 'filestatus', null, null, null, null, null, null);
insert into SYSTEM_DICT (ID, VALUE, NO, PARENT_NO, TYPE, NOTE, CONTENT, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('1', '可用', '1', '1', 'filestatus', null, null, null, null, null, null);
insert into SYSTEM_DICT (ID, VALUE, NO, PARENT_NO, TYPE, NOTE, CONTENT, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('F489AC0BF5E140889975E2C1BCB72FD9', '公共类别', '1', '0', 'public', null, null, to_date('02-12-2016 10:31:22', 'dd-mm-yyyy hh24:mi:ss'), null, null, null);
insert into SYSTEM_DICT (ID, VALUE, NO, PARENT_NO, TYPE, NOTE, CONTENT, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('6F8006288A434EB9A6517CACE092ACA6', '系统管理', '2', '0', 'system', null, null, null, null, null, null);
insert into SYSTEM_DICT (ID, VALUE, NO, PARENT_NO, TYPE, NOTE, CONTENT, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8A518C2E310A4B87A1A15E99B2586E3E', '业务类别', '3', '0', 'business', null, null, null, null, null, null);
commit;
prompt 5 records loaded
prompt Loading SYSTEM_FILE...
insert into SYSTEM_FILE (ID, FILE_NAME, FILE_CODE, FILE_DEC, FILE_SIZE, FILE_TYPE, STATUS, IS_DEL, FILE_URL, CATEGORY, CREATE_TIME, UPDATE_TIME, CREATE_USER, UPDATE_USER)
values ('100006', 'hosts.bat', '20161215032902', '123123', 4152, null, '2', '0', 'D:/upload/hosts.bat', null, to_date('15-12-2016 15:28:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-12-2016 15:28:54', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 'admin');
commit;
prompt 1 records loaded
prompt Loading SYSTEM_LOGS...
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000682, 'admin', to_date('21-11-2016 13:20:21', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000683, 'admin', to_date('21-11-2016 13:26:04', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000693, 'admin', to_date('22-11-2016 10:49:53', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000694, 'admin', to_date('22-11-2016 10:57:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000720, 'admin', to_date('09-12-2016 12:10:28', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000743, 'admin', to_date('12-12-2016 09:41:24', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000751, 'admin', to_date('12-12-2016 11:47:07', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000752, 'admin', to_date('12-12-2016 11:48:53', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000753, 'admin', to_date('12-12-2016 11:53:19', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000754, 'admin', to_date('12-12-2016 11:58:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000755, 'admin', to_date('12-12-2016 12:01:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000756, 'admin', to_date('12-12-2016 12:03:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000757, 'admin', to_date('12-12-2016 12:03:37', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000758, 'admin', to_date('12-12-2016 12:04:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000759, 'admin', to_date('12-12-2016 12:06:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000760, 'admin', to_date('12-12-2016 13:14:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000766, 'admin', to_date('12-12-2016 13:45:17', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000767, 'admin', to_date('12-12-2016 13:54:52', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000772, 'admin', to_date('12-12-2016 14:26:00', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000775, 'admin', to_date('12-12-2016 14:50:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000777, 'admin', to_date('12-12-2016 14:53:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000778, 'admin', to_date('12-12-2016 14:56:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000779, 'admin', to_date('12-12-2016 15:00:46', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000780, 'admin', to_date('12-12-2016 15:01:04', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000781, 'admin', to_date('12-12-2016 15:10:05', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000784, 'admin', to_date('12-12-2016 15:17:29', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000785, 'admin', to_date('12-12-2016 15:18:59', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000787, 'admin', to_date('12-12-2016 15:22:07', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000789, 'admin', to_date('12-12-2016 15:25:49', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000790, 'admin', to_date('12-12-2016 15:28:50', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000791, 'admin', to_date('12-12-2016 15:42:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000798, 'admin', to_date('12-12-2016 16:32:52', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000800, 'admin', to_date('12-12-2016 16:34:32', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000801, 'admin', to_date('12-12-2016 16:39:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000802, 'admin', to_date('12-12-2016 16:41:07', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000814, 'admin', to_date('13-12-2016 13:49:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000817, 'admin', to_date('13-12-2016 13:52:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000818, 'admin', to_date('13-12-2016 13:52:21', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000825, 'admin', to_date('14-12-2016 11:52:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000827, 'admin', to_date('14-12-2016 12:00:34', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000832, 'admin', to_date('14-12-2016 13:32:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000833, 'admin', to_date('14-12-2016 13:33:46', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000834, 'admin', to_date('14-12-2016 13:35:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000835, 'admin', to_date('14-12-2016 13:38:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000837, 'admin', to_date('14-12-2016 13:42:00', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000838, 'admin', to_date('14-12-2016 13:57:04', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000839, 'admin', to_date('14-12-2016 13:58:19', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000840, 'admin', to_date('14-12-2016 13:59:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000846, 'admin', to_date('15-12-2016 14:16:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000847, 'admin', to_date('15-12-2016 14:16:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000848, 'admin', to_date('15-12-2016 14:16:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000850, 'admin', to_date('15-12-2016 14:23:36', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000851, 'admin', to_date('15-12-2016 14:40:19', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000852, 'admin', to_date('15-12-2016 14:43:33', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000857, 'admin', to_date('15-12-2016 15:26:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000859, 'admin', to_date('15-12-2016 15:30:13', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000878, 'admin', to_date('16-12-2016 14:43:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000879, 'admin', to_date('16-12-2016 14:45:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000880, 'admin', to_date('16-12-2016 14:54:29', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000904, 'liwc', to_date('19-12-2016 10:30:10', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000912, 'admin', to_date('19-12-2016 10:53:27', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000918, 'admin', to_date('19-12-2016 13:59:50', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000919, 'admin', to_date('19-12-2016 14:03:04', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000920, 'admin', to_date('19-12-2016 14:04:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000618, 'admin', to_date('11-11-2016 14:43:03', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000642, 'admin', to_date('14-11-2016 15:50:55', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000643, 'admin', to_date('14-11-2016 15:54:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000645, 'admin', to_date('14-11-2016 16:11:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000647, 'admin', to_date('14-11-2016 16:50:53', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000648, 'admin', to_date('15-11-2016 09:18:53', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000649, 'admin', to_date('15-11-2016 09:38:36', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000650, 'admin', to_date('15-11-2016 09:43:27', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000651, 'admin', to_date('15-11-2016 10:13:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000657, 'admin', to_date('15-11-2016 13:07:33', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000658, 'admin', to_date('15-11-2016 13:15:13', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000659, 'admin', to_date('15-11-2016 13:25:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000660, 'admin', to_date('15-11-2016 13:30:40', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000661, 'admin', to_date('15-11-2016 13:47:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000662, 'admin', to_date('15-11-2016 14:30:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000663, 'admin', to_date('15-11-2016 14:51:08', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000664, 'admin', to_date('15-11-2016 14:58:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000681, 'admin', to_date('21-11-2016 11:25:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000692, 'admin', to_date('22-11-2016 09:13:24', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000700, 'admin', to_date('02-12-2016 10:28:46', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000701, '？μ？èˉ？3', to_date('02-12-2016 14:15:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '该用户不存在', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000702, 'FA', to_date('02-12-2016 14:16:02', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '该用户不存在', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000703, 'admin', to_date('02-12-2016 14:21:45', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000704, 'admin', to_date('02-12-2016 14:22:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000761, 'admin', to_date('12-12-2016 13:23:22', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000762, 'admin', to_date('12-12-2016 13:27:40', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000763, 'admin', to_date('12-12-2016 13:29:52', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000764, 'admin', to_date('12-12-2016 13:35:03', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000765, 'admin', to_date('12-12-2016 13:37:11', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000770, 'admin', to_date('12-12-2016 14:21:27', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000808, 'admin', to_date('13-12-2016 09:04:32', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000812, 'admin', to_date('13-12-2016 13:44:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000813, 'admin', to_date('13-12-2016 13:47:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000815, 'admin', to_date('13-12-2016 13:50:36', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000816, 'admin', to_date('13-12-2016 13:51:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000820, 'admin', to_date('13-12-2016 13:58:13', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
commit;
prompt 100 records committed...
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000842, 'admin', to_date('15-12-2016 14:06:18', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000843, 'admin', to_date('15-12-2016 14:07:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000844, 'admin', to_date('15-12-2016 14:11:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000858, 'admin', to_date('15-12-2016 15:26:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000865, 'admin', to_date('16-12-2016 10:18:48', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000866, 'admin', to_date('16-12-2016 10:24:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000868, 'admin', to_date('16-12-2016 10:59:53', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000900, 'admin', to_date('19-12-2016 09:28:58', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000901, 'admin', to_date('19-12-2016 10:23:10', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000902, 'admin', to_date('19-12-2016 10:26:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000916, 'admin', to_date('19-12-2016 13:51:45', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000922, 'admin', to_date('19-12-2016 14:09:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000601, 'admin', to_date('10-11-2016 13:21:13', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000604, 'admin', to_date('10-11-2016 13:39:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000610, 'admin', to_date('10-11-2016 14:53:25', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000611, 'admin', to_date('10-11-2016 15:08:24', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000612, 'admin', to_date('10-11-2016 15:14:27', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000613, 'admin', to_date('10-11-2016 15:27:33', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000614, 'admin', to_date('10-11-2016 15:32:40', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000615, 'admin', to_date('10-11-2016 15:34:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000617, 'admin', to_date('10-11-2016 16:05:28', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000619, 'admin', to_date('11-11-2016 15:39:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000621, 'admin', to_date('11-11-2016 15:54:26', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000623, 'admin', to_date('11-11-2016 16:17:41', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000625, 'admin', to_date('11-11-2016 16:26:33', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000626, 'admin', to_date('11-11-2016 16:31:30', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000630, 'admin', to_date('11-11-2016 16:56:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000652, 'admin', to_date('15-11-2016 10:53:51', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000653, 'admin', to_date('15-11-2016 11:01:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000654, 'admin', to_date('15-11-2016 11:12:49', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000655, 'admin', to_date('15-11-2016 11:57:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000656, 'admin', to_date('15-11-2016 12:00:55', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000665, 'admin', to_date('16-11-2016 10:10:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000666, 'admin', to_date('16-11-2016 11:24:45', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000667, 'admin', to_date('16-11-2016 13:07:48', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000680, 'admin', to_date('21-11-2016 11:20:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000685, 'admin', to_date('21-11-2016 14:01:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000686, 'admin', to_date('21-11-2016 14:10:18', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000687, 'admin', to_date('21-11-2016 15:59:32', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000688, 'admin', to_date('21-11-2016 16:43:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000689, 'admin', to_date('21-11-2016 16:55:49', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000690, 'admin', to_date('21-11-2016 17:02:08', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000746, 'admin', to_date('12-12-2016 11:03:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000747, 'admin', to_date('12-12-2016 11:36:08', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000748, 'admin', to_date('12-12-2016 11:38:18', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000749, 'admin', to_date('12-12-2016 11:39:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000750, 'admin', to_date('12-12-2016 11:42:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000821, 'admin', to_date('13-12-2016 13:58:27', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000822, 'admin', to_date('14-12-2016 10:02:28', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000841, 'admin', to_date('15-12-2016 10:27:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000860, 'admin', to_date('15-12-2016 16:55:03', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000861, 'admin', to_date('15-12-2016 16:56:23', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000600, 'admin', to_date('10-11-2016 13:04:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000602, 'admin', to_date('10-11-2016 13:22:39', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000603, 'admin', to_date('10-11-2016 13:27:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000605, 'admin', to_date('10-11-2016 14:09:54', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000606, 'admin', to_date('10-11-2016 14:12:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000607, 'admin', to_date('10-11-2016 14:14:16', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000608, 'admin', to_date('10-11-2016 14:24:41', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000609, 'admin', to_date('10-11-2016 14:42:11', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000616, 'admin', to_date('10-11-2016 15:47:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000624, 'admin', to_date('11-11-2016 16:23:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000721, 'admin', to_date('09-12-2016 14:03:07', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000740, 'admin', to_date('12-12-2016 09:16:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000742, 'admin', to_date('12-12-2016 09:22:35', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000744, 'admin', to_date('12-12-2016 10:59:34', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000745, 'admin', to_date('12-12-2016 11:02:10', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000768, 'admin', to_date('12-12-2016 13:55:10', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000769, 'admin', to_date('12-12-2016 13:56:41', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000799, 'admin', to_date('12-12-2016 16:34:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000803, 'admin', to_date('12-12-2016 16:41:37', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000805, 'admin', to_date('12-12-2016 17:01:24', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000807, 'admin', to_date('13-12-2016 09:04:01', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000810, 'admin', to_date('13-12-2016 13:38:58', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000811, 'admin', to_date('13-12-2016 13:42:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000819, 'admin', to_date('13-12-2016 13:57:02', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000823, 'admin', to_date('14-12-2016 11:05:21', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000824, 'admin', to_date('14-12-2016 11:50:20', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000826, 'admin', to_date('14-12-2016 11:55:58', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000828, 'admin', to_date('14-12-2016 13:16:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000829, 'admin', to_date('14-12-2016 13:24:20', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000830, 'admin', to_date('14-12-2016 13:29:29', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000831, 'admin', to_date('14-12-2016 13:30:11', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000836, 'admin', to_date('14-12-2016 13:40:21', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000849, 'admin', to_date('15-12-2016 14:19:30', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000853, 'admin', to_date('15-12-2016 14:49:13', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000854, 'admin', to_date('15-12-2016 14:55:36', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000855, 'admin', to_date('15-12-2016 15:15:20', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000856, 'admin', to_date('15-12-2016 15:26:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000862, 'admin', to_date('16-12-2016 10:11:08', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000863, 'admin', to_date('16-12-2016 10:16:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000864, 'admin', to_date('16-12-2016 10:18:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000867, 'admin', to_date('16-12-2016 10:58:25', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000869, 'admin', to_date('16-12-2016 14:02:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000870, 'admin', to_date('16-12-2016 14:06:43', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000871, 'admin', to_date('16-12-2016 14:07:12', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000872, 'admin', to_date('16-12-2016 14:07:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000873, 'admin', to_date('16-12-2016 14:31:52', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000874, 'admin', to_date('16-12-2016 14:35:36', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000881, 'admin', to_date('16-12-2016 14:54:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
commit;
prompt 200 records committed...
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000885, 'admin', to_date('16-12-2016 16:25:19', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000914, 'admin', to_date('19-12-2016 13:48:30', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000915, 'admin', to_date('19-12-2016 13:49:58', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000924, 'admin', to_date('19-12-2016 14:34:35', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000925, 'admin', to_date('19-12-2016 16:52:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000940, 'admin', to_date('26-12-2016 10:20:25', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000941, 'admin', to_date('26-12-2016 10:25:17', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000620, 'admin', to_date('11-11-2016 15:46:08', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000622, 'admin', to_date('11-11-2016 16:13:51', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000627, 'admin', to_date('11-11-2016 16:43:16', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000628, 'admin', to_date('11-11-2016 16:46:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000629, 'admin', to_date('11-11-2016 16:47:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000631, 'admin', to_date('11-11-2016 17:01:14', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000640, 'admin', to_date('14-11-2016 15:36:57', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000641, 'admin', to_date('14-11-2016 15:49:17', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000644, 'admin', to_date('14-11-2016 15:57:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000646, 'admin', to_date('14-11-2016 16:40:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000684, 'admin', to_date('21-11-2016 13:39:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000691, 'admin', to_date('22-11-2016 08:57:20', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000695, 'admin', to_date('22-11-2016 11:05:04', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '127.0.0.1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000741, 'admin', to_date('12-12-2016 09:19:20', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000771, 'admin', to_date('12-12-2016 14:22:58', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000773, 'admin', to_date('12-12-2016 14:28:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000774, 'admin', to_date('12-12-2016 14:30:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000776, 'admin', to_date('12-12-2016 14:51:26', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000782, 'admin', to_date('12-12-2016 15:10:45', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000783, 'admin', to_date('12-12-2016 15:12:19', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000786, 'admin', to_date('12-12-2016 15:22:00', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000788, 'admin', to_date('12-12-2016 15:22:38', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000792, 'admin', to_date('12-12-2016 15:44:49', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000793, 'admin', to_date('12-12-2016 15:45:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000794, 'admin', to_date('12-12-2016 15:46:03', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000795, 'admin', to_date('12-12-2016 15:46:11', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000796, 'admin', to_date('12-12-2016 16:18:21', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000797, 'admin', to_date('12-12-2016 16:24:35', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000804, 'admin', to_date('12-12-2016 16:44:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000806, 'admin', to_date('12-12-2016 17:06:17', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000809, 'admin', to_date('13-12-2016 11:43:26', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000845, 'admin', to_date('15-12-2016 14:16:09', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000875, 'admin', to_date('16-12-2016 14:35:44', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000876, 'admin', to_date('16-12-2016 14:35:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000877, 'admin', to_date('16-12-2016 14:39:33', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000882, 'admin', to_date('16-12-2016 15:04:56', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000883, 'admin', to_date('16-12-2016 16:22:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000884, 'admin', to_date('16-12-2016 16:23:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000903, 'admin', to_date('19-12-2016 10:29:17', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000905, 'liwc', to_date('19-12-2016 10:30:59', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000906, 'admin', to_date('19-12-2016 10:31:06', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000907, 'admin', to_date('19-12-2016 10:37:25', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000908, 'admin', to_date('19-12-2016 10:40:34', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000909, 'admin', to_date('19-12-2016 10:42:48', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000910, 'admin', to_date('19-12-2016 10:44:15', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000911, 'admin', to_date('19-12-2016 10:48:10', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000913, 'admin', to_date('19-12-2016 11:25:30', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000917, 'admin', to_date('19-12-2016 13:55:31', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000921, 'admin', to_date('19-12-2016 14:05:48', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
insert into SYSTEM_LOGS (ID, USER_CODE, LOG_TIME, LOG_TYPE, LOG_INFO, LOG_IP)
values (100000923, 'admin', to_date('19-12-2016 14:11:42', 'dd-mm-yyyy hh24:mi:ss'), '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
commit;
prompt 257 records loaded
prompt Loading SYSTEM_MENU...
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('349BE76CE4C94CCAB5A652ECA8C194C4', '系统管理', null, '0', null, null, '0', 'pages/platform/images/icon (10).png', 10, 'M0000039', to_date('12-05-2016 15:42:00', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('A74244C4CEAB4A8CB073FB1EEDC4D87F', '人员管理', '/pages/platform/jsp/user/index.jsp', 'M0000039', null, null, '0', null, 10.1, 'M0000040', null, null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('BD7A583C4FC34C0EB70FC193E357BB7B', '角色管理', '/pages/platform/jsp/role/index.jsp', 'M0000039', null, null, '0', null, 10.2, 'M0000041', to_date('22-11-2016 10:58:00', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('24C62365318F4C8CA5076E327ECB9A43', '部门管理', '/pages/platform/jsp/org/org.jsp', 'M0000039', null, null, '0', null, 10.3, 'M0000042', null, null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('BF8DB51347404DE0924F95CBB9578DAF', '菜单管理', '/pages/platform/jsp/menu/menu.jsp', 'M0000039', null, null, '0', null, 10.4, 'M0000043', null, null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('DFCD73B6131B415CAF113B2DF38A98E5', '字典管理', '/pages/platform/jsp/dict/dict.jsp', 'M0000039', null, null, '0', null, 10.5, 'M0000044', to_date('11-11-2016 16:18:01', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('2925A39086BE4DB593BCA63B8994ABDC', '消息管理', '/pages/platform/jsp/message/message.jsp', 'M0000039', null, null, '0', null, 10.6, 'M0000045', null, null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('C68E58FE35FA4A0FAB9BCE6874FC0A08', '日志管理', '/pages/platform/jsp/log/log.jsp', 'M0000039', null, null, '0', null, 10.7, 'M0000046', null, null, to_date('01-04-2016 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('D6D50A097D2D43E79DB4581F18C5B69E', '首页', null, '0', null, null, '0', 'pages/platform/images/icon (1).png', 1, 'M0000001', to_date('15-06-2016 10:25:00', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('15-06-2016 10:23:00', 'dd-mm-yyyy hh24:mi:ss'), 'zhouh');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('34E8E5CBC5ED4743B331456A6625073E', '首页', '/pages/platform/jsp/home/main.jsp', 'M0000001', null, null, '0', null, 1.1, 'M0000002', to_date('22-11-2016 11:05:16', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('08-07-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'zhouh');
insert into SYSTEM_MENU (ID, NAME, URL, PARENT_ID, TYPE, PERMISSION, STATUS, IMG_URL, ORDER_ID, MENU_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('047692BD1E8F4226875B94599A0F9BB0', '文件管理', '/pages/platform/jsp/file/file.jsp', 'M0000039', null, null, '0', null, 10.8, 'M0000190', to_date('15-12-2016 14:06:51', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('15-12-2016 14:06:29', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 11 records loaded
prompt Loading SYSTEM_MESSAGE...
insert into SYSTEM_MESSAGE (ID, TITLE, TYPE, SENDER, RECIPIENT, CONTENT, TIMES, MESSAGE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('1', 'TESTE', 'HEHE', 'ADMIN', 'DDD', 'ZHEGE', to_date('14-11-2016', 'dd-mm-yyyy'), '2', null, null, null, 'admin');
commit;
prompt 1 records loaded
prompt Loading SYSTEM_ORG...
insert into SYSTEM_ORG (ID, ORG_CODE, ORG_NAME, PARENT_ID, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('2802a765470c410686f8f33f92c3e2ab', 'ORG00110', '技术服务部', 'ORG00001', '0', to_date('14-11-2016 16:40:45', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('14-11-2016 16:40:45', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_ORG (ID, ORG_CODE, ORG_NAME, PARENT_ID, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('66CCABE9D3BD49D5A51E62AF4D0BD801', 'ORG00001', '创德软件', '0', '0', null, null, null, null);
insert into SYSTEM_ORG (ID, ORG_CODE, ORG_NAME, PARENT_ID, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('EC22C0EA6F5B4A9887F687C86527578A', 'ORG00002', '技术中心', 'ORG00001', '0', null, null, null, null);
insert into SYSTEM_ORG (ID, ORG_CODE, ORG_NAME, PARENT_ID, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('93c3bd290161435d82c1ef4e8ee96c6c', 'ORG00111', '新增节点', 'ORG00001', '1', to_date('15-11-2016 15:53:43', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('15-11-2016 15:53:43', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 4 records loaded
prompt Loading SYSTEM_RESOURCE...
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('F140E3AA6BF94238A3A12D7007A456BA', '人员管理添加', null, 'M0000040', 'button', 'UserController:insert', null, null, 'SYSTEM:USER:insert', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('975CF70176DE4E99BA3D0703C848867C', '人员管理修改', null, 'M0000040', 'button', 'UserController:delete', null, null, 'SYSTEM:USER:delete', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('9C166EBBCCF44AA4AA0F14798D2B1154', '人员管理重置密码', null, 'M0000040', 'button', 'UserController:resetPassWord', null, null, 'SYSTEM:USER:resetPassWord', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('BF625A48720E41F1A739BEB50D581065', '角色管理角色查询', null, 'M0000041', 'button', 'RoleController:queryRoleNeed', null, null, 'SYSTEM:ROLE:queryRoleNeed', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('3B48A69F9B464D568B22DBC412574032', '角色管理当前角色下人员查询', null, 'M0000041', 'button', 'RoleController:queryRoleUserPage', null, null, 'SYSTEM:ROLE:queryRoleUserPage', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('5436C246776D413C92FE398F2924D95B', '角色管理菜单权限查询', null, 'M0000041', 'button', 'RoleController:selectMenuTree', null, null, 'SYSTEM:ROLE:selectMenuTree', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8777D9B52AB042079B69E9837C6F07BC', '部门管理部门人员查询', null, 'M0000042', 'button', 'OrgController:selUser', null, null, 'SYSTEM:ORG:selUser', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8D8CC2936D1D4DB2B3A56EC5454FDCDA', '部门管理当前部门下人员查询', null, 'M0000042', 'button', 'OrgController:selOrgUser', null, null, 'SYSTEM:ORG:selOrgUser', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('FEEDCF872DFA4CC7BEEDA88A7DD9859E', '部门管理部门查询', null, 'M0000042', 'button', 'OrgController:selOrgTree', null, null, 'SYSTEM:ORG:selOrgTree', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('0DF0A561F818436FB1630F8E1E8D6CDE', '菜单管理添加根节点', null, 'M0000043', 'button', 'MenusController:insertParent', null, null, 'SYSTEM:MENU:insertParent', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('58E992C4FB3949D09658D8BF20640DF5', '菜单管理添加子节点', null, 'M0000043', 'button', 'MenusController:insertChild', null, null, 'SYSTEM:MENU:insertChild', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('D787CFE82D2E495F82A5C0EFE29B8656', '字典管理新增类别', null, 'M0000044', 'button', 'DictController:addDictType', null, null, 'SYSTEM:DICT:addDictType', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('9489E5EFCD9F4EF7879343D2C44F67DE', '字典管理新增字典', null, 'M0000044', 'button', 'DictController:addDict', null, null, 'SYSTEM:DICT:addDict', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('57B6C6496C374AFFA3B2E5EB5FF05FDB', '消息管理消息查询', null, 'M0000045', 'button', 'MessageController:querymessage', null, null, 'SYSTEM:MESSAGE:querymessage', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('0C6828BCC05D4BB8B4E3F68A64407038', '人员管理查询', null, 'M0000040', 'button', 'UserController:queryUserNeed', null, null, 'SYSTEM:USER:queryUserNeed', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('BF324F82C41147FA8B31EB53042EAC78', '人员管理删除', null, 'M0000040', 'button', 'UserController:update', null, null, 'SYSTEM:USER:update', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('D226CC7EDF7A4BBB9A47E9B7DF0EF390', '角色管理当前角色下人员分配查询', null, 'M0000041', 'button', 'RoleController:queryRoleUserNOTIN', null, null, 'SYSTEM:ROLE:queryRoleUserNOTIN', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('43C01EF3E3864EA688ED1E9F91169806', '菜单管理菜单查询', null, 'M0000043', 'button', 'MenusController:selMenuTree', null, null, 'SYSTEM:MENU:selMenuTree', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('31D2D7B1F908452196A4531645A0336A', '字典管理字典查询', null, 'M0000044', 'button', 'DictController:querydict', null, null, 'SYSTEM:DICT:querydict', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('81439FD47BC5434282BC163C8D6AF289', '日志管理日志查询', null, 'M0000046', 'button', 'LogController:sellogs', null, null, 'SYSTEM:LOG:sellogs', null, null, null, null, null);
insert into SYSTEM_RESOURCE (ID, NAME, URL, MENU_CODE, TYPE, PERMISSION, SHOW_IN_FRONT, PIC_NAME, RES_CODE, RES_TYPE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('7C884375FFF243078220C31D7275F180', '角色菜单新增角色', null, 'M0000041', 'button', 'RoleController:insert', null, null, 'SYSTEM:ROLE:insert', null, null, null, null, null);
commit;
prompt 21 records loaded
prompt Loading SYSTEM_ROLE...
insert into SYSTEM_ROLE (ID, ROLE_CODE, ROLE_NAME, DESCRIBE, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('33EA18C032F242B0A97E03EF6191ABA7', 'R0000009', '管理员', null, '0', null, null, null, null);
insert into SYSTEM_ROLE (ID, ROLE_CODE, ROLE_NAME, DESCRIBE, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('9E97BCDD415D4823BFFDA555C475B758', 'R0000110', 'kiover', 'kiover1', '1', null, null, null, null);
insert into SYSTEM_ROLE (ID, ROLE_CODE, ROLE_NAME, DESCRIBE, DEL_FLAG, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('471E68D02CE149B8A851AC08E97DABD1', 'R0000111', '测试角色', '测试数据', '0', null, null, null, null);
commit;
prompt 3 records loaded
prompt Loading SYSTEM_ROLE_MENU...
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('2FB133E44E13473DB2F1D0C711B84140', 'M0000039', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('FDA403D8FD5944F7BA149E2FF8C192A2', 'M0000040', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('7BE408FA75944B0BB7646CF526246BD3', 'M0000041', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('1E8AA5DBE73E438EA9F717B19FC90F30', 'M0000041', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8F09DA3939094B02B4DD7BA93DB4789A', 'M0000042', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('B681C54E897141A083AA49EC0A925695', 'M0000043', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8FB54643D1F84BC0A38899DF22C24239', 'M0000042', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('45B0D18E88A048308DF542FC9E68F5FE', 'M0000044', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('D8A478540B5C409D83D1C88DDFA31B98', 'M0000043', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('6C4E1EA076404CDB97ABEED71ED59744', 'M0000045', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('04B2668169424A0B864E2BA058CB8189', 'M0000046', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('B7E65E3AE00C4ED9AE10DE81F7E607E6', 'M0000044', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('0F53621994CB4D43BCF3E90A4CC1C794', 'M0000190', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('96D68905A7D141E78E09B9E55D0E53AB', 'M0000001', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('5172478D764246E09551832C1775C221', 'M0000002', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('281990750DC3418B8138816473C8AFDB', 'M0000045', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('4956D60945484F00BCD37C93951F117C', 'M0000046', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('D227EF4313C349A9BD5F0132B930B84F', 'M0000190', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('79CC94E063934236898A5007D9531BCF', 'M0000001', 'R0000009', null, null, null, null);
insert into SYSTEM_ROLE_MENU (ID, MENU_CODE, ROLE_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('EABA20B7B17C46ADAA7AC838C775FBD1', 'M0000002', 'R0000009', null, null, null, null);
commit;
prompt 20 records loaded
prompt Loading SYSTEM_ROLE_RESOURCE...
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('87CB40079FFF43578709888B1057F397', '0', 'R0000009', 'SYSTEM:USER:insert', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('30AB53B6744643FAAE73B8B383BD8AF1', '0', 'R0000009', 'SYSTEM:USER:queryUserNeed', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('CBB9885D1044429CAF799BF56AA586BD', '0', 'R0000009', 'SYSTEM:USER:update', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('C6D7C9F840CF45F98BFD496D0E6BAE4A', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleNeed', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('C5CD167CBFCD4BB4A37EF6C60DF3C5EE', '0', 'R0000009', 'SYSTEM:USER:delete', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('2A02602281F54900A0BC6DEDBDFA6D0D', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserPage', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('7346AFAD55D9483296B62C5F6656B9E6', '0', 'R0000009', 'SYSTEM:USER:resetPassWord', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('8E800C2CEA42450B9DF1F7DB3BB8B20C', '0', 'R0000009', 'SYSTEM:ROLE:selectMenuTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('738C327B630042E8AC180195DEB371CF', '0', 'R0000009', 'SYSTEM:USER:queryUserNeed', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('B72CAA796EEA42EFBC70AAB563B52DD7', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserNOTIN', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('00D827913E5347B18C189FB1E6B50977', '0', 'R0000009', 'SYSTEM:USER:update', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('1510858677AD45489BDFEB4F6E030965', '0', 'R0000009', 'SYSTEM:ROLE:insert', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('CD6C6B984DD749E5BED20C3AB751CE0B', '0', 'R0000009', 'SYSTEM:ORG:selUser', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('96FED95A18884D9893AAF9A9FDCD97FA', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleNeed', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('EEB3B1FF44A8481F91F1557FCDDA7E82', '0', 'R0000009', 'SYSTEM:ORG:selOrgUser', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('0AED3EE8C403425998FE2930CF109459', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserPage', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('FA87D805E7D04CF794138F0DE7FC45CE', '0', 'R0000009', 'SYSTEM:ORG:selOrgTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('F5B55B2370E34C13B020029B605E3080', '0', 'R0000009', 'SYSTEM:ROLE:selectMenuTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('AA389AFE8C88467089243283D21387C8', '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserNOTIN', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('C41A0BBA0D494FB59C5C2F949DCF9BE8', '0', 'R0000009', 'SYSTEM:MENU:insertParent', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('23F35C9B4D544586A00EFF7DF78FE198', '0', 'R0000009', 'SYSTEM:ROLE:insert', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('39D429D201534AEDAB1DAB3BE7234922', '0', 'R0000009', 'SYSTEM:MENU:insertChild', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('5D8E33F568F84559A86E46A3C422E336', '0', 'R0000009', 'SYSTEM:MENU:selMenuTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('E9391832509041C6B3EE70826E76381D', '0', 'R0000009', 'SYSTEM:ORG:selUser', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('05504759EF024392BC39C7601FDA1E87', '0', 'R0000009', 'SYSTEM:ORG:selOrgUser', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('03F7E7E1023948528D19CF5D2DD166B5', '0', 'R0000009', 'SYSTEM:DICT:addDictType', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('B448CB1D22544A86B95AE15E2CB125D2', '0', 'R0000009', 'SYSTEM:ORG:selOrgTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('94006FA2B5E542E2ADFB11EBBA559EC5', '0', 'R0000009', 'SYSTEM:DICT:addDict', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('201A51B8B4BE4656B438C50819A4F2D2', '0', 'R0000009', 'SYSTEM:DICT:querydict', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('901AB4ECBEC94AF7B7919364FA8880D4', '0', 'R0000009', 'SYSTEM:MENU:insertParent', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('F349E2148A454435B7911655EBD05C5C', '0', 'R0000009', 'SYSTEM:MENU:insertChild', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('AEE2F88C484F4CD8B388F94701E0EB06', '0', 'R0000009', 'SYSTEM:MESSAGE:querymessage', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('43875F84D8B5451CA2888F0C4AFE9E25', '0', 'R0000009', 'SYSTEM:MENU:selMenuTree', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('F0B77599FD23436E92856E168F6FE196', '0', 'R0000009', 'SYSTEM:LOG:sellogs', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('AEE0245F1B2347DE82B489F8AFA91967', '0', 'R0000009', 'SYSTEM:DICT:addDictType', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('64BDCB1DB112411E8986329C020AF135', '0', 'R0000009', 'SYSTEM:DICT:addDict', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('AE6669BE629E47348EE90087AEC63D5F', '0', 'R0000009', 'SYSTEM:DICT:querydict', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('C32EE79E65B14871874B64707D61F8BE', '0', 'R0000009', 'SYSTEM:MESSAGE:querymessage', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
insert into SYSTEM_ROLE_RESOURCE (ID, STATUS, ROLE_CODE, RES_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('A3AF6DA2D4AE40E89883CA232095D9BB', '0', 'R0000009', 'SYSTEM:LOG:sellogs', null, null, to_date('15-12-2016', 'dd-mm-yyyy'), null);
commit;
prompt 39 records loaded
prompt Loading SYSTEM_ROLE_USER...
insert into SYSTEM_ROLE_USER (ID, ROLE_CODE, USER_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('45FB6604907E41358B86DC3023DD7B8F', 'R0000009', 'admin', null, null, null, null);
commit;
prompt 1 records loaded
prompt Loading SYSTEM_USER...
insert into SYSTEM_USER (ID, USER_CODE, USER_NAME, PASSWORD, DEL_FLAG, STATUS, JOB_NUM, CELL_PHONE, ICON, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('714C23BF493F45A8A6FD5959A40D3282', 'liwc', '李文超', 'E3CEB5881A0A1FDAAD01296D7554868D', '0', '1', '2005205205', '17686601998', null, to_date('19-12-2016 10:33:28', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('19-12-2016 10:33:28', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_USER (ID, USER_CODE, USER_NAME, PASSWORD, DEL_FLAG, STATUS, JOB_NUM, CELL_PHONE, ICON, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('48E208023CD845ECB2D15C44ACE8B06B', 'kiover', '测试3', '123', '1', '1', '12345', '123909773', null, to_date('15-11-2016 11:02:02', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('15-11-2016 11:02:02', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into SYSTEM_USER (ID, USER_CODE, USER_NAME, PASSWORD, DEL_FLAG, STATUS, JOB_NUM, CELL_PHONE, ICON, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('E9EE2E1D4B834C59AA9719A7ADB0BA41', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '1', '000000', null, null, null, null, null, null);
insert into SYSTEM_USER (ID, USER_CODE, USER_NAME, PASSWORD, DEL_FLAG, STATUS, JOB_NUM, CELL_PHONE, ICON, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('FD9392EDCAA947A5A4E843EE8A7A64D1', 'FA', 'FA', 'FA', '1', '1', '0003', '1234', null, to_date('15-11-2016 11:19:02', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('15-11-2016 11:19:02', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 4 records loaded
prompt Loading SYSTEM_USER_ORG...
insert into SYSTEM_USER_ORG (ID, USER_CODE, ORG_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('0AB73EFE51594674931D0E62BB0667CE', 'admin', 'ORG00001', null, null, null, null);
insert into SYSTEM_USER_ORG (ID, USER_CODE, ORG_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('19BF8A65D78D4C2BAB5736925648246D', 'liwc', 'ORG00002', null, null, null, null);
insert into SYSTEM_USER_ORG (ID, USER_CODE, ORG_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('83EB4156C77D4003B3BE61E93884DDB5', 'kiover', 'ORG00110', null, null, null, null);
insert into SYSTEM_USER_ORG (ID, USER_CODE, ORG_CODE, UPDATE_TIME, UPDATE_USER, CREATE_TIME, CREATE_USER)
values ('41DDFF79CC49406FA0EE7E3C90CC2EF0', 'FA', 'ORG00110', null, null, null, null);
commit;
prompt 4 records loaded
set feedback on
set define on
prompt Done.

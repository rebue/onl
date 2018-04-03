/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/3 9:08:47                             */
/*==============================================================*/


drop table if exists ONL_CART;

drop table if exists ONL_ONLINE;

drop table if exists ONL_ONLINE_PIC;

drop table if exists ONL_ONLINE_PROMOTION;

drop table if exists ONL_ONLINE_SPEC;

/*==============================================================*/
/* Table: ONL_CART                                              */
/*==============================================================*/
create table ONL_CART
(
   ID                   bigint not null comment '购物车ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
   ONLINE_ID            bigint not null comment '上线ID',
   USER_ID              bigint not null comment '用户编号',
   CART_COUNT           int not null comment '购物车规格数量',
   JOIN_TIME            datetime not null comment '加入时间',
   primary key (ID)
);

alter table ONL_CART comment '购物车';

/*==============================================================*/
/* Table: ONL_ONLINE                                            */
/*==============================================================*/
create table ONL_ONLINE
(
   ID                   bigint not null comment '上线ID',
   ONLINE_TITLE         varchar(300) not null comment '上线标题',
   ONLINE_DETAIL        varchar(2000) comment '上线描述',
   ONLINE_STATE         tinyint not null comment '上线状态（0：下线，1：上线  ）',
   OP_ID                bigint not null comment '操作人ID',
   ONLINE_TIME          datetime not null comment '上线时间',
   PRODUCE_ID           bigint not null comment '产品ID,上一次上线的产品ID',
   primary key (ID)
);

alter table ONL_ONLINE comment '上线信息';

/*==============================================================*/
/* Table: ONL_ONLINE_PIC                                        */
/*==============================================================*/
create table ONL_ONLINE_PIC
(
   ID                   bigint not null comment '上线图片ID',
   ONLINE_ID            bigint not null comment '上线ID',
   PIC_TYPE             tinyint not null comment '图片类型',
   PIC_PATH             varchar(800) not null comment '图片路径',
   primary key (ID)
);

alter table ONL_ONLINE_PIC comment '上线图片';

/*==============================================================*/
/* Table: ONL_ONLINE_PROMOTION                                  */
/*==============================================================*/
create table ONL_ONLINE_PROMOTION
(
   ID                   bigint not null comment '上线推广ID',
   ONLINE_ID            bigint not null comment '上线ID',
   PROMOTION_TYPE       tinyint not null comment '推广类型',
   primary key (ID)
);

alter table ONL_ONLINE_PROMOTION comment '上线推广';

/*==============================================================*/
/* Table: ONL_ONLINE_SPEC                                       */
/*==============================================================*/
create table ONL_ONLINE_SPEC
(
   ID                   bigint not null comment '上线规格ID',
   ONLINE_ID            bigint not null comment '上线ID',
   ONLINE_SPEC          varchar(200) not null comment '上线规格',
   CASHBACK_AMOUNT      decimal(20,4) not null comment '返现金额',
   SALE_PRICE           decimal(20,4) not null comment '销售价格',
   SALE_UNIT            varchar(50) comment '销售单位',
   SALE_COUNT           int not null comment '销售数量',
   SEQ_NO               int not null comment '排序号',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC comment '上线规格';


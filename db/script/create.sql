/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/5 11:33:35                           */
/*==============================================================*/


drop table if exists ONL_CART;

drop table if exists ONL_ONLINE;

drop table if exists ONL_ONLINE_LOG;

drop table if exists ONL_ONLINE_PIC;

drop table if exists ONL_ONLINE_PIC_LOG;

drop table if exists ONL_ONLINE_PROMOTION;

drop table if exists ONL_ONLINE_SPEC;

drop table if exists ONL_ONLINE_SPEC_LOG;

/*==============================================================*/
/* Table: ONL_CART                                              */
/*==============================================================*/
create table ONL_CART
(
   ID                   bigint not null comment '购物车ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
   ONLINE_ID            bigint not null comment '上线ID',
   SUPPLIER_ID          bigint comment '供应商ID',
   PLEDGE_TYPE          tinyint comment '押货类型（1：押货 2：供应商发货）',
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
   SUBJECT_TYPE         tinyint not null default 0 comment '板块类型（0：普通，1：全返）',
   ONLINE_TITLE         varchar(300) not null comment '上线标题',
   ONLINE_DETAIL        varchar(2000) comment '上线描述',
   SUPPLIER_ID          bigint comment '供应商ID',
   PLEDGE_TYPE          tinyint comment '押货类型（1：押货 2：供应商发货）',
   OP_ID                bigint not null comment '操作人ID',
   ONLINE_STATE         tinyint not null comment '上线状态（0：下线，1：上线  ）',
   ONLINE_TIME          datetime not null comment '上线时间',
   PRODUCT_ID           bigint not null comment '产品ID,上一次上线的产品ID',
   primary key (ID)
);

alter table ONL_ONLINE comment '上线信息';

/*==============================================================*/
/* Table: ONL_ONLINE_LOG                                        */
/*==============================================================*/
create table ONL_ONLINE_LOG
(
   ID                   bigint not null comment '上线日志ID',
   PARTNER_ID           bigint not null comment '伙伴ID',
   ONLINE_ID            bigint not null comment '上线ID',
   SUPPLIER_ID          bigint comment '供应商ID',
   PLEDGE_TYPE          tinyint comment '押货类型（1：押货 2：供应商发货）',
   OP_ID                bigint not null comment '操作人ID',
   OP_TIME              datetime not null comment '操作时间',
   SUBJECT_TYPE         tinyint not null default 0 comment '板块类型（0：普通，1：全返）',
   ONLINE_TITLE         varchar(300) not null comment '上线标题',
   ONLINE_DETAIL        varchar(2000) comment '上线描述',
   PRODUCT_ID           bigint not null comment '产品ID,上一次上线的产品ID',
   primary key (ID)
);

alter table ONL_ONLINE_LOG comment '上线日志';

/*==============================================================*/
/* Table: ONL_ONLINE_PIC                                        */
/*==============================================================*/
create table ONL_ONLINE_PIC
(
   ID                   bigint not null comment '上线图片ID',
   ONLINE_ID            bigint not null comment '上线ID',
   PIC_TYPE             tinyint not null comment '图片类型(1：主图  0：轮播图)',
   PIC_PATH             varchar(800) not null comment '图片路径',
   primary key (ID)
);

alter table ONL_ONLINE_PIC comment '上线图片';

/*==============================================================*/
/* Table: ONL_ONLINE_PIC_LOG                                    */
/*==============================================================*/
create table ONL_ONLINE_PIC_LOG
(
   ID                   bigint not null comment '上线图片日志ID',
   ONLINE_LOG_ID        bigint not null comment '上线日志ID',
   ONLINE_ID            bigint not null comment '上线ID',
   PIC_TYPE             tinyint not null comment '图片类型',
   PIC_PATH             varchar(800) not null comment '图片路径',
   primary key (ID)
);

alter table ONL_ONLINE_PIC_LOG comment '上线图片日志';

/*==============================================================*/
/* Table: ONL_ONLINE_PROMOTION                                  */
/*==============================================================*/
create table ONL_ONLINE_PROMOTION
(
   ID                   bigint not null comment '上线推广ID',
   ONLINE_ID            bigint not null comment '上线ID',
   PROMOTION_TYPE       tinyint not null comment '推广类型(1-每日热门)',
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
   SALE_PRICE           decimal(20,4) not null comment '销售价格',
   COST_PRICE           decimal(20,4) comment '成本价格',
   CASHBACK_AMOUNT      decimal(20,4) not null comment '返现金额',
   COMMISSION_AMOUNT    decimal(20,4) comment '返佣金额',
   SALE_UNIT            varchar(50) comment '销售单位',
   CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）',
   SALE_COUNT           int not null comment '销售数量',
   SEQ_NO               int not null comment '排序号',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC comment '上线规格';

/*==============================================================*/
/* Table: ONL_ONLINE_SPEC_LOG                                   */
/*==============================================================*/
create table ONL_ONLINE_SPEC_LOG
(
   ID                   bigint not null comment '上线规格日志ID',
   ONLINE_LOG_ID        bigint not null comment '上线日志ID',
   ONLINE_ID            bigint not null comment '上线ID',
   ONLINE_SPEC          varchar(200) not null comment '上线规格',
   SALE_PRICE           decimal(20,4) not null comment '销售价格',
   COST_PRICE           decimal(20,4) comment '成本价格',
   CASHBACK_AMOUNT      decimal(20,4) not null comment '返现金额',
   COMMISSION_AMOUNT    decimal(20,4) comment '返佣金额',
   SALE_UNIT            varchar(50) comment '销售单位',
   CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）',
   SEQ_NO               int not null comment '排序号',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC_LOG comment '上线规格日志';

alter table ONL_CART add constraint FK_Relationship_7 foreign key (ONLINE_SPEC_ID)
      references ONL_ONLINE_SPEC (ID) on delete restrict on update restrict;

alter table ONL_CART add constraint FK_Relationship_8 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_LOG add constraint FK_Relationship_10 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_PIC add constraint FK_Relationship_4 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_PIC_LOG add constraint FK_Relationship_13 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_PIC_LOG add constraint FK_Relationship_14 foreign key (ONLINE_LOG_ID)
      references ONL_ONLINE_LOG (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_PROMOTION add constraint FK_Relationship_5 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC add constraint FK_Relationship_2 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC_LOG add constraint FK_Relationship_11 foreign key (ONLINE_LOG_ID)
      references ONL_ONLINE_LOG (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC_LOG add constraint FK_Relationship_12 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;


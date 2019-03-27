/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/27 11:38:36                           */
/*==============================================================*/


drop table if exists ONL_CART;

drop table if exists ONL_ONLINE;

drop table if exists ONL_ONLINE_LOG;

drop table if exists ONL_ONLINE_PIC;

drop table if exists ONL_ONLINE_PIC_LOG;

drop table if exists ONL_ONLINE_PROMOTION;

drop table if exists ONL_ONLINE_SPEC;

drop table if exists ONL_ONLINE_SPEC_ATTR;

drop table if exists ONL_ONLINE_SPEC_LOG;

drop table if exists ONL_ONLINE_SPEC_ORDER_REMARK;

drop table if exists ONL_SEARCH_CATEGORY;

drop table if exists ONL_SEARCH_CATEGORY_ONLINE;

/*==============================================================*/
/* Table: ONL_CART                                              */
/*==============================================================*/
create table ONL_CART
(
   ID                   bigint not null comment '购物车ID',
   ONLINE_ID            bigint not null comment '上线ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
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
   ONLINE_ORG_ID        bigint not null comment '上线组织ID',
   SUPPLIER_ID          bigint comment '供应商ID',
   DELIVER_ORG_ID       bigint not null comment '发货组织ID(默认填入上线组织ID，可变更为供应商的ID)',
   OP_ID                bigint not null comment '操作人ID',
   ONLINE_STATE         tinyint not null comment '上线状态（0：下线，1：上线  ）',
   ONLINE_TIME          datetime not null comment '上线时间',
   PRODUCT_ID           bigint not null comment '产品ID,上一次上线的产品ID',
   IS_BELOW_ONLINE      bool not null default false comment '是否线下（如果为线下店铺时，默认不发布到平台）',
   IS_ONLINE_PLATFORM   bool not null comment '是否上线到平台',
   primary key (ID)
);

alter table ONL_ONLINE comment '上线信息';

/*==============================================================*/
/* Table: ONL_ONLINE_LOG                                        */
/*==============================================================*/
create table ONL_ONLINE_LOG
(
   ID                   bigint not null comment '上线日志ID',
   ONLINE_ID            bigint not null comment '上线ID',
   SUBJECT_TYPE         tinyint not null default 0 comment '板块类型（0：普通，1：全返）',
   ONLINE_TITLE         varchar(300) not null comment '上线标题',
   ONLINE_DETAIL        varchar(2000) comment '上线描述',
   ONLINE_ORG_ID        bigint not null comment '上线组织ID',
   SUPPLIER_ID          bigint comment '供应商ID',
   DELIVER_ORG_ID       bigint comment '发货组织ID(默认填入上线组织ID，可变更为供应商的ID)',
   OP_ID                bigint not null comment '操作人ID',
   OP_TIME              datetime not null comment '操作时间',
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
   PRODUCT_SPEC_ID      bigint comment '产品规格ID',
   ONLINE_SPEC          varchar(200) not null comment '上线规格名称',
   SALE_PRICE           decimal(20,4) not null comment '销售价格(单价)',
   COST_PRICE           decimal(20,4) comment '成本价格',
   CASHBACK_AMOUNT      decimal(20,4) not null comment '返现金额',
   COMMISSION_AMOUNT    decimal(20,4) comment '返佣金额',
   BUY_POINT            decimal(18,4) comment '购买积分',
   FIRST_BUY_POINT      decimal(18,4) comment '首单积分',
   SALE_UNIT            varchar(50) comment '销售单位',
   CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）',
   LIMIT_COUNT          int not null default 0 comment '限制购买数量(默认为0，不限制)
            每个人限制购买的数量',
   SALE_COUNT           int not null comment '销售数量',
   SEQ_NO               int not null comment '排序号',
   IS_HAVE_FIRST_ORDER  bool comment '是否有首单',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC comment '上线规格';

/*==============================================================*/
/* Table: ONL_ONLINE_SPEC_ATTR                                  */
/*==============================================================*/
create table ONL_ONLINE_SPEC_ATTR
(
   ID                   bigint not null comment '上线规格属性ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
   ATTR_NAME            varchar(50) not null comment '属性名称',
   ATTR_VALUE           varchar(50) not null comment '属性值',
   primary key (ID),
   unique key AK_ONLINE_SPEC_AND_ATTR_NAME_AND_ATTR_VALUE (ONLINE_SPEC_ID, ATTR_NAME, ATTR_VALUE)
);

alter table ONL_ONLINE_SPEC_ATTR comment '上线规格属性';

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
   BUY_POINT            decimal(18,4) comment '购买积分',
   FIRST_BUY_POINT      decimal(18,4) comment '首单积分',
   SALE_UNIT            varchar(50) comment '销售单位',
   CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）',
   LIMIT_COUNT          int not null default 0 comment '限制购买数量(默认为0，不限制)
            每个人限制购买的数量',
   SEQ_NO               int not null comment '排序号',
   IS_HAVE_FIRST_ORDER  bool comment '是否有首单',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC_LOG comment '上线规格日志';

/*==============================================================*/
/* Table: ONL_ONLINE_SPEC_ORDER_REMARK                          */
/*==============================================================*/
create table ONL_ONLINE_SPEC_ORDER_REMARK
(
   ID                   bigint not null comment '上线规格下单备注ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
   REMARK               varchar(20) not null comment '备注',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC_ORDER_REMARK comment '上线规格下单备注';

/*==============================================================*/
/* Table: ONL_SEARCH_CATEGORY                                   */
/*==============================================================*/
create table ONL_SEARCH_CATEGORY
(
   ID                   bigint not null comment '分类ID',
   SELLER_ID            bigint not null comment '卖家ID',
   SHOP_ID              bigint not null comment '店铺ID',
   NAME                 varchar(50) not null comment '分类名称',
   CODE                 varchar(50) not null comment '分类编码',
   REMARK               varchar(50) comment '分类备注',
   IS_ENABLED           bool not null default true comment '是否启用',
   IMAGE                varchar(200) comment '分类图片',
   primary key (ID),
   unique key AK_SHOP_ID_AND_NAME (SHOP_ID, NAME)
);

alter table ONL_SEARCH_CATEGORY comment '搜索分类';

/*==============================================================*/
/* Table: ONL_SEARCH_CATEGORY_ONLINE                            */
/*==============================================================*/
create table ONL_SEARCH_CATEGORY_ONLINE
(
   ID                   bigint not null comment '搜索分类上线ID',
   SEARCH_CATEGORY_ID   bigint not null comment '搜索分类ID',
   ONLINE_ID            bigint not null comment '上线ID',
   primary key (ID)
);

alter table ONL_SEARCH_CATEGORY_ONLINE comment '搜索分类上线';

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

alter table ONL_ONLINE_SPEC_ATTR add constraint FK_Relationship_17 foreign key (ONLINE_SPEC_ID)
      references ONL_ONLINE_SPEC (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC_LOG add constraint FK_Relationship_11 foreign key (ONLINE_LOG_ID)
      references ONL_ONLINE_LOG (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC_LOG add constraint FK_Relationship_12 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_ONLINE_SPEC_ORDER_REMARK add constraint FK_Relationship_16 foreign key (ONLINE_SPEC_ID)
      references ONL_ONLINE_SPEC (ID) on delete restrict on update restrict;

alter table ONL_SEARCH_CATEGORY_ONLINE add constraint FK_Relationship_15 foreign key (ONLINE_ID)
      references ONL_ONLINE (ID) on delete restrict on update restrict;

alter table ONL_SEARCH_CATEGORY_ONLINE add constraint FK_Relationship_18 foreign key (SEARCH_CATEGORY_ID)
      references ONL_SEARCH_CATEGORY (ID) on delete restrict on update restrict;


--2018年9月30日15:42:16 ONL_ONLINE_PIC_LOG去除上线图片（ONL_ONLINE_PIC）关联
alter table onl.ONL_ONLINE_PIC_LOG drop column ONLINE_PIC_ID;
ALTER TABLE `onl`.`ONL_ONLINE_SPEC_LOG` DROP FOREIGN KEY `FK_Relationship_15`;
ALTER TABLE `onl`.`ONL_ONLINE_SPEC_LOG` DROP INDEX `FK_Relationship_15` ;
--2018年9月30日15:05:33 ONL_ONLINE_SPEC_LOG去除上线总数（SALE_COUNT）
alter table onl.ONL_ONLINE_SPEC_LOG drop column SALE_COUNT;
--2018年9月30日14:37:05 ONL_ONLINE_SPEC_LOG去除上线总数（ONLINE_TOTAL）
alter table onl.ONL_ONLINE_SPEC_LOG drop column ONLINE_TOTAL;
--2018年9月30日11:19:16	ONL_ONLINE_SPEC去除上线总数（ONLINE_TOTAL），新加当前上线数量（每次追加的数量）CURRENT_ONLINE_COUNT
alter table onl.ONL_ONLINE_SPEC add CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）';
alter table onl.ONL_ONLINE_SPEC drop column ONLINE_TOTAL;
--2018年9月30日09:54:05在ONL_ONLINE_PIC_LOG中新加上线图片ID（ONLINE_PIC_ID）
alter table onl.ONL_ONLINE_PIC_LOG add ONLINE_PIC_ID  bigint not null comment '上线图片ID';
--2018年9月29日16:24:10在ONL_ONLINE_SPEC_LOG中新加'当前上线数量（CURRENT_ONLINE_COUNT）
alter table onl.ONL_ONLINE_SPEC_LOG add CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）';
--2018年9月28日09:38:40新添：
--	上线日志表（ONL_ONLINE_LOG）
create table ONL_ONLINE_LOG
(
   ID                   bigint not null comment '上线日志ID',
   ONLINE_ID            bigint not null comment '上线ID',
   OP_ID                bigint not null comment '操作人ID',
   OP_TIME              datetime not null comment '操作时间',
   SUBJECT_TYPE         tinyint not null default 0 comment '板块类型（0：普通，1：全返）',
   ONLINE_TITLE         varchar(300) not null comment '上线标题',
   ONLINE_DETAIL        varchar(2000) comment '上线描述',
   PRODUCT_ID           bigint not null comment '产品ID,上一次上线的产品ID',
   primary key (ID)
);

alter table ONL_ONLINE_LOG comment '上线日志';

--	上线规格日志表（ONL_ONLINE_SPEC_LOG）
create table ONL_ONLINE_SPEC_LOG
(
   ID                   bigint not null comment '上线规格日志ID',
   ONLINE_LOG_ID        bigint not null comment '上线日志ID',
   ONLINE_ID            bigint not null comment '上线ID',
   ONLINE_SPEC          varchar(200) not null comment '上线规格',
   SALE_PRICE           decimal(20,4) not null comment '销售价格',
   CASHBACK_AMOUNT      decimal(20,4) not null comment '返现金额',
   COMMISSION_AMOUNT    decimal(20,4) comment '返佣金额',
   SALE_UNIT            varchar(50) comment '销售单位',
   ONLINE_TOTAL         int not null comment '上线总数',
   SALE_COUNT           int not null comment '销售数量',
   SEQ_NO               int not null comment '排序号',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC_LOG comment '上线规格日志';

--	上线图片日志表（ONL_ONLINE_PIC_LOG）
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
--	删除上线规格操作日志表（ONL_ONLINE_SPEC_OP_LOG）
drop ONL_ONLINE_SPEC_OP_LOG

--2018年9月7日09:57:29修改ONL_ONLINE_SPEC返佣金额字段（COMMISSION_AMOUNT）改为返现佣金金额(CASHBACK_COMMISSION_AMOUNT)
--在ONL_ONLINE_SPEC新加字段：上线总数（ONLINE_TOTAL）
alter table onl.ONL_ONLINE_SPEC change COMMISSION_AMOUNT CASHBACK_COMMISSION_AMOUNT decimal(20,4) comment '返现佣金金额';
alter table onl.ONL_ONLINE_SPEC add ONLINE_TOTAL int not null comment '上线总数';
--2018年9月5日15:41:53新加表
/*==============================================================*/
/* Table: ONL_ONLINE_SPEC_OP_LOG                                */
/*==============================================================*/
create table ONL_ONLINE_SPEC_OP_LOG
(
   ID                   bigint not null comment '操作日志id',
   ONLINE_ID            bigint not null comment '上线ID',
   ONLINE_SPEC_ID       bigint not null comment '上线规格ID',
   OP_ID                bigint not null comment '操作人id',
   OP_CONTENT           varchar(100) not null comment '操作内容',
   OP_TIME              datetime not null comment '操作时间',
   primary key (ID)
);

alter table ONL_ONLINE_SPEC_OP_LOG comment '上线规格操作日志信息
记录上线规格份数的调整情况（日志）';
--2018年8月31日10:06:44
alter table onl.ONL_ONLINE change PRODUCE_ID PRODUCT_ID bigint not null comment '产品ID,上一次上线的产品ID';
--2018年8月30日15:57:08在ONL_ONLINE_SPEC中新添返佣金金额字段
alter table onl.ONL_ONLINE_SPEC add COMMISSION_AMOUNT decimal(20,4) comment '返佣金金额';
-- 1.0.8 在onl_online表中新加板块类型
alter table onl.ONL_ONLINE add SUBJECT_TYPE tinyint default 0 comment '板块类型（0：普通，1：全返）';
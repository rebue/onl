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
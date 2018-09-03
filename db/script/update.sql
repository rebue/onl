--2018年8月31日10:06:44
alter table onl.ONL_ONLINE change PRODUCE_ID PRODUCT_ID bigint not null comment '产品ID,上一次上线的产品ID';
--2018年8月30日15:57:08在ONL_ONLINE_SPEC中新添返佣金金额字段
alter table onl.ONL_ONLINE_SPEC add COMMISSION_AMOUNT decimal(20,4) comment '返佣金金额';
-- 1.0.8 在onl_online表中新加板块类型
alter table onl.ONL_ONLINE add SUBJECT_TYPE tinyint default 0 comment '板块类型（0：普通，1：全返）';
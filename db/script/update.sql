-- 2018-11-12
alter table ONL_ONLINE_SPEC                         add     PRODUCT_SPEC_ID      bigint null          comment '产品规格ID';


-- 2018-11-08
alter table ONL_ONLINE_SPEC              add     LIMIT_COUNT              int       not null default 0 comment '限制购买数量(默认为0，不限制)每个人限制购买的数量';
alter table ONL_ONLINE_SPEC_LOG    add     LIMIT_COUNT              int        not null default 0 comment '限制购买数量(默认为0，不限制)每个人限制购买的数量';
alter table ONL_ONLINE                         add     DELIVER_ORG_ID      bigint                                comment '发货组织ID(默认填入上线组织ID，可变更为供应商的ID)';
alter table ONL_ONLINE_LOG               add     DELIVER_ORG_ID      bigint                                comment '发货组织ID(默认填入上线组织ID，可变更为供应商的ID)';
    
-- 2018-11-06
-- alter table onl.ONL_ONLINE           add DELIVER_ORG_TYPE              tinyint comment '发货组织类型（1：本组织发货 2：供应商发货）';
-- alter table onl.ONL_ONLINE_LOG  add DELIVER_ORG_TYPE          tinyint comment '发货组织类型（1：本组织发货 2：供应商发货）';
    

-- 2018-11-5
-- ONL_ONLINE 添加上线组织ID（ONLINE_ORG_ID）
alter table onl.ONL_ONLINE add ONLINE_ORG_ID        bigint not null comment '上线组织ID';
-- ONL_ONLINE_LOG 添加上线组织ID（ONLINE_ORG_ID）
alter table onl.ONL_ONLINE_LOG add ONLINE_ORG_ID        bigint not null comment '上线组织ID';
    

-- 2018-11-05
-- ONL_ONLINE 去除供应商结算类型（SUPPLIER_SETTLE_TYPE）、添加押货类型（PLEDGE_TYPE）
-- alter table onl.ONL_ONLINE drop column SUPPLIER_SETTLE_TYPE;
-- ONL_ONLINE_LOG 去除供应商结算类型（SUPPLIER_SETTLE_TYPE）、添加押货类型（PLEDGE_TYPE）
-- alter table onl.ONL_ONLINE_LOG drop column SUPPLIER_SETTLE_TYPE;
-- ONL_CART 去除供应商结算类型（SUPPLIER_SETTLE_TYPE）、添加押货类型（PLEDGE_TYPE）
-- alter table onl.ONL_CART drop column SUPPLIER_SETTLE_TYPE;    
    
    
-- 2018-11-03
-- ONL_ONLINE 添加供应商ID、供应商结算类型（1：结算到余额 2：结算到货款）
alter table onl.ONL_ONLINE add SUPPLIER_ID          bigint comment '供应商ID';
-- alter table onl.ONL_ONLINE add SUPPLIER_SETTLE_TYPE tinyint comment '供应商结算类型（1：结算到余额 2：结算到货款）';
-- ONL_ONLINE_LOG 添加供应商ID、供应商结算类型（1：结算到余额 2：结算到货款）
alter table onl.ONL_ONLINE_LOG add SUPPLIER_ID          bigint comment '供应商ID';
-- alter table onl.ONL_ONLINE_LOG add SUPPLIER_SETTLE_TYPE tinyint comment '供应商结算类型（1：结算到余额 2：结算到货款）';
-- ONL_CART 添加供应商ID、供应商结算类型（1：结算到余额 2：结算到货款）
-- alter table onl.ONL_CART add SUPPLIER_ID          bigint comment '供应商ID';
-- alter table onl.ONL_CART add SUPPLIER_SETTLE_TYPE tinyint comment '供应商结算类型（1：结算到余额 2：结算到货款）';
-- 2018年11月1日17:36:51 
-- ONL_ONLINE_SPEC 添加成本价格（COST_PRICE）
alter table onl.ONL_ONLINE_SPEC add COST_PRICE           decimal(20,4) comment '成本价格';
-- ONL_ONLINE_SPEC_LOG 添加成本价格（COST_PRICE）
alter table onl.ONL_ONLINE_SPEC_LOG add COST_PRICE           decimal(20,4) comment '成本价格';






    
    
-- --------------------------------------------------------下面已更新到线上------------------------------------------------------------


-- 2018年9月30日15:42:16 ONL_ONLINE_PIC_LOG去除上线图片（ONL_ONLINE_PIC）关联
	alter table onl.ONL_ONLINE_PIC_LOG drop column ONLINE_PIC_ID;
	ALTER TABLE `onl`.`ONL_ONLINE_SPEC_LOG` DROP FOREIGN KEY `FK_Relationship_15`;
	ALTER TABLE `onl`.`ONL_ONLINE_SPEC_LOG` DROP INDEX `FK_Relationship_15` ;
-- 2018年9月30日15:05:33 ONL_ONLINE_SPEC_LOG去除上线总数（SALE_COUNT）
	alter table onl.ONL_ONLINE_SPEC_LOG drop column SALE_COUNT;
-- 2018年9月30日14:37:05 ONL_ONLINE_SPEC_LOG去除上线总数（ONLINE_TOTAL）
	alter table onl.ONL_ONLINE_SPEC_LOG drop column ONLINE_TOTAL;
-- 2018年9月30日11:19:16	ONL_ONLINE_SPEC去除上线总数（ONLINE_TOTAL），新加当前上线数量（每次追加的数量）CURRENT_ONLINE_COUNT
	alter table onl.ONL_ONLINE_SPEC add CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）';
	alter table onl.ONL_ONLINE_SPEC drop column ONLINE_TOTAL;
-- 2018年9月30日09:54:05在ONL_ONLINE_PIC_LOG中新加上线图片ID（ONLINE_PIC_ID）
	alter table onl.ONL_ONLINE_PIC_LOG add ONLINE_PIC_ID  bigint not null comment '上线图片ID';
-- 2018年9月29日16:24:10在ONL_ONLINE_SPEC_LOG中新加'当前上线数量（CURRENT_ONLINE_COUNT）
	alter table onl.ONL_ONLINE_SPEC_LOG add CURRENT_ONLINE_COUNT int not null comment '当前上线数量（每次追加的数量）';
-- 2018年9月28日09:38:40新添：
	-- 上线日志表（ONL_ONLINE_LOG）
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

	-- 上线规格日志表（ONL_ONLINE_SPEC_LOG）
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

	-- 上线图片日志表（ONL_ONLINE_PIC_LOG）
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
	-- 删除上线规格操作日志表（ONL_ONLINE_SPEC_OP_LOG）
	drop ONL_ONLINE_SPEC_OP_LOG

-- 2018年9月7日09:57:29修改ONL_ONLINE_SPEC返佣金额字段（COMMISSION_AMOUNT）改为返现佣金金额(CASHBACK_COMMISSION_AMOUNT)
	-- 在ONL_ONLINE_SPEC新加字段：上线总数（ONLINE_TOTAL）
	alter table onl.ONL_ONLINE_SPEC change COMMISSION_AMOUNT CASHBACK_COMMISSION_AMOUNT decimal(20,4) comment '返现佣金金额';
	alter table onl.ONL_ONLINE_SPEC add ONLINE_TOTAL int not null comment '上线总数';
-- 2018年9月5日15:41:53新加表
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

	alter table ONL_ONLINE_SPEC_OP_LOG comment '上线规格操作日志信息记录上线规格份数的调整情况（日志）';
-- 2018年8月31日10:06:44
	alter table onl.ONL_ONLINE change PRODUCE_ID PRODUCT_ID bigint not null comment '产品ID,上一次上线的产品ID';
-- 2018年8月30日15:57:08在ONL_ONLINE_SPEC中新添返佣金金额字段
	alter table onl.ONL_ONLINE_SPEC add COMMISSION_AMOUNT decimal(20,4) comment '返佣金金额';
-- 1.0.8 在onl_online表中新加板块类型
	alter table onl.ONL_ONLINE add SUBJECT_TYPE tinyint default 0 comment '板块类型（0：普通，1：全返）';
	
	
------------------------------------------以上已更新到线上----------------------------------------
alter table onl.ONL_ONLINE_SPEC add BUY_POINT            decimal(18,4) comment '购买积分';
alter table onl.ONL_ONLINE_SPEC_LOG add BUY_POINT            decimal(18,4) comment '购买积分';

-------------------------------------------以上已更新到线上--------------------------------------------
alter table onl.ONL_ONLINE_SPEC add FIRST_BUY_PONT       decimal(18,4) comment '首单积分';
alter table onl.ONL_ONLINE_SPEC_LOG add FIRST_BUY_PONT       decimal(18,4) comment '首单积分';
	
-------------------------------------------以上已更新到线上-------------------------------------------
alter table ONL_ONLINE_SPEC change FIRST_BUY_PONT FIRST_BUY_POINT  decimal(18,4) comment '首单积分';
alter table ONL_ONLINE_SPEC_LOG change FIRST_BUY_PONT FIRST_BUY_POINT  decimal(18,4) comment '首单积分';
-------------------------------------------以上已更新到线上-------------------------------------------

alter table ONL_ONLINE_SPEC add IS_HAVE_FIRST_ORDER  bool comment '是否有首单';
alter table ONL_ONLINE_SPEC_LOG add IS_HAVE_FIRST_ORDER  bool comment '是否有首单';
-------------------------------------------以上已更新到线上-------------------------------------------
	
	
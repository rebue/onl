-- 修改销量
SET SQL_SAFE_UPDATES = 0;
	update onl.ONL_ONLINE_SPEC a inner join (
	select ONLINE_ID, SPEC_NAME, (sum(BUY_COUNT) - sum(ifnull(RETURN_COUNT, 0))) as SALE_COUNT from ord.ORD_ORDER_DETAIL ood
	left join ord.ORD_ORDER oo on ood.ORDER_ID=oo.ID
	where oo.ORDER_STATE != -1 group by ONLINE_ID, SPEC_NAME
) b on a.ONLINE_ID=b.ONLINE_ID and a.ONLINE_SPEC=b.SPEC_NAME 
set a.SALE_COUNT=b.SALE_COUNT where a.ONLINE_ID=b.ONLINE_ID and a.ONLINE_SPEC=b.SPEC_NAME;
SET SQL_SAFE_UPDATES = 1;
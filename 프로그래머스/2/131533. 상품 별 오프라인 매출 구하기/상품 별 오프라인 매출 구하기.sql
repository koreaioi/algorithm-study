-- 코드를 입력하세요
SELECT p.product_code as PRODUCT_CODE, sum(os.sales_amount * p.price) as SALES
FROM PRODUCT p, OFFLINE_SALE os
where p.product_id = os.product_id
group by p.product_code
order by SALES desc, PRODUCT_CODE asc
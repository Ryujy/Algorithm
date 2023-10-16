-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(o.sales_amount * p.price) AS SALES
FROM PRODUCT p JOIN OFFLINE_SALE o ON p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
ORDER BY SALES desc, p.product_code;
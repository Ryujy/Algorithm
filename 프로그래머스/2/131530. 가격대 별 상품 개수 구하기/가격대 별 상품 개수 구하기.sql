-- 코드를 입력하세요
SELECT 
    (price - (price % 10000)) as PRICE_GROUP
    , count(*)
FROM PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP
;
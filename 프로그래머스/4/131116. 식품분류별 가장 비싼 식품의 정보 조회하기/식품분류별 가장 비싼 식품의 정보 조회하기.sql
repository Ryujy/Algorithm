-- 코드를 입력하세요
select F.CATEGORY, PRICE, PRODUCT_NAME
from food_product f
where price = (SELECT max(price)
    from food_product
    WHERE category in ('과자', '국', '김치', '식용유')
        AND CATEGORY = F.CATEGORY
    group by category)
ORDER BY PRICE DESC
    
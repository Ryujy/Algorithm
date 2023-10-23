-- 코드를 입력하세요
select r1.food_type, r1.rest_id, r1.rest_name, r1.favorites
from 
        rest_info r1,
        (select food_type, max(favorites) as favorites
            from rest_info
            group by food_type
        ) r2
where 
        r1.food_type = r2.food_type 
        and r2.favorites = r1.favorites
order by food_type desc
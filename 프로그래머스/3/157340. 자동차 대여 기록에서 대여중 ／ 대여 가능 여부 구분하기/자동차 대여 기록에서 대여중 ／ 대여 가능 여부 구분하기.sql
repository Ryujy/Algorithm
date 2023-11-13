-- 코드를 입력하세요
select car_id,
    if (
    sum (case
        when '2022-10-16' between start_date and end_date
        then 1
        else 0
    end) > 0, '대여중', '대여 가능') 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc
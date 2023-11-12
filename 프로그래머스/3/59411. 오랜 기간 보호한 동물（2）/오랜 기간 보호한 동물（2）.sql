-- 코드를 입력하세요
select o.ANIMAL_ID, o.NAME
from ANIMAL_INS i join ANIMAL_OUTS o on i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2
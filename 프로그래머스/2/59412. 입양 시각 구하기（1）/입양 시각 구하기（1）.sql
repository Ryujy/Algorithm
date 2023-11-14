-- 코드를 입력하세요
SELECT HOUR(datetime) as HOUR, count(*) as count
from ANIMAL_OUTS
group by HOUR having HOUR > 08 and HOUR < 20
order by HOUR
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, date_format(datetime, '%Y-%m-%d') as '날짜'
from ANIMAL_INS
order by animal_id
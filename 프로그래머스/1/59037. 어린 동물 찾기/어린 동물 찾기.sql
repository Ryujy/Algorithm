-- 코드를 입력하세요
SELECT ANIMAL_ID, name
from animal_ins
where INTAKE_CONDITION != "Aged"
order by ANIMAL_ID
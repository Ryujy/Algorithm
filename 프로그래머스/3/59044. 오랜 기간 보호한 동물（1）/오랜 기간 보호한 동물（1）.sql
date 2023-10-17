-- 코드를 입력하세요
SELECT i.name, i.datetime
FROM ANIMAL_INS i
    LEFT JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.datetime is null
order by i.datetime
limit 3
;
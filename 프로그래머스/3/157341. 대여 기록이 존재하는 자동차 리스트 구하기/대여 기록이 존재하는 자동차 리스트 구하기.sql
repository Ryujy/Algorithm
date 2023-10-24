-- 코드를 입력하세요
SELECT distinct c.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR c
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.car_id = h.car_id
WHERE c.CAR_TYPE = '세단' AND date_format(h.START_DATE, '%m') = '10'
ORDER BY c.CAR_ID DESC
SELECT month(start_date) as month, car_id, count(car_id) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE car_id in (SELECT car_id
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE date_format(START_DATE,"%Y-%m") between '2022-08' and '2022-10'
            group by car_id having count(car_id) > 4)
    and date_format(START_DATE,"%Y-%m") between '2022-08' and '2022-10'
group by month, car_id
order by month, car_id desc
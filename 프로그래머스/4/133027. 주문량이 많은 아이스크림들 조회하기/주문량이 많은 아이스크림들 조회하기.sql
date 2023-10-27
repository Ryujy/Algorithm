-- 코드를 입력하세요
SELECT flavor
FROM FIRST_HALF f
    JOIN (select shipment_id, sum(total_order) as total_order from JULY group by flavor) j
    ON f.SHIPMENT_ID = j.SHIPMENT_ID
group by f.flavor
order by (sum(f.total_order) + sum(j.total_order)) desc
limit 3
;
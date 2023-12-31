# -- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE, "%Y") AS YEAR, DATE_FORMAT(SALES_DATE, "%m") AS MONTH, GENDER, COUNT(DISTINCT S.USER_ID) AS USERS
FROM
ONLINE_SALE S
    JOIN USER_INFO U ON S.USER_ID = U.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER
;
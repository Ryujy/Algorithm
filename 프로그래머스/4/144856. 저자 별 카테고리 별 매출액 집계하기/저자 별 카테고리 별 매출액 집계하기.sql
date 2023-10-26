# SELECT a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, sum(b.PRICE * s.SALES) as TOTAL_SALES
# FROM (SELECT BOOK_ID, SALES
#         FROM BOOK_SALES
#         WHERE date_format(SALES_DATE,'%Y-%m') = '2022-01'
#         GROUP BY BOOK_ID
#      ) s
#     JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
#     JOIN AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
# GROUP BY a.AUTHOR_ID, CATEGORY
# ORDER BY a.AUTHOR_ID, CATEGORY DESC
# ;

SELECT a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, sum(b.PRICE * s.SALES) as TOTAL_SALES
FROM BOOK_SALES s
    JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
    JOIN AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
WHERE date_format(SALES_DATE,'%Y-%m') = '2022-01'
GROUP BY a.AUTHOR_ID, CATEGORY
ORDER BY a.AUTHOR_ID, CATEGORY DESC
;
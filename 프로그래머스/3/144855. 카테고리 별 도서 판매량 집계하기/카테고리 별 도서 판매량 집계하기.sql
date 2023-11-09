# -- 코드를 입력하세요
select CATEGORY, sum(TOTAL_SALES) as TOTAL_SALES
from book b
    join (SELECT book_id, sum(sales) as total_sales
        from BOOK_SALES
        where date_format(sales_date,"%Y-%m") = '2022-01'
        group by book_id) s on b.book_id = s.book_id
group by category
order by category

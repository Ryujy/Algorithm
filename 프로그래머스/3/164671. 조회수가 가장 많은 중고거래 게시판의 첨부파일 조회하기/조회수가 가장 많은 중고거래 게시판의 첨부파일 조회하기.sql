-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) AS FLIE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = (SELECT BOARD_ID
    FROM USED_GOODS_BOARD B
    ORDER BY VIEWS DESC
    LIMIT 1)
order by file_id desc


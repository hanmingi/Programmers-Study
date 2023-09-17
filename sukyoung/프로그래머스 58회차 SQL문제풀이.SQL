===================================================1

-- 코드를 입력하세요
SELECT '/home/grep/src/'||A.BOARD_ID||'/'||A.FILE_ID||A.FILE_NAME||A.FILE_EXT  AS FILE_PATH
FROM USED_GOODS_FILE A
   , USED_GOODS_BOARD B
WHERE A.BOARD_ID = B.BOARD_ID
  AND B.VIEWS = (SELECT MAX(VIEWS) 
                   FROM USED_GOODS_BOARD)
ORDER BY A.FILE_ID DESC

===================================================2
-- 코드를 입력하세요
SELECT CAR_ID                      AS CAR_ID
     , (CASE WHEN CAR_ID IN (
                            SELECT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                             WHERE TO_DATE('20221016','YYYYMMDD') BETWEEN START_DATE AND END_DATE)
         THEN '대여중'
         ELSE '대여 가능'
          END)                     AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC

===================================================3
-- 코드를 입력하세요
SELECT DISTINCT(A.USER_ID)                                           AS USDER_ID
     , A.NICKNAME                                                    AS NICKNAME
     , A.CITY || ' ' || A.STREET_ADDRESS1|| ' ' || A.STREET_ADDRESS2 AS 전체주소
     , '010-' || SUBSTR(A.TLNO,4,4) || '-' ||SUBSTR(A.TLNO,8,4)      AS 전화번호
  FROM USED_GOODS_USER  A
     , USED_GOODS_BOARD B
 WHERE A.USER_ID = B.WRITER_ID
   AND A.USER_ID IN (SELECT WRITER_ID
                       FROM USED_GOODS_BOARD
                      GROUP BY WRITER_ID
                     HAVING COUNT(WRITER_ID)>=3
                        )
  ORDER BY A.USER_ID DESC

===================================================4

-- 코드를 입력하세요
SELECT A.CAR_ID         AS CAR_ID
 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
    , CAR_RENTAL_COMPANY_CAR B
WHERE A.CAR_ID = B.CAR_ID 
  and B.CAR_TYPE = '세단'
  AND TO_CHAR(A.START_DATE,'YYYYMM') = '202210' 
GROUP BY A.CAR_ID
ORDER BY A.CAR_ID DESC

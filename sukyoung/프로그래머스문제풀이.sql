===============================================1
-- 코드를 입력하세요
SELECT A.CATEGORY       AS CATEGORY
     , SUM(B.SALES)     AS TOTAL_SALES
  FROM BOOK       A
     , BOOK_SALES B
 WHERE A.BOOK_ID = B.BOOK_ID
   AND TO_CHAR(B.SALES_DATE,'YYYYMM')= '202201'
 GROUP BY A.CATEGORY
 ORDER BY CATEGORY ASC

===============================================2
-- 코드를 입력하세요
SELECT ORDER_ID                            AS ORDER_ID
     , PRODUCT_ID                          AS PRODUCT_ID
     , TO_CHAR(OUT_DATE, 'YYYY-MM-DD')     AS OUR_DATE
     , CASE WHEN TO_CHAR(OUT_DATE, 'YYYY-MM-DD') <= '2022-05-01'  THEN '출고완료'
            WHEN TO_CHAR(OUT_DATE, 'YYYY-MM-DD') >  '2022-05-01'  THEN '출고대기'
       ELSE '출고미정'
       END AS "출고여부"
 FROM FOOD_ORDER
ORDER BY ORDER_ID;

===============================================3
-- 코드를 입력하세요
SELECT A.WRITER_ID    AS USER_ID
     , B.NICKNAME     AS NICKNAME
     , SUM(A.PRICE)       AS TOTAL_SALES
  FROM USED_GOODS_BOARD A
     , USED_GOODS_USER  B
 WHERE A.WRITER_ID = B.USER_ID
   AND A.STATUS    = 'DONE'
 GROUP BY A.WRITER_ID,B.NICKNAME 
HAVING SUM(A.PRICE)  >= '700000'
 ORDER BY TOTAL_SALES ASC
  
===============================================4
-- 코드를 입력하세요
SELECT A.FOOD_TYPE              AS FOOD_TYPE
     , A.REST_ID                AS REST_ID
     , A.REST_NAME              AS REST_NAME
     , A.FAVORITES              AS FAVORITES
  FROM REST_INFO     A
     , (SELECT FOOD_TYPE        AS FOOD_TYPE
             , MAX(FAVORITES)   AS FAVORITES
          FROM  REST_INFO  
         GROUP BY FOOD_TYPE
       )B
 WHERE A.FOOD_TYPE = B.FOOD_TYPE
   AND A.FAVORITES = B.FAVORITES
 ORDER BY A.FOOD_TYPE DESC
  

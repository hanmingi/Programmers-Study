------------------------------------------------1
-- 코드를 입력하세요
SELECT A.REST_ID                                AS REST_ID
     , A.REST_NAME                              AS REST_NAME
     , A.FOOD_TYPE                              AS FOOD_TYPE
     , A.FAVORITES                              AS FAVORITES
     , A.ADDRESS                                AS ADDRESS
     , ROUND(SUM(B.REVIEW_SCORE) / COUNT(*) ,2) AS SCORE
  FROM REST_INFO    A
     , REST_REVIEW  B
 WHERE A.REST_ID = B.REST_ID
   AND A.ADDRESS LIKE '서울%'
 GROUP BY A.REST_ID, A.REST_NAME,A.FOOD_TYPE, A.FAVORITES, A.ADDRESS
 ORDER BY SCORE DESC, A.FAVORITES DESC;

------------------------------------------------2
-- 코드를 입력하세요
SELECT TO_CHAR(A.SALES_DATE,'YYYY')             AS YEAR
     , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))     AS MONTH
     , B.GENDER                                 AS GENDER
     , COUNT(DISTINCT A.USER_ID)                AS USERS  
  FROM ONLINE_SALE A
     , USER_INFO B
WHERE A.USER_ID = B.USER_ID 
GROUP BY TO_CHAR(A.SALES_DATE,'YYYY')
       , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))
       , B.GENDER
HAVING B.GENDER IS NOT NULL
ORDER BY YEAR ASC, MONTH ASC, GENDER ASC

------------------------------------------------3
-- 코드를 입력하세요
SELECT A.PRODUCT_ID              AS PRODUCT_ID
     , B.PRODUCT_NAME            AS PRODUCT_NAME
     , SUM((A.AMOUNT *B.PRICE))  AS TOTAL_SALES
  FROM FOOD_ORDER    A
     , FOOD_PRODUCT  B
WHERE A.PRODUCT_ID                       = B.PRODUCT_ID
  AND TO_CHAR(A.PRODUCE_DATE , 'YYYYMM') = '202205'
GROUP BY A.PRODUCT_ID
       , B.PRODUCT_NAME       
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID ASC

------------------------------------------------4
-- 코드를 입력하세요

-- MAX 때문에 어쩔수없이 PRODUCT_NAME까지 GROUP BY해야하는데 그러면 결과가 다나와버림
-- SELECT A.CATEGORY       AS CATEGORY
--      , MAX(A.PRICE)     AS MAX_PRICE
--      , A.PRODUCT_NAME   AS PRODUCT_NAME

--   FROM FOOD_PRODUCT A
--  WHERE A.CATEGORY IN ('과자','국','김치','식용유')
--  GROUP BY A.CATEGORY 
--         , A.PRODUCT_NAME
--  ORDER BY MAX(A.PRICE)  DESC;
 
SELECT B.CATEGORY                AS CATEGORY
     , B.PRICE                   AS MAX_PRICE
     , B.PRODUCT_NAME            AS PRODUCT_NAME
  FROM FOOD_PRODUCT B
     , (
         SELECT A.CATEGORY       AS CATEGORY
              , MAX(A.PRICE)     AS MAX_PRICE
           FROM FOOD_PRODUCT A       
          GROUP BY A.CATEGORY 
         HAVING A.CATEGORY IN ('과자','국','김치','식용유')
       ) X
 WHERE B.CATEGORY = X.CATEGORY
   AND B.PRICE    = X.MAX_PRICE
 ORDER BY B.PRICE DESC;

-- 1번문제--------------------
SELECT DISTINCT 
       X.CAR_ID             AS CAR_ID
     , X.CAR_TYPE           AS CAR_TYPE
     , X.DISCOUNT_FEE       AS FEE
  FROM
     (
      SELECT A.HISTORY_ID                                                           AS HISTODY_ID
           , A.CAR_ID                                                               AS CAR_ID
           , A.START_DATE                                                           AS START_DATE
           , A.END_DATE                                                             AS END_DATE
           , B.CAR_TYPE                                                             AS CAR_TYPE
           , B.DAILY_FEE                                                            AS DAILY_FEE
           , B.OPTIONS                                                              AS OPTIONS
           , C.DISCOUNT_RATE                                                        AS DISCOUNT_RATE
           , ROUND((DAILY_FEE * 30) - (DAILY_FEE * 30 * (1/100 * C.DISCOUNT_RATE))) AS DISCOUNT_FEE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
           , CAR_RENTAL_COMPANY_CAR B   
           , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
       WHERE A.CAR_ID   = B.CAR_ID              
         AND B.CAR_TYPE = C.CAR_TYPE
         AND A.CAR_ID NOT IN (  
                            SELECT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY X
                             WHERE TO_CHAR(X.START_DATE ,'YYYYMMDD') <= 20221201
                               AND TO_CHAR(X.END_DATE,'YYYYMMDD') >= 20221101
                             ) 
        AND C.CAR_TYPE IN ('세단','SUV')
        AND C.DURATION_TYPE = '30일 이상'   
     ) X
WHERE X.DISCOUNT_FEE >= 500000
  AND X.DISCOUNT_FEE < 2000000
 ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC

-- 2번문제--------------------
SELECT TO_CHAR(A.SALES_DATE,'YYYY-MM-DD')    AS SALES_DATE      --DATE가 초까지나와서 변환해줘야함
     , A.PRODUCT_ID                          AS PRODUCT_ID
     , A.USER_ID                             AS USER_ID
     , A.SALES_AMOUNT                        AS SALES_AMOUNT
  FROM (
        SELECT X.SALES_DATE         AS SALES_DATE
             , X.PRODUCT_ID         AS PRODUCT_ID
             , X.USER_ID            AS USER_ID
             , X.SALES_AMOUNT       AS SALES_AMOUNT
          FROM ONLINE_SALE X
         WHERE TO_CHAR(X.SALES_DATE,'YYYYMM') = '202203'

        UNION 

        SELECT Y.SALES_DATE         AS SALES_DATE
             , Y.PRODUCT_ID         AS PRODUCT_ID
             , NULL                 AS USER_ID
             , Y.SALES_AMOUNT       AS SALES_AMOUNT
          FROM OFFLINE_SALE Y
         WHERE TO_CHAR(Y.SALES_DATE,'YYYYMM') = '202203'
  
        )A
 ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID  ASC

-- 3번문제--------------------
    SELECT A.MEMBER_NAME                        AS MEMBER_NAME
         , B.REVIEW_TEXT                        AS REVIEW_TEXT
         , TO_CHAR(B.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
      FROM MEMBER_PROFILE A
      JOIN REST_REVIEW B
        ON A.MEMBER_ID = B.MEMBER_ID
     WHERE A.MEMBER_ID IN (   SELECT MEMBER_ID          AS MEMBER_ID
                                FROM REST_REVIEW 
                               GROUP BY MEMBER_ID
                              HAVING COUNT(*) = (  SELECT MAX(COUNT(*))
                                                     FROM REST_REVIEW
                                                 GROUP BY MEMBER_ID))
  ORDER BY TO_CHAR(B.REVIEW_DATE, 'YYYY-MM-DD'),B.REVIEW_TEXT;

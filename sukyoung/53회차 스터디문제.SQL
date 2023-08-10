1===================================================================
SELECT A.TITLE
     , A.BOARD_ID
     , B.REPLY_ID
     , B.WRITER_ID
     , B.CONTENTS
     , TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD')
FROM USED_GOODS_BOARD A
   , USED_GOODS_REPLY B 
WHERE A.BOARD_ID = B.BOARD_ID 
  AND TO_CHAR(A.CREATED_DATE, 'YYYYMM') = '202210' 
order by B.CREATED_DATE ,A.TITLE

2===================================================================
SELECT A.CAR_ID                                   AS CAR_ID
     , ROUND(AVG(A.END_DATE-A.START_DATE + 1),1)  AS AVERAGE_DURATION 
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A 
 GROUP BY A.CAR_ID
HAVING ROUND(AVG(A.END_DATE-A.START_DATE + 1),1) >= 7 --GROUPBY 조건
 ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

3===================================================================
SELECT 
      TO_NUMBER(TO_CHAR(A.START_DATE , 'MM')) AS MONTH
    , A.CAR_ID                                AS CAR_ID
    , COUNT(A.CAR_ID)                         AS RECORDS
FROM (
    SELECT  A.CAR_ID     
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
     WHERE TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
     GROUP BY A.CAR_ID
    HAVING COUNT(A.CAR_ID) >= 5
        ) B
    , CAR_RENTAL_COMPANY_RENTAL_HISTORY  A
WHERE A.CAR_ID = B.CAR_ID
  AND TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
GROUP BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
       , A.CAR_ID
ORDER BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
       , CAR_ID DESC

4===================================================================
SELECT A.HISTORY_ID
     , ROUND(A.DAILY_FEE * A.RENTDATE * (100 - NVL(C.DISCOUNT_RATE, 0)) / 100) AS FEE
  FROM 
    ( SELECT A.CAR_TYPE
           , A.DAILY_FEE
           , B.HISTORY_ID             
           , (B.END_DATE - B.START_DATE ) +1 AS RENTDATE
           , CASE WHEN (B.END_DATE - B.START_DATE) + 1 < 7 THEN '할인없음'
                  WHEN (B.END_DATE - B.START_DATE) + 1 < 30 THEN '7일 이상'
                  WHEN (B.END_DATE - B.START_DATE) + 1 < 90 THEN '30일 이상'
                  ELSE '90일 이상'
                   END AS DURATION_TYPE                    
          FROM CAR_RENTAL_COMPANY_CAR A  
             , CAR_RENTAL_COMPANY_RENTAL_HISTORY B             
         WHERE A.CAR_ID = B.CAR_ID  
           AND A.CAR_TYPE = '트럭'          
  ) A
  , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
WHERE 1=1
 AND A.CAR_TYPE = C.CAR_TYPE
 AND A.DURATION_TYPE = C.DURATION_TYPE 
ORDER BY FEE DESC
       , HISTORY_ID DESC

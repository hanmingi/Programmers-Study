WITH HIST AS (
SELECT B.HISTORY_ID AS HISTORY_ID
     , A.CAR_ID AS CAR_ID
     , A.CAR_TYPE AS CAR_TYPE
     , A.DAILY_FEE AS DAILY_FEE
     , B.DURATION AS DURATION
     , CASE WHEN B.DURATION < 7 THEN ''
            ELSE CASE WHEN B.DURATION < 30 THEN '7일 이상'
            ELSE CASE WHEN B.DURATION < 90 THEN '30일 이상'
            ELSE '90일 이상'
            END END END AS DURATION_TYPE
  FROM CAR_RENTAL_COMPANY_CAR A
     , (SELECT HISTORY_ID
             , CAR_ID
             , END_DATE - START_DATE + 1 AS duration
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) B
 WHERE 1 = 1
   AND A.CAR_ID = B.CAR_ID
   AND A.CAR_TYPE = '트럭')

SELECT H.HISTORY_ID
     , H.DAILY_FEE * H.DURATION * (100 - NVL(A.DISCOUNT_RATE, 0)) / 100 AS FEE
  FROM HIST H
      , CAR_RENTAL_COMPANY_DISCOUNT_PLAN A
  WHERE H.CAR_TYPE = A.CAR_TYPE(+)
    AND H.DURATION_TYPE = A.DURATION_TYPE(+)
 ORDER BY H.DAILY_FEE * H.DURATION * (100 - NVL(A.DISCOUNT_RATE, 0)) / 100 desc, H.HISTORY_ID desc
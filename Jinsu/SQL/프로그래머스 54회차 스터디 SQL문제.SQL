/*******************************************************************************************************/
/* 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/157339?language=oracle#
 */
SELECT DISTINCT 
       X.CAR_ID
     , X.CAR_TYPE
     , X.DISCOUNT_FEE       AS FEE
  FROM
     (
      SELECT A.HISTORY_ID
           , A.CAR_ID
           , A.START_DATE
           , A.END_DATE         
           , B.CAR_TYPE
           , B.DAILY_FEE
           , B.OPTIONS           
           , C.DISCOUNT_RATE 
           , (DAILY_FEE * 30) AS ORG_FEE
           , ROUND((DAILY_FEE * 30) - (DAILY_FEE * 30 * (0.01 * C.DISCOUNT_RATE))) AS DISCOUNT_FEE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
           , CAR_RENTAL_COMPANY_CAR B   
           , (
              SELECT C.*
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
               WHERE 1=1 
                 AND C.CAR_TYPE IN ('세단','SUV')
                 AND C.DURATION_TYPE = '30일 이상'                 
             ) C
       WHERE 1=1 
         AND A.CAR_ID = B.CAR_ID              
         AND B.CAR_TYPE = C.CAR_TYPE (+)
         AND B.CAR_TYPE IN ('세단','SUV')
         AND A.CAR_ID NOT IN (  
                            --이미 대여중인 차 목록
                            SELECT DISTINCT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY X
                             WHERE 1=1
                               AND TO_CHAR(X.START_DATE ,'YYYYMMDD') <= 20221201
                               AND TO_CHAR(X.END_DATE,'YYYYMMDD') >= 20221101
                             ) 
     ) X
WHERE 1=1
  AND X.DISCOUNT_FEE >= 500000
  AND X.DISCOUNT_FEE < 2000000
 ORDER BY FEE DESC
        , CAR_TYPE ASC
        , CAR_ID DESC

/*******************************************************************************************************/


/*******************************************************************************************************/
/* 오프라인/온라인 판매 데이터 통합하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131537
 */
SELECT TO_CHAR(X.SALES_DATE,'YYYY-MM-DD') AS SALES_DATE
     , X.PRODUCT_ID
     , X.USER_ID
     , X.SALES_AMOUNT
  FROM
      (
        SELECT A.SALES_DATE
             , A.PRODUCT_ID
             , A.USER_ID
             , A.SALES_AMOUNT
          FROM ONLINE_SALE A
         WHERE 1=1
           AND TO_CHAR(A.SALES_DATE,'YYYYMM') = '202203'

        UNION ALL

        SELECT B.SALES_DATE
             , B.PRODUCT_ID
             , NULL     AS USER_ID
             , B.SALES_AMOUNT
          FROM OFFLINE_SALE B
         WHERE 1=1
           AND TO_CHAR(B.SALES_DATE,'YYYYMM') = '202203'
      ) X
ORDER BY SALES_DATE ASC
       , PRODUCT_ID ASC
       , USER_ID  ASC
/*******************************************************************************************************/


/*******************************************************************************************************/
/* 그룹별 조건에 맞는 식당 목록 출력하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131124
 */

  SELECT Z.MEMBER_NAME                                AS MEMBER_NAME
       , M.REVIEW_TEXT                                AS REVIEW_TEXT
       , TO_CHAR(M.REVIEW_DATE,'YYYY-MM-DD')          AS REVIEW_DATE       
    FROM REST_REVIEW M       
       , (
         SELECT X.CNT
              , X.MEMBER_ID
           FROM
              (
                SELECT COUNT(A.MEMBER_ID)   AS CNT
                     , A.MEMBER_ID
                  FROM REST_REVIEW A
                 WHERE 1=1  
                  GROUP BY A.MEMBER_ID                
              ) X
             , (
                SELECT MAX(COUNT(A.MEMBER_ID)) AS MAX_CNT
                  FROM REST_REVIEW A
                 GROUP BY A.MEMBER_ID
               ) Y
         WHERE 1=1
           AND X.CNT = Y.MAX_CNT
         ) N 
      , MEMBER_PROFILE Z
  WHERE 1=1
   AND M.MEMBER_ID = N.MEMBER_ID
   AND M.MEMBER_ID = Z.MEMBER_ID
 ORDER BY REVIEW_DATE ASC
        , REVIEW_TEXT ASC 

/*******************************************************************************************************/

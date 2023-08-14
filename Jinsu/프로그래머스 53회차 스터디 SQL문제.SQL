/*******************************************************************************************************/
/* 조건에 부합하는 중고거래 댓글 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/164673?language=oracle
 */

SELECT A.TITLE                               AS TITLE
     , A.BOARD_ID                            AS BOARD_ID
     , B.REPLY_ID                            AS REPLY_ID
     , B.WRITER_ID                           AS WRITER_ID
     , B.CONTENTS                            AS CONTENTS
     , TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD A
   , USED_GOODS_REPLY B
WHERE 1=1
  AND A.BOARD_ID = B.BOARD_ID
  AND TO_CHAR(A.CREATED_DATE, 'YYYYMM') = '202210'
ORDER BY B.CREATED_DATE
       , A.TITLE


/*******************************************************************************************************/
/* 자동차 평균 대여 기간 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/157342?language=oracle
 */

SELECT A.CAR_ID                                   AS CAR_ID
     , ROUND(AVG(A.END_DATE-A.START_DATE + 1),1)  AS AVERAGE_DURATION /* 반올림처리*/
 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
WHERE 1=1  
 GROUP BY A.CAR_ID
HAVING ROUND(AVG(A.END_DATE-A.START_DATE + 1),1) >= 7
ORDER BY AVERAGE_DURATION DESC
       , CAR_ID DESC
/*******************************************************************************************************/




/*******************************************************************************************************/
/* 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/151139?language=oracle
 */
SELECT 
      TO_NUMBER(TO_CHAR(A.START_DATE , 'MM')) AS MONTH
    , A.CAR_ID
    , COUNT(A.CAR_ID) AS RECORDS

FROM (
    SELECT  A.CAR_ID     
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
     WHERE 1=1
       AND TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
       AND TO_CHAR(A.START_DATE,'YYYYMM') <= '202210'   --시작일기준으로 집계
     GROUP BY A.CAR_ID
    HAVING COUNT(A.CAR_ID) >= 5
        ) X -- 총건수 5건 이상 차량번호
    , CAR_RENTAL_COMPANY_RENTAL_HISTORY  A
WHERE 1=1
  AND A.CAR_ID = X.CAR_ID
  AND TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
  AND TO_CHAR(A.START_DATE,'YYYYMM') <= '202210'    --시작일기준으로 집계
  GROUP BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
        , A.CAR_ID
ORDER BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
       , A.CAR_ID DESC
/*******************************************************************************************************/




/*******************************************************************************************************/
/* 자동차 대여 기록 별 대여 금액 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/151141?language=oracle 
*/

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
         WHERE 1=1 
          AND A.CAR_ID = B.CAR_ID  
          AND A.CAR_TYPE = '트럭'          
  ) A
  , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
WHERE 1=1
 AND A.CAR_TYPE = C.CAR_TYPE(+)
 AND A.DURATION_TYPE = C.DURATION_TYPE (+)
ORDER BY FEE DESC
       , HISTORY_ID DESC
/*******************************************************************************************************/


/*******************************************************************************************************/
/* 상품을 구매한 회원 비율 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131534?language=oracle
*/
WITH USER_2021 AS (
    SELECT A.* 
      FROM USER_INFO A
    WHERE 1=1
      AND TO_CHAR(A.JOINED,'YYYY') = '2021'    
)


SELECT TO_CHAR(B.SALES_DATE,'YYYY')             AS YEAR
     , TO_NUMBER(TO_CHAR(B.SALES_DATE,'MM'  ))  AS MONTH
     , COUNT(DISTINCT A.USER_ID) AS PUCHASED_USERS
     , ROUND(COUNT(DISTINCT A.USER_ID) / 
             (SELECT COUNT(*) FROM USER_2021) , 1
            ) AS RATIO
     
 FROM USER_2021 A
    , ONLINE_SALE B    
WHERE 1=1
  AND A.USER_ID = B.USER_ID
GROUP BY TO_CHAR(B.SALES_DATE,'YYYY') 
       , TO_CHAR(B.SALES_DATE,'MM'  )
ORDER BY YEAR
       , MONTH
 /*******************************************************************************************************/
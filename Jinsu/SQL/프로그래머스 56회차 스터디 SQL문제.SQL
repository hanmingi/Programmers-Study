/*******************************************************************************************************/
/* LV4_서울에 위치한 식당 목록 출력하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131118
 */
/*******************************************************************************************************/
SELECT A.REST_ID
     , A.REST_NAME
     , A.FOOD_TYPE
     , A.FAVORITES
     , A.ADDRESS
     , B.SCORE
  FROM REST_INFO A
     , (
         SELECT B.REST_ID
              , ROUND(SUM(B.REVIEW_SCORE) / COUNT(*) ,2) AS SCORE
           FROM REST_REVIEW B
          GROUP BY REST_ID
       ) B
 WHERE 1=1
   AND A.REST_ID = B.REST_ID
   AND A.ADDRESS LIKE '서울%'
 ORDER BY B.SCORE DESC
        , A.FAVORITES DESC
   ;

/*******************************************************************************************************/
/* LV4_년, 월, 성별 별 상품 구매 회원 수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131532
 */
/*******************************************************************************************************/
SELECT TO_CHAR(A.SALES_DATE,'YYYY')             AS YEAR
     , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))    AS MONTH
     , B.GENDER                                 AS GENDER
     , COUNT(DISTINCT A.USER_ID)                AS USERS    --같은사람 중복구매 제외
  FROM ONLINE_SALE A
     , USER_INFO B
WHERE 1=1
  AND A.USER_ID = B.USER_ID (+)
  AND B.GENDER IS NOT NULL
GROUP BY TO_CHAR(A.SALES_DATE,'YYYY')
         , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))
         , B.GENDER
ORDER BY YEAR ASC
       , MONTH ASC
       , GENDER ASC

/*******************************************************************************************************/
/* LV4_5월 식품들의 총매출 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131117
 */
/*******************************************************************************************************/
SELECT A.PRODUCT_ID
     , B.PRODUCT_NAME
     , SUM((A.AMOUNT * B.PRICE)) AS TOTAL_SALES
  FROM FOOD_ORDER A
     , FOOD_PRODUCT B
WHERE 1=1
  AND A.PRODUCT_ID = B.PRODUCT_ID
  AND TO_CHAR(A.PRODUCE_DATE , 'YYYYMM') = '202205'
GROUP BY A.PRODUCT_ID
       , B.PRODUCT_NAME       
ORDER BY TOTAL_SALES DESC
       , A.PRODUCT_ID ASC


/*******************************************************************************************************/
/* LV4_식품분류별 가장 비싼 식품의 정보 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131116
 */
/*******************************************************************************************************/
SELECT A.CATEGORY
     , A.PRICE AS MAX_PRICE
     , A.PRODUCT_NAME
  FROM FOOD_PRODUCT A
     , (
         SELECT X.CATEGORY
             , MAX(X.PRICE) AS MAX_PRICE
          FROM FOOD_PRODUCT X
         WHERE 1=1
           AND X.CATEGORY IN ('과자','국','김치','식용유')
         GROUP BY X.CATEGORY
       ) X
 WHERE 1=1
   AND A.CATEGORY = X.CATEGORY
   AND A.PRICE = X.MAX_PRICE
 ORDER BY A.PRICE DESC
/*******************************************************************************************************/
/* LV3_카테고리 별 도서 판매량 집계하기
 *https://school.programmers.co.kr/learn/courses/30/lessons/144855
 */
/*******************************************************************************************************/
SELECT B.CATEGORY
     , SUM(A.SALES) AS TOTAL_SALES
  FROM BOOK_SALES A
     , BOOK B
  WHERE 1=1
    AND A.BOOK_ID = B.BOOK_ID
    AND TO_CHAR(A.SALES_DATE,'YYYYMM') = '202201'
  GROUP BY B.CATEGORY
  ORDER BY B.CATEGORY ASC


/*******************************************************************************************************/
/* LV3_조건별로 분류하여 주문상태 출력하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131113
 */
/*******************************************************************************************************/
SELECT A.ORDER_ID
     , A.PRODUCT_ID
     , TO_CHAR(A.OUT_DATE,'YYYY-MM-DD') AS OUT_DATE
     , CASE WHEN TO_CHAR(A.OUT_DATE,'YYYYMMDD') <= '20220501' THEN '출고완료'
            WHEN TO_CHAR(A.OUT_DATE,'YYYYMMDD') > '20220501'  THEN '출고대기'
            ELSE '출고미정'
            END AS "출고여부"
 FROM FOOD_ORDER A
 ORDER BY A.ORDER_ID

/*******************************************************************************************************/
/* LV3_조건에 맞는 사용자와 총 거래금액 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/164668
 */
/*******************************************************************************************************/
SELECT A.WRITER_ID
     , B.NICKNAME
     , SUM(PRICE) AS TOTAL_PRICE     
  FROM USED_GOODS_BOARD A
     , USED_GOODS_USER B
 WHERE 1=1
   AND A.STATUS = 'DONE'
   AND A.WRITER_ID = B.USER_ID
 GROUP BY A.WRITER_ID
        , B.NICKNAME
 HAVING SUM(PRICE) >= 700000
 ORDER BY TOTAL_PRICE


/*******************************************************************************************************/
/* LV3_즐겨찾기가 가장 많은 식당 정보 출력하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131123
 */
/*******************************************************************************************************/
SELECT A.FOOD_TYPE
     , A.REST_ID
     , A.REST_NAME
     , A.FAVORITES
 FROM REST_INFO A
    , (
        SELECT B.FOOD_TYPE      AS FOOD_TYPE
             , MAX(B.FAVORITES) AS MAX_FAVORITES
          FROM REST_INFO B
         WHERE 1=1
        GROUP BY B.FOOD_TYPE  
      ) B
WHERE 1=1
  AND A.FOOD_TYPE = B.FOOD_TYPE
  AND A.FAVORITES = B.MAX_FAVORITES
ORDER BY A.FOOD_TYPE DESC
/*******************************************************************************************************/
/* LV4_저자 별 카테고리 별 매출액 집계하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/144856?language=oracle
 */
SELECT M.AUTHOR_ID
     , N.AUTHOR_NAME
     , M.CATEGORY
     , SUM(M.TOTAL_SALES)   AS TOTAL_SALES
 FROM (
        SELECT X.BOOK_ID
             , X.SALES_CNT
             , Y.CATEGORY
             , Y.AUTHOR_ID
             , Y.PRICE
             , (Y.PRICE * X.SALES_CNT)  AS TOTAL_SALES
          FROM (
                -- 2월에 책별로 팔린개수
                SELECT A.BOOK_ID        AS BOOK_ID 
                     , SUM(A.SALES)     AS SALES_CNT
                  FROM BOOK_SALES A
                 WHERE 1=1 
                   AND TO_CHAR(A.SALES_DATE,'YYYYMM') = '202201'
                 GROUP BY A.BOOK_ID
              ) X
              , BOOK Y
        WHERE 1=1 
         AND X.BOOK_ID = Y.BOOK_ID
     ) M
     , AUTHOR N
WHERE 1=1 
  AND M.AUTHOR_ID = N.AUTHOR_ID
GROUP BY M.AUTHOR_ID
       , N.AUTHOR_NAME
       , M.CATEGORY
ORDER BY M.AUTHOR_ID 
       , M.CATEGORY DESC

/*******************************************************************************************************/


/*******************************************************************************************************/
/* LV4_주문량이 많은 아이스크림들 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/133027
 */
SELECT FLAVOR
 FROM (
        SELECT A.FLAVOR
             , (A.TOTAL_ORDER + B.TOTAL_ORDER) AS TOTAL_ORDER
          FROM FIRST_HALF A
             , (
                SELECT B.FLAVOR
                     , SUM(B.TOTAL_ORDER) AS TOTAL_ORDER
                  FROM JULY B
                 GROUP BY B.FLAVOR
               ) B
         WHERE 1=1
          AND A.FLAVOR = B.FLAVOR
        ORDER BY TOTAL_ORDER DESC  
     ) X
WHERE 1=1
  AND ROWNUM <= 3
/*******************************************************************************************************/

/*******************************************************************************************************/
/* LV4_취소되지 않은 진료 예약 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/132204
 */
SELECT A.APNT_NO
     , C.PT_NAME
     , A.PT_NO
     , A.MCDP_CD
     , B.DR_NAME
     , A.APNT_YMD -- 데이터형식 TIMESTAMP임 그대로출력
  FROM APPOINTMENT A
     , DOCTOR B
     , PATIENT C     
 WHERE 1=1 
  AND A.MDDR_ID = B.DR_ID
  AND A.PT_NO = C.PT_NO
  AND A.APNT_CNCL_YN = 'N'
  AND A.MCDP_CD = 'CS'
  AND TO_CHAR(A.APNT_YMD ,'YYYYMMDD') = '20220413'
  ORDER BY APNT_YMD ASC
/*******************************************************************************************************/

--저자 별 카테고리 별 매출액 집계하기

SELECT P.AUTHOR_ID          AS AUTHOR_ID
     , Q.AUTHOR_NAME        AS AUTHOR_NAME
     , P.CATEGORY           AS CATEGORY
     , SUM(P.TOTAL_SALES)   AS TOTAL_SALES
 FROM (
        SELECT X.BOOK_ID                   AS BOOK_ID
             , Y.CATEGORY                  AS CATEGORY
             , Y.AUTHOR_ID                 AS AUTHOR_ID
             , Y.PRICE                     AS PRICE
             , (Y.PRICE * (SUM(X.SALES)))  AS TOTAL_SALES
          FROM  BOOK_SALES X
             ,  BOOK       Y
        WHERE X.BOOK_ID = Y.BOOK_ID
          AND TO_CHAR(X.SALES_DATE,'YYYYMM') = '202201'
        GROUP BY X.BOOK_ID
               , Y.CATEGORY  
               , Y.AUTHOR_ID 
               , Y.PRICE 
     ) P
     , AUTHOR Q
WHERE P.AUTHOR_ID = Q.AUTHOR_ID
GROUP BY P.AUTHOR_ID
       , Q.AUTHOR_NAME
       , P.CATEGORY
ORDER BY P.AUTHOR_ID ASC 
       , P.CATEGORY  DESC

--주문량이 많은 아이스크림들 조회하기
-- 코드를 입력하세요
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
         WHERE A.FLAVOR = B.FLAVOR
         ORDER BY TOTAL_ORDER DESC  
     ) X
 WHERE ROWNUM <= 3

--취소되지않은 진료예약 조회하기
-- 코드를 입력하세요
SELECT A.APNT_NO            AS APNT_NO
     , C.PT_NAME            AS PT_NAME
     , A.PT_NO              AS PT_NO
     , A.MCDP_CD            AS MCDP_CD
     , B.DR_NAME            AS DR_NAME
     , A.APNT_YMD           AS APNT_YMD  --결과다나와야함초까지
  FROM APPOINTMENT A
     , DOCTOR B
     , PATIENT C     
 WHERE A.PT_NO          = C.PT_NO 
   AND A.MDDR_ID        = B.DR_ID
   AND A.APNT_CNCL_YN   = 'N'       --예약취소여부 취소안된사람들
   AND A.MCDP_CD        = 'CS'      --CS흉부
   AND TO_CHAR(A.APNT_YMD ,'YYYYMMDD') = '20220413' 
 ORDER BY APNT_YMD ASC

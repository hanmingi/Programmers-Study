/*******************************************************************************************************/
/* LV3_조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/164671
 */
/*******************************************************************************************************/
SELECT '/home/grep/src/'||A.BOARD_ID||'/'||A.FILE_ID||A.FILE_NAME||A.FILE_EXT
         AS FILE_PATH
  FROM USED_GOODS_FILE A
     , (
        SELECT *
          FROM (
                SELECT MAX(VIEWS) AS MAX_VIEWS
                     , BOARD_ID
                  FROM USED_GOODS_BOARD 
                  GROUP BY BOARD_ID
                  ORDER BY 1 DESC
               )
        WHERE 1=1
          AND ROWNUM < 2
       ) B
 WHERE 1=1
   AND A.BOARD_ID = B.BOARD_ID
 ORDER BY A.FILE_ID DESC



/*******************************************************************************************************/
/* LV3_자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/157340
 */
/*******************************************************************************************************/
SELECT A.CAR_ID
     , MAX(CASE WHEN TO_DATE('20221016','YYYYMMDD') BETWEEN A.START_DATE AND A.END_DATE
            THEN '대여중'
            ELSE '대여 가능'
            END) AS AVAILABILITY
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
 WHERE 1=1 
 GROUP BY A.CAR_ID
 ORDER BY A.CAR_ID DESC  


/*******************************************************************************************************/
/* LV3_조건에 맞는 사용자 정보 조회하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/164670
 */
/*******************************************************************************************************/

SELECT A.USER_ID
     , A.NICKNAME
     , A.CITY || ' ' || A.STREET_ADDRESS1|| ' ' || A.STREET_ADDRESS2 AS 전체주소
     , SUBSTR(A.TLNO,0,3) || '-' || SUBSTR(A.TLNO,4,4) || '-' ||SUBSTR(A.TLNO,8,4)    AS 전화번호
  FROM USED_GOODS_USER A
 WHERE 1=1 
   AND A.USER_ID IN (SELECT B.WRITER_ID
                         -- , COUNT(B.WRITER_ID) AS CNT
                      FROM USED_GOODS_BOARD B
                      GROUP BY B.WRITER_ID
                      HAVING COUNT(B.WRITER_ID) > 2
                        )
  ORDER BY A.USER_ID DESC
  


/*******************************************************************************************************/
/* LV3_대여 기록이 존재하는 자동차 리스트 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/157341
 */
/*******************************************************************************************************/

SELECT A.CAR_ID
 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
    , CAR_RENTAL_COMPANY_CAR B
WHERE 1=1
  AND A.CAR_ID = B.CAR_ID (+)
  AND TO_CHAR(A.START_DATE,'YYYYMM') = '202210' 
  AND B.CAR_TYPE = '세단'
GROUP BY A.CAR_ID
ORDER BY A.CAR_ID DESC
  

-- 코드를 입력하세요
SELECT order_id
     , product_id
     , to_char(out_date, 'YYYY-MM-DD') as out_date
     , case when to_char(out_date, 'YYYYMMDD') <= '20220501'
            then '출고완료'
            when to_char(out_date, 'YYYYMMDD') > '20220501'
            then '출고대기'
            else '출고미정'
             end as 출고여부
  from food_order fo
 where 1 = 1
 order by order_id

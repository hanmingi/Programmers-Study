-- 코드를 입력하세요
SELECT *
  from (select to_char(sales_date, 'YYYY-MM-DD') AS SALES_DATE
             , product_id
             , user_id
             , sales_amount
          from online_sale
         where to_char(sales_date, 'YYYYMM') = '202203'
         union all
        select to_char(sales_date, 'YYYY-MM-DD') as SALES_DATE
             , product_id
             , NULL as USER_ID
             , sales_amount
          from offline_sale
         where to_char(sales_date, 'YYYYMM') = '202203'
       )
 ORDER BY sales_date, product_id, user_id
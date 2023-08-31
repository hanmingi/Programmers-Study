select fp.product_id
     , fp.product_name
     , fp.price * fo.amount as total_sales
  from food_product fp
     , (select product_id
             , sum(amount) as amount
          from food_order
         where 1 = 1
           and to_char(produce_date, 'YYYY-MM') = '2022-05'
         group by product_id) fo
 where 1 = 1
   and fp.product_id = fo.product_id
 order by 3 desc, 1;
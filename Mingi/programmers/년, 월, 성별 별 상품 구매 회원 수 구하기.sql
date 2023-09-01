select to_char(os.sales_date, 'YYYY') as year
     , to_number(to_char(os.sales_date, 'MM')) as month
     , ui.gender
     , count(distinct(ui.user_id)) as users
  from online_sale os
     , user_info ui
 where 1 = 1
   and os.user_id = ui.user_id
 group by to_char(b.sales_date, 'YYYY')
     , to_number(to_char(os.sales_date, 'MM'))
     , ui.gender
 having ui.gender is not null
 order by year asc
     , month asc
     , ui.gender asc
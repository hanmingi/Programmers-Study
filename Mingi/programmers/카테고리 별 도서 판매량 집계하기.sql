-- 코드를 입력하세요
SELECT b.category
     , sum(bs.sales) as total_sales
  from book b
     , book_sales bs
 where 1 = 1
   and b.book_id = bs.book_id
   and to_char(bs.sales_date, 'YYYYMM') = '202201'
 group by b.category
 order by category asc
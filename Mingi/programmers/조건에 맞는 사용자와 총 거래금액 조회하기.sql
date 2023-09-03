-- 코드를 입력하세요
SELECT ugb.writer_id    as user_id
     , ugu.nickname     as nickname
     , sum(ugb.price)   as total_sales
  from used_goods_board ugb
     , used_goods_user ugu
 where 1 = 1
   and ugb.writer_id = ugu.user_id
   and ugb.status = 'DONE'
 group by ugb.writer_id
     , ugu.nickname
having sum(ugb.price) >= '700000'
 order by total_sales asc
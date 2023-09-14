-- 코드를 입력하세요
select u.user_id
     , u.nickname
     , u.city || ' ' || u.street_address1 || ' ' || u.street_address2
     , CASE WHEN LENGTH(TLNO) = 11 THEN SUBSTR(TLNO,0,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4)
    END AS 전화번호
  from used_goods_user u
     , (SELECT writer_id, count(*)
         from used_goods_board u
        where 1 = 1
        group by writer_id
        having count(*) >= 3) c
 where 1 = 1
   and u.user_id = c.writer_id
 order by u.user_id desc
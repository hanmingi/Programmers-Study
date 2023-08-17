-- 코드를 입력하세요
SELECT a.member_name
     , b.review_text
     , to_char(b.review_date, 'YYYY-MM-DD') AS review_date
  from member_profile a
 inner join rest_review b
    on a.member_id = b.member_id
 where a.member_id in (select member_id
                         from rest_review
                        group by member_id
                        having count(*) = (select max(count(*))
                                             from rest_review
                                            group by member_id))
order by 3, 2
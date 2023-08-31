select rr.rest_id
     , ri.rest_name
     , ri.food_type
     , ri.favorites
     , ri.address
     , round(avg(rr.review_score), 2) as score
  from rest_review rr
     , rest_info ri
 where 1 = 1
   and rr.rest_id = ri.rest_id
 group by rr.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address
 having ri.address like '서울%'
 order by score desc
     , ri.favorites desc
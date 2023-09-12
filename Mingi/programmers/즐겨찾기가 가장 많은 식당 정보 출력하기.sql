-- 코드를 입력하세요
select ri.food_type
     , ri.rest_id
     , ri.rest_name
     , ri.favorites
  from rest_info ri
     , (SELECT food_type
             , max(favorites) as favorites
          from rest_info ri
         where 1 = 1
         group by food_type) fa
 where 1 = 1
   and ri.food_type = fa.food_type
   and ri.favorites = fa.favorites
 order by ri.food_type desc


 
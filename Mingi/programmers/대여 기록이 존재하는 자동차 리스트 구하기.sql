-- 코드를 입력하세요
select a.car_id
  from car_rental_company_rental_history a
     , (
        SELECT c.car_id
          from car_rental_company_car c
         where 1 = 1
           and c.car_type = '세단'
         ) b
 where 1 = 1
   and a.car_id = b.car_id
   and to_char(a.start_date, 'YYYYMM') between '202210' and '202211'
 group by a.car_id
 order by a.car_id desc
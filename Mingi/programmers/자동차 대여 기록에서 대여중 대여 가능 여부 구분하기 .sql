-- 코드를 입력하세요
SELECT c.car_id as CAR_ID
     , max(case when '20221016' between to_char(c.start_date, 'YYYYMMDD') and to_char(c.end_date, 'YYYYMMDD')
            then '대여중'
            else '대여 가능'
             end ) as AVAILABILITY
  from car_rental_company_rental_history c
 where 1 = 1
 group by c.car_id
 order by c.car_id desc
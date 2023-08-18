select cc.car_id as car_id
     , cc.car_type as car_type
     , round((cc.daily_fee * (100 - discount_rate) / 100 * 30), 0) as FEE
  from CAR_RENTAL_COMPANY_CAR cc
     , CAR_RENTAL_COMPANY_DISCOUNT_PLAN cdp
 where 1 = 1
   and cc.car_type in ('SUV', '세단')
   and cc.car_id not in (select car_id
                           from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                          where to_date('2022-11', 'YYYY-MM') between start_date and end_date)
   and cc.car_type = cdp.car_type
   and duration_type = '30일 이상'
   and round((cc.daily_fee * (100 - discount_rate) / 100 * 30), 0) between 500000 and 2000000
 order by fee desc
     , car_type asc
     , car_id desc
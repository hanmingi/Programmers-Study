select ('/home/grep/src/' || ugf.board_id || '/' || ugf.file_id || ugf.file_name || ugf.file_ext) as file_path
  from used_goods_file ugf
     , (select board_id
          from (select *
                  from used_goods_board ugb
                 where 1 = 1
                 order by ugb.views desc) ugb
         where 1 = 1
           and rownum = 1) ugb
 where 1 = 1
   and ugf.board_id = ugb.board_id
 order by ugf.file_id desc
 
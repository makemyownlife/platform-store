基础配置:

实现如何加载数据？
1 配置选项最大保存多久的信息, 每个文件片段默认1个小时
2 加载checkpoint文件
3 理论上一天1个文件 每天删除过期文件,每天加载1个小时的数据（索引文件)
目录结构:
--platform
    --store
      --date
         --20200523
             --data
                --000000000000000000000
                --000000000000000001024
             --index
                --01
                --02
                --03
      --checkpoint
         --checkpoint.file

      

# 需要对smsqlserver的插入语句进行转换，转换成中间数据，数据规则是：
字段之间用指定分隔符分隔，NULL字段用’’替代等
考虑到以后数据量大，一个个一条条去做太麻烦。于是写了一个程序去完成。
配置：
dataformat.record.count=5
dataformat.column.separate=\1111 #自己规定的一个字符
dataformat.record.separate=\n  #换行
datasourse.path=F:\\workspace\\liuzhou\\sql #Insert语句的源sql文件文件夹地址（可用Navicat导出向导导出sql文件）
运行：
http://localhost:8080/dat/export

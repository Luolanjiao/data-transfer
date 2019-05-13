### 领导要做数据抽取，将数据抽出几条，以规定格式生成.dat和.ok文件</br>
需要对smsqlserver的插入语句进行转换，转换成中间数据，数据规则是：
字段之间用指定分隔符分隔，NULL字段用’’替代等
考虑到以后数据量大，一个个一条条去做太麻烦。于是写了一个程序去完成。</br>
配置：</br>
dataformat.record.count=5</br>
dataformat.column.separate=\1111 ##自己规定的一个字符</br>
dataformat.record.separate=\n  ##换行</br>
datasourse.path=F:\\workspace\\liuzhou\\sql #Insert语句的源sql文件文件夹地址（可用Navicat导出向导导出sql文件）</br>
运行：</br>
http://localhost:8080/dat/export</br>

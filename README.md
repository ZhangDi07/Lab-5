# Lab-5
第五次试验 11.23  
计G201 2020322063 张迪
##实验内容  
1.在桌面创建一个文本B，写入《长恨歌》。在创建一个空白的文本A  
2.要求：  
每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  
允许提供输入参数，统计古诗中某个字或词出现的次数  
考虑操作中可能出现的异常，在程序中设计异常处理程序  
3.将处理后的信息存储到文件A中  

##实验目的  
1.掌握字符串String及其方法的使用  
2.掌握文件的读取/写入方法  
3.掌握异常处理结构

##实验过程  
1.首先创建一个学生基本信息类（Student），定义了name,stu_num,lv,sex属性，创建无参和有参的构造方法，给这些属性赋值。生成了set和get方法。
2.再创建一个Up_homework类，抛出异常。先从键盘接收数据，然后判断了是否还有输入。scan.next()返回值是字符串类型的所以需要将字符串转换为数字格式。  
3.写upfile方法，用到了字符流，因为只涉及自负相关的操作。然后把信息写入到文本A中，
4.读取输入的文件，并根据读取的内容创建String对象
5.插入逗号、句号和换行，用if语句进行判断第多少个字时插入
##核心方法  

##实验结果
结果1：  
![alt console](https://m.qpic.cn/psc?/V50ini880vFPiW2LYxFK2RoQRD3UEErn/bqQfVz5yrrGYSXMvKr.cqViWeg6HBQ*TGdsH1ziwaDQ4z5Ce*wTUT5c3E5*sEUoEBgHQUFsqpXjLTISkJdCXA52nQn6r7PqZxLLGn6H.ppc!/b&bo=qgJSAQAAAAADB9k!&rf=viewer_4)  
结果2：
![alt console]()

##实验感想  

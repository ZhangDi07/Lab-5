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
1.定义学生的基本信息类，学生的基本信息类中包括  
姓名：name;  
学号：stu_num;  
班级：lv; 
性别：sex;   
这四个属性，定义构造方法给这些属性赋值，并生成set、get方法；    
2.再创建一个Up_homework类，抛出异常。利用scanner先从键盘接收数据，然后判断是否还有输入。  
因为scan.next()返回的类型是字符串类型的所以学号需要将字符串转换为数字格式，同时在输入学号的代码处捕获了异常；    
3.定义把学生信息写入到A中的upfile方法，方法选择的是字符流，因为本例子只涉及到字符的相关操作，所以用字符流效率更高，   
前面因为已经利用scanner给学生基本信息类赋值了，所以这边直接利用get获取，然后利用字符流中输出流将信息输出到文件中；  
定义读取输入文件readfile方法，读取输入的信息，利用if来判断插入的位置和奇偶，利用StringBuilder中的insert的方法对数据进行相关的操作，  
由于数据同时插入会导致字符串错位且复杂，采用分步的操作来实现需求，分步具体为第一步加入“。”号，将数据存储，第二步加入“，”号，最后进行换行操作，待这三步完成后返回最终的处理的字符串，利用upfile方法将数据输出到文件中；  
4.定义查询findword字符/字符串方法，通过利用不同的参数来进行不同的查询操作，  
findword(char word,String str)对应字符的操作；  
findword(String word,String str)对应字符串的操作；  

##核心方法  
1.构造方法（无参、有参）：  
```
public Student() {
		
	}
	public Student(String name,Integer stu_num,String lv,String sex) {
		this.name=name;
		this.stu_num=stu_num;
		this.lv=lv;
		this.sex=sex;
	}
  ```
  2.部分set、get方法：  
  ```
  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
  ```
  3.插入句号的方法：
  ```
  for(int i=0;i<s.length();i++) {
					if(i%7==0&&i!=0) {
						if(i%2==0) {//偶数
								
						        	//在第i个字符前插
									sum=sum+1;
									int a=i+sum;
									stb.insert(a,"。");
						}

					}
				}
```
4.插入逗号的方法：
```
for(int i=0;i<s.length();i++) {
			if(i%7==0&&i!=0) {
				if(i%2!=0) {
					if(sumtw==0){
						sumtw=sumtw+1;
						int a=i+sumtw;
						stbtw.insert(a,",");
			}else{
				sumtw=sumtw+2;
				int a=i+sumtw;
				stbtw.insert(a,",");
			}
								
				}

			}
		}
```
5.插入换行的方法：
```
for(int i=0;i<datas.length();i++) {
			if(i%16==0&&i!=0) {//在句号后面插入换行符
				sumth=sumth+1;
				int a=i+sumth;
				stbth.insert(a, "\n");
			}

		}
```
6.写入数据的方法：
```
char[] data= datastr.toCharArray();//将datastr转化为char数组
	   	      	char[] da= input.toCharArray();//将datastr转化为char数组
	   	       		wt.write(data);//写入数据
	   	       		wt.write(da);
	   	       		wt.flush();//立即写入
	   	       		wt.close();//关闭流
```
7.读取数据的方法：
```
		Reader rd=new FileReader(file);
		char[] data = new char[1024];
		int len;
		while((len=rd.read(data))!=-1) {
			 s = new String(data,0,len);			//根据读取文件的内容创建String 对象
				}
```
8.判断某个字或词出现次数的方法：
```
while (str.indexOf(word) != -1) {
	            // 如果存在相同字符串则次数加1
	            count++;
	           // 调用String类的substring(int beginIndex)方法，获得第一个相同字符出现后的字符串
	            str = str.substring(str.indexOf(word)
	            + word.length());
	
		}
	       System.out.println(word+"出现的次数为："+count);
```

##实验结果
结果1：  
![alt console](https://m.qpic.cn/psc?/V50ini880vFPiW2LYxFK2RoQRD3UEErn/bqQfVz5yrrGYSXMvKr.cqViWeg6HBQ*TGdsH1ziwaDQ4z5Ce*wTUT5c3E5*sEUoEBgHQUFsqpXjLTISkJdCXA52nQn6r7PqZxLLGn6H.ppc!/b&bo=qgJSAQAAAAADB9k!&rf=viewer_4)  
结果2：
![alt console](https://m.qpic.cn/psc?/V50ini880vFPiW2LYxFK2RoQRD3UEErn/bqQfVz5yrrGYSXMvKr.cqe1ChMD7qqdE8uqjio9kJdw1ubKXfReOHosKAuiTCr1meRCnQ9d6*.smy8orGNlvZd*FPry0Zr8o4LkNEpyKoUA!/b&bo=owasAwAAAAABByo!&rf=viewer_4)

##实验感想  
通过本次实验，主要学会了文件的读写方法，以及对内容进行处理（加逗号、句号和换行）。在写的过程中遇到了很多问题，比如B中的内容无法复制到文本A中，换行无法显示，文本A中的内容乱码等等。在解决过程中印象最深的就是B中的内容无法复制到文本A中，首先要搞清楚自己写的代码中到底哪个是写入，要写对应的文件地址，这个十分重要！文本A中的内容乱码，需要更改字符编码UTF-8。还掌握了对字符串String和方法的使用。感觉这次实验最难的部分就是输入输出流，虽然写出来了，但还是有点蒙。。。需要更深入的学习理解。总之，通过本次实验，又使自己有了提高~

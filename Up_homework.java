package zd.upfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

public class Up_homework {
	 String name;
	 Integer stu_num;
	 String lv;
	 String sex;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        // 从键盘接收数据      
        // 判断是否还有输入
		System.out.println("请输入姓名：" );
        if (scan.hasNext()) {
            String name = scan.next();
            //因为scan.next()返回值是字符串类型的所以需要将字符串转换为数字格式
            System.out.println("请输入学号：" );
            try {
            	Integer stu_num=Integer.valueOf(scan.next());
                System.out.println("请输入班级：" );
                String lv = scan.next();
                System.out.println("请输入性别：" );
                String sex = scan.next();
                System.out.println("输入的数据为：姓名： " + name+"   学号：   "+stu_num+"  班级 ：   "+lv+"  性别 ： "+sex);
                Student st=new Student(name, stu_num, lv, sex);
                Up_homework up=new Up_homework();
                up.upfile(st,up.readfile());
                System.out.println("请输入要查询的数据");
                String word=scan.next();
                if(word.length()>1&&word.length()!=0){
                	up.findword(word, up.readfile());
                }else{
                	char[] w=word.toCharArray();
                	for(char c:w){
                		up.findword(c, up.readfile());
                	}
                	
                }
            }catch (Exception e) {
				// TODO: handle exception
            	
            	System.out.println("发生异常："+e.getMessage());
			}
           
        }
        scan.close();
        

	}
	 
    //选择字符流，因为本例子只涉及到字符的相关操作，所以用字符流效率更高；
    //首先先把学生信息写入到A中
   public void upfile(Student stu,String input) {
	   File file=new File("C:\\Users\\zd\\Desktop\\A.txt"); 
       if(!file.exists()) {//如果文件不存在
    	   
   	       	try {
   	       		//新建文件
				file.createNewFile();
				Writer wt = new FileWriter(file);//对应上面的路径
				//要输入的字符串数据datastr
	   	      	String datastr="学生基本信息：\r\n姓名： " + stu.getName()+"\r\n   学号：   "+stu.getStu_num()+" \r\n 班级 ：   "+stu.getLv()+"\r\n  性别 ： "+stu.getSex()+"\r\n###################### ";
	   	       	//wt.write();方法要求传入char[]类型的数据
	   	      	char[] data= datastr.toCharArray();//将datastr转化为char数组
	   	      	char[] da= input.toCharArray();//将datastr转化为char数组
	   	       		wt.write(data);//写入数据
	   	       		wt.write(da);
	   	       		wt.flush();//立即写入
	   	       		wt.close();//关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

       }else {
    	   
		try {
			Writer wt = new FileWriter(file);//对应上面的路径
			//要输入的字符串数据datastr
   	      	String datastr="学生基本信息：\r\n姓名：" + stu.getName()+"\r\n学号："+stu.getStu_num()+"\r\n班级 ："+stu.getLv()+"\r\n性别 ："+stu.getSex()+"\r\n##########结束###########\r\n";
   	       	//wt.write();方法要求传入char[]类型的数据
   	      	char[] data= datastr.toCharArray();//将datastr转化为char数组
   	      	char[] da= input.toCharArray();//将datastr转化为char数组
   	       		wt.write(data);//写入数据
   	       		wt.write(da);
   	       		wt.flush();//立即写入
   	       		wt.close();//关闭流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	      	
		
     
       }
   }
   //读取输入文件
   //并返回处理后的数据
   public String readfile() throws IOException {
	   String dataput=null;
	   String s = null;
	   File file=new File("C://Users//zd//Desktop//B.txt");
	   if(!file.exists()) {
		   System.err.println("对不起指定文件不存在。。。。");
	   }else {
		   try {
				Reader rd=new FileReader(file);
				char[] data = new char[1024];
				int len;
				while((len=rd.read(data))!=-1) {
					 s = new String(data,0,len);			//根据读取文件的内容创建String 对象
					
					
				}
				StringBuilder stb = new StringBuilder();
				stb.append(s);
				int sum=0;
				int sumtw=0;
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
				StringBuilder stbtw= new StringBuilder();
				String da=stb.toString();
				stbtw.append(da);
				for(int i=0;i<s.length();i++) {
					if(i%7==0&&i!=0) {
						if(i%2!=0) {//ji数
						        	//在第i个字符前插
								
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
				String datas=stbtw.toString();
				StringBuilder stbth= new StringBuilder();
				stbth.append(datas);

				int sumth=0;
				for(int i=0;i<datas.length();i++) {
					if(i%16==0&&i!=0) {//在句号后面插入换行符
						sumth=sumth+1;
						int a=i+sumth;
						stbth.insert(a, "\n");
					}

				}
				dataput=stbth.toString();
				 //System.out.println(stbth.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   return dataput;
	 
   }
	   public void findword(char word,String str){
			char c[]=str.toCharArray();				//将字符串变为字符数组
			int sum=0;								//声明整形变量
			for(int i=0;i<c.length;i++)
			{
				if(c[i]==word){
					sum++;
				}
			}
			System.out.println(word+"的个数："+sum);
	  }
	public void findword(String word,String str){
		int count = 0;
	  // 调用String类的indexOf(String str)方法，返回第一个相同字符串出现的下标
		while (str.indexOf(word) != -1) {
	            // 如果存在相同字符串则次数加1
	            count++;
	           // 调用String类的substring(int beginIndex)方法，获得第一个相同字符出现后的字符串
	            str = str.substring(str.indexOf(word)
	            + word.length());
	
		}
	       System.out.println(word+"出现的次数为："+count);
	 }

}

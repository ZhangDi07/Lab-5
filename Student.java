package zd.upfile;

public class Student {
	//	学生的基本信息类
	//	姓名：狗子；
	//	学号：17001；
	//	班级：02；
	//	性别：男；
	private String name;
	private Integer stu_num;
	private String lv;
	private String sex;
	//无参构造方法
	public Student() {
		
	}
	//有参构造方法是给这些属性赋值的
	public Student(String name,Integer stu_num,String lv,String sex) {
		this.name=name;
		this.stu_num=stu_num;
		this.lv=lv;
		this.sex=sex;
	}
	//set  and get
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStu_num() {
		return stu_num;
	}
	public void setStu_num(Integer stu_num) {
		this.stu_num = stu_num;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}

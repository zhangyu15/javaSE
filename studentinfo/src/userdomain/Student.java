package userdomain;
/*
 * 学生信息包括，学号，姓名，性别，年龄，和一门课程
 */
public class Student {
	private String id;
	private String name;
	private String sex;
	private int age;
	private String course;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name, String sex, int age, String course) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", course=" + course + "]";
	}
	
}

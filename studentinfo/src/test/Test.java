package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import userdao.Login;
import userdao.UserDao;
import userdomain.Student;
import userdomain.UserAccount;

public class Test {
	public static void main(String[] args) {
		System.out.println("-------------------欢迎使用本系统，请您登录-----------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("账号：");
		String id=sc.nextLine();
		System.out.print("密码：");
		String password=sc.nextLine();
		//创建可以调用方法的对象
		Login login=new Login();
		UserDao userDao=new UserDao();
	    int isSuper=login.login(id, password);
	    
	    if(isSuper==2){
	    	boolean b=false;		
			System.out.println("------------------------管理员，欢迎您登录--------------");
			while (true) {	
				System.out.println("1查询学生信息");
				System.out.println("9退出系统");
				Scanner sc1 = new Scanner(System.in);
				int num = sc1.nextInt();
			    if (num == 1) {
					while (true) {
						System.out.println("1按照学生账号查询");
						System.out.println("2按照学生姓名查询");
						System.out.println("3返回上一级菜单");
						Scanner sc2 = new Scanner(System.in);
						int findNum = sc2.nextInt();
						if (findNum == 1) {
							System.out.println("请输入查询的id号：");
							Scanner scf = new Scanner(System.in);
							String fid = scf.nextLine();
							Student s = userDao.findById(fid);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else if (findNum == 2) {
							System.out.println("请输入查询的姓名：");
							Scanner scf = new Scanner(System.in);
							String fname = scf.nextLine();
							Student s = userDao.findByName(fname);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else {
							break;
						}
					}// 第二个while                
				}else if(num==9){
					System.out.println("----------------------------------谢谢使用本系统----------------------");
					System.exit(0);
				}
			}//第一个while
	    }else if(isSuper==1){
	    	System.out.println("------------------------系统管理员，欢迎您登录--------------");
	    	while(true){
				System.out.println("1查询学生信息");
				System.out.println("2添加学生信息");
				System.out.println("3更新学生信息");
				System.out.println("4删除学生信息");
				System.out.println("5添加账号");
				System.out.println("6更新账号");
				System.out.println("7删除账号");
				System.out.println("8查询账号信息");
				System.out.println("9退出学生信息");
				Scanner scc = new Scanner(System.in);
				int num = scc.nextInt();
				if (num == 1) {
					while(true){
						System.out.println("0查询学生信息");
						System.out.println("1按照学生账号查询");
						System.out.println("2按照学生姓名查询");
						System.out.println("3返回上一级菜单");
						Scanner sc1 = new Scanner(System.in);
						int numFind = sc1.nextInt();
						if (numFind == 0) {
							List<Student> array = userDao.find();
							if (array != null) {
								for (Student std : array) {
									System.out.println(std);
								}
							}
						} else if (numFind == 1) {
							System.out.println("请输入查询的id号：");
							Scanner scf = new Scanner(System.in);
							String fid = scf.nextLine();
							Student s = userDao.findById(fid);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else if (numFind == 2) {
							System.out.println("请输入查询的姓名：");
							Scanner scf = new Scanner(System.in);
							String fname = scf.nextLine();
							Student s = userDao.findByName(fname);
							if (s.getId() != null) {
								System.out.println(s);
							}
						}else if(numFind==3){
							break;
						}
					}//第二个while
				} else if (num == 2) {
					System.out.println("请输入学生的学号：");
					Scanner sc2 = new Scanner(System.in);
					String id2 = sc2.nextLine();
					System.out.println("请输入学生的姓名：");
					String name2 = sc2.nextLine();
					System.out.println("请输入学生的性别：");
					String sex2 = sc2.nextLine();
					System.out.println("请输入学生的年纪：");
					String age2 = sc2.nextLine();
					System.out.println("请输入学生的课程：");
					String course2 = sc2.nextLine();
					Student student = new Student();
					student.setId(id2);
					student.setName(name2);
					student.setSex(sex2);
					student.setAge(Integer.parseInt(age2));
					student.setCourse(course2);
					userDao.addStudent(student);
				} else if (num == 3) {
					System.out.println("请输入需要删除的学生的学号：");
					Scanner sc3 = new Scanner(System.in);
					String id3 = sc3.nextLine();
					userDao.updateStudent(id3);
				} else if (num == 4) {
					System.out.println("请输入需要删除的学生的学号：");
					Scanner sc4 = new Scanner(System.in);
					String id4 = sc4.nextLine();
					userDao.deleteStudent(id4);
				} else if (num == 5) {
					Scanner sc5 = new Scanner(System.in);
					System.out.println("请输入管理员账号：");
					String id5 = sc5.nextLine();
					System.out.println("请输入管理登录密码：");
					String password5 = sc5.nextLine();
					System.out.println("请输入管理的类型:1为超级管理员，2为普通管理员");
					String isSuper5 = sc5.nextLine();
					System.out.println("请输入管理员的姓名：");
					String name5 = sc5.nextLine();
					UserAccount uAccount = new UserAccount();
					uAccount.setId(id5);
					uAccount.setPassword(password5);
					uAccount.setSuperUser(Integer.parseInt(isSuper5));
					uAccount.setName(name5);
					userDao.addUser(uAccount);
				} else if (num == 6) {
					System.out.println("请输入需要修改的账号：");
					Scanner sc6 = new Scanner(System.in);
					String id6 = sc6.nextLine();
					userDao.updateUser(id6);
				} else if (num == 7) {
					System.out.println("请输入需要删除的账号：");
					Scanner sc7 = new Scanner(System.in);
					String id7 = sc7.nextLine();
					userDao.deleteUser(id7);
				} else if (num == 8) {
					List<UserAccount> list = new ArrayList<UserAccount>();
					list = userDao.findUser();
					for (UserAccount us : list) {
						System.out.println(us);
					}
				}else if (num == 9) {
					System.out.println("----------------------------------谢谢使用本系统----------------------");
					System.exit(0);
				}
	    	}//第一个while
	    }else{
	    	System.out.println("您的账号名或者密码错误");
	    }
		
	}
}

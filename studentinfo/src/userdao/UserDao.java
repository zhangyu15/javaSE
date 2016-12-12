package userdao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import userdomain.Student;
import userdomain.UserAccount;

public class UserDao {
	/*
	 * 按照id查询学生信息
	 */
	public Student findById(String id) {
		BufferedReader br = null;
		Student finds = new Student();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			boolean mark = false;
			while ((line = br.readLine()) != null) {
				String str[] = line.split("=");
				if (id.equals(str[0])) {
					String sid = str[0];
					String sname = str[1];
					String sex = str[2];
					int age = Integer.parseInt(str[3]);
					String course = str[4];
					finds.setId(sid);
					finds.setName(sname);
					finds.setSex(sex);
					finds.setAge(age);
					finds.setCourse(course);
					// System.out.println(sid+"--"+sname+"--"+sex+"--"
					// +age+"--"+course);
					mark = true;
					break;
				}
			}
			if (mark == false) {
				System.out.println("没有这个学生的信息");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return finds;
	}

	/*
	 * 按照姓名查询学生信息
	 */
	public Student findByName(String name) {
		BufferedReader br = null;
		Student finds = new Student();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			boolean mark = false;
			while ((line = br.readLine()) != null) {
				String str[] = line.split("=");
				if (name.equals(str[1])) {
					String sid = str[0];
					String sname = str[1];
					String sex = str[2];
					int age = Integer.parseInt(str[3]);
					String course = str[4];
					finds.setId(sid);
					finds.setName(sname);
					finds.setSex(sex);
					finds.setAge(age);
					finds.setCourse(course);
					// System.out.println(sid+"--"+sname+"--"+sex+"--"
					// +age+"--"+course);
					mark = true;
					break;
				}
			}
			if (mark == false) {
				System.out.println("没有这个学生的信息");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return finds;
	}

	/*
	 * 查询所有
	 */
	public List<Student> find() {
		BufferedReader br = null;
		List<Student> list = new ArrayList<Student>();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] str = line.split("=");
				String sid = str[0];
				String sname = str[1];
				String sex = str[2];
				int age = Integer.parseInt(str[3]);
				String course = str[4];
				Student finds = new Student();
				finds.setId(sid);
				finds.setName(sname);
				finds.setSex(sex);
				finds.setAge(age);
				finds.setCourse(course);
				list.add(finds);
			}
			if (list == null) {
				System.out.println("没有任何学生信息");
			}
			// 遍历集合输入学生对象
			// for(Student std:list){
			// System.out.println(std);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 查询所有账号信息
	 */
	public List<UserAccount> findUser(){
		BufferedReader br=null;
		List<UserAccount> list=new ArrayList<UserAccount>();
		try {
			br=new BufferedReader(new FileReader("user.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				String [] str=line.split("=");
				UserAccount uAccount=new UserAccount();
				uAccount.setId(str[0]);
				uAccount.setPassword(str[1]);
				uAccount.setSuperUser(Integer.parseInt(str[2]));
				uAccount.setName(str[3]);
				list.add(uAccount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	/*
	 * 添加学生信息
	 */
	public void addStudent(Student student) {
		String id = student.getId();
		String name = student.getName();
		String sex = student.getSex();
		int age = student.getAge();
		String course = student.getCourse();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("student.txt", true));
			bw.write(id + "=" + name + "=" + sex + "=" + age + "=" + course);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 添加管理员信息
	 */
	public void addUser(UserAccount userAccount) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("user.txt", true));
			String id = userAccount.getId();
			String password = userAccount.getPassword();
			String name = userAccount.getName();
			int isSuper = userAccount.getSuperUser();
			bw.write(id + "=" + password + "=" + isSuper + "=" + name);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 修改学生信息
	 */
	public void updateStudent(String id) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flage=false;
		List<Student> list=new ArrayList<Student>();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] str = line.split("=");
				Student student=new Student();
				student.setId(str[0]);
				student.setName(str[1]);
				student.setSex(str[2]);
				student.setAge(Integer.parseInt(str[3]));
				student.setCourse(str[4]);
				list.add(student);
			}
			//遍历集合找出需要修改的学生
			Student student=new Student();
			for(Student s:list){
				if(s.getId().equals(id)){
					student=s;
					list.remove(s);
					flage=true;
					break;
				}
			}
			int num=0;
			Scanner scnum=new Scanner(System.in);
			while (num <= 5) {
				System.out.println("请输入需要修改的内容");
				System.out.println("1学号2姓名3性别4年龄5课程6结束修改");
				Scanner sc=new Scanner(System.in);
				num=scnum.nextInt();
				switch (num) {
				case 1:
					System.out.println("请输入新的学号：");
					String nid = sc.nextLine();
					student.setId(nid);
					break;
				case 2:
					System.out.println("请输入新的姓名：");
					String nName=sc.next();
					student.setName(nName);
					break;
				case 3:
					System.out.println("请输入新的性别：");
					String nsex=sc.nextLine();
					student.setSex(nsex);
					break;
				case 4:
					System.out.println("请输入新的年龄：");
					String nage=sc.nextLine();
					student.setAge(Integer.parseInt(nage));
					break;
				case 5:
					System.out.println("请输入新的课程：");
					String ncourse=sc.nextLine();
					student.setCourse(ncourse);
					break;
				default:
						break;
				}
			}
			//将该修改的信息添加到集合
			list.add(student);
			//将集合中的信息写会文件
			bw = new BufferedWriter(new FileWriter("student.txt"));
			for(Student s:list){
				bw.write(s.getId() + "=" + s.getName() + "=" + s.getSex() + "="
						+ s.getAge() + "=" + s.getCourse());
				bw.newLine();
				bw.flush();
			}

			if (flage == false) {
				System.out.println("该学生的信息不存在");
				System.exit(0);
			}else{
				System.out.println("该学生信息已经修改");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * 修改管理员的信息
	 */
	public void updateUser(String id) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flage=false;
		List<UserAccount> uList=new ArrayList<UserAccount>();
		//将文本信息存入集合
		try {
			br=new BufferedReader(new FileReader("user.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				String [] str=line.split("=");
				UserAccount user=new UserAccount();
				user.setId(str[0]);
				user.setPassword(str[1]);
				user.setSuperUser(Integer.parseInt(str[2]));
				user.setName(str[3]);
 			    uList.add(user);
			}
			//遍历集合找出需要修改的账号
			UserAccount userAccount=new UserAccount();
			for(UserAccount us:uList){
				if(us.getId().equals(id)){
					userAccount=us;
					flage=true;
					uList.remove(us);
				}
			}
			int num=0;
			Scanner scnum=new Scanner(System.in);
			Scanner sc=new Scanner(System.in);
			while(num<=4){
				System.out.println("请输入需要修改的属性：");
				System.out.println("1账号2密码3权限(1为系统 2为普通)4名字5结束修改");
				num=scnum.nextInt();
				switch(num){
				case 1:
					System.out.println("请输入新的账号：");
					String nid=sc.nextLine();
					userAccount.setId(nid);
					break;
				case 2:
					System.out.println("请输入新的密码：");
					String npwd=sc.nextLine();
					userAccount.setPassword(npwd);
					break;
				case 3:
					System.out.println("请输入新的权限：");
					String nsuper=sc.nextLine();
					userAccount.setSuperUser(Integer.parseInt(nsuper));
					break;
				case 4:
					System.out.println("请输入新的名字：");
					String nName=sc.nextLine();
					userAccount.setName(nName);
					break;
				default:
						break;
				}
			}
			//将修改后的信息添加到集合
			uList.add(userAccount);
			//回写
			bw=new BufferedWriter(new FileWriter("user.txt"));
			for(UserAccount usa:uList){
				bw.write(usa.getId() + "=" + usa.getPassword() + "="
						+ usa.getSuperUser() + "=" + usa.getName());
				bw.newLine();
				bw.flush();			
			}
			if(flage){
				System.out.println("该账号信息已经修改");
			}else{
				System.out.println("没有该账号的信息");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 删除学生信息
	 */
	public void deleteStudent(String id) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flage = false;
		List<Student> list=new ArrayList<Student>();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			//把文件中的内容读入到集合中
			while ((line = br.readLine()) != null) {
				String[] str = line.split("=");
				Student student=new Student();
				student.setId(str[0]);
				student.setName(str[1]);
				student.setSex(str[2]);
				student.setAge(Integer.parseInt(str[3]));
				student.setCourse(str[4]);
				list.add(student);
			}
			//在集合中查找对需要删除的学生信息
			for(Student s:list){
				if(s.getId().equals(id)){
					flage=true;
					System.out.println(s);
					list.remove(s);				
				}
			}
			//输出删削学生信息后的集合内容，用于测试
//			for(Student s:list){
//				System.out.println(s);
//			}
			//将集合中的信息写会文件
			bw = new BufferedWriter(new FileWriter("student.txt"));
			for(Student s:list){
				bw.write(s.getId() + "=" + s.getName() + "=" + s.getSex() + "="
						+ s.getAge() + "=" + s.getCourse());
				bw.newLine();
				bw.flush();

			}
			
			if (flage == false) {
				System.out.println("您要删除的学生信息不存在");
				System.exit(0);
			}else{
				System.out.println("该学生信息已经删除");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 删除管理员信息
	 */
	public void deleteUser(String id) {
		boolean flage=false;
		BufferedReader br=null;
		BufferedWriter bw=null;		
		//读取文件，把文本的信息读入集合当中
		List<UserAccount> list=new ArrayList<UserAccount>();
		try {
			br=new BufferedReader(new FileReader("user.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				String [] str=line.split("=");
				UserAccount uAccount=new UserAccount();
				uAccount.setId(str[0]);
				uAccount.setPassword(str[1]);
				uAccount.setSuperUser(Integer.parseInt(str[2]));
				uAccount.setName(str[3]);
				list.add(uAccount);
			}
			//遍历集合删除需要删除的管理员信息
			for(UserAccount ua:list){
				if(ua.getId().equals(id)){
					flage=true;
					list.remove(ua);
					break;
				}
			}
			//将集合中的信息写入文本
			bw=new BufferedWriter(new FileWriter("user.txt"));
			for(UserAccount usa:list){
				bw.write(usa.getId() + "=" + usa.getPassword() + "="
						+ usa.getSuperUser() + "=" + usa.getName());
				bw.newLine();
				bw.flush();			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (br != null) {
					br.close();
				}
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(flage){
			System.out.println("该账号已经删除");
		}else{
			System.out.println("该账号信息不存在");
		}
	}
  
	
}

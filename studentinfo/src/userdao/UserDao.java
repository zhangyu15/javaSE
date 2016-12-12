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
	 * ����id��ѯѧ����Ϣ
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
				System.out.println("û�����ѧ������Ϣ");
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
	 * ����������ѯѧ����Ϣ
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
				System.out.println("û�����ѧ������Ϣ");
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
	 * ��ѯ����
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
				System.out.println("û���κ�ѧ����Ϣ");
			}
			// ������������ѧ������
			// for(Student std:list){
			// System.out.println(std);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ��ѯ�����˺���Ϣ
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
	 * ���ѧ����Ϣ
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
	 * ��ӹ���Ա��Ϣ
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
	 * �޸�ѧ����Ϣ
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
			//���������ҳ���Ҫ�޸ĵ�ѧ��
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
				System.out.println("��������Ҫ�޸ĵ�����");
				System.out.println("1ѧ��2����3�Ա�4����5�γ�6�����޸�");
				Scanner sc=new Scanner(System.in);
				num=scnum.nextInt();
				switch (num) {
				case 1:
					System.out.println("�������µ�ѧ�ţ�");
					String nid = sc.nextLine();
					student.setId(nid);
					break;
				case 2:
					System.out.println("�������µ�������");
					String nName=sc.next();
					student.setName(nName);
					break;
				case 3:
					System.out.println("�������µ��Ա�");
					String nsex=sc.nextLine();
					student.setSex(nsex);
					break;
				case 4:
					System.out.println("�������µ����䣺");
					String nage=sc.nextLine();
					student.setAge(Integer.parseInt(nage));
					break;
				case 5:
					System.out.println("�������µĿγ̣�");
					String ncourse=sc.nextLine();
					student.setCourse(ncourse);
					break;
				default:
						break;
				}
			}
			//�����޸ĵ���Ϣ��ӵ�����
			list.add(student);
			//�������е���Ϣд���ļ�
			bw = new BufferedWriter(new FileWriter("student.txt"));
			for(Student s:list){
				bw.write(s.getId() + "=" + s.getName() + "=" + s.getSex() + "="
						+ s.getAge() + "=" + s.getCourse());
				bw.newLine();
				bw.flush();
			}

			if (flage == false) {
				System.out.println("��ѧ������Ϣ������");
				System.exit(0);
			}else{
				System.out.println("��ѧ����Ϣ�Ѿ��޸�");
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
	 * �޸Ĺ���Ա����Ϣ
	 */
	public void updateUser(String id) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flage=false;
		List<UserAccount> uList=new ArrayList<UserAccount>();
		//���ı���Ϣ���뼯��
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
			//���������ҳ���Ҫ�޸ĵ��˺�
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
				System.out.println("��������Ҫ�޸ĵ����ԣ�");
				System.out.println("1�˺�2����3Ȩ��(1Ϊϵͳ 2Ϊ��ͨ)4����5�����޸�");
				num=scnum.nextInt();
				switch(num){
				case 1:
					System.out.println("�������µ��˺ţ�");
					String nid=sc.nextLine();
					userAccount.setId(nid);
					break;
				case 2:
					System.out.println("�������µ����룺");
					String npwd=sc.nextLine();
					userAccount.setPassword(npwd);
					break;
				case 3:
					System.out.println("�������µ�Ȩ�ޣ�");
					String nsuper=sc.nextLine();
					userAccount.setSuperUser(Integer.parseInt(nsuper));
					break;
				case 4:
					System.out.println("�������µ����֣�");
					String nName=sc.nextLine();
					userAccount.setName(nName);
					break;
				default:
						break;
				}
			}
			//���޸ĺ����Ϣ��ӵ�����
			uList.add(userAccount);
			//��д
			bw=new BufferedWriter(new FileWriter("user.txt"));
			for(UserAccount usa:uList){
				bw.write(usa.getId() + "=" + usa.getPassword() + "="
						+ usa.getSuperUser() + "=" + usa.getName());
				bw.newLine();
				bw.flush();			
			}
			if(flage){
				System.out.println("���˺���Ϣ�Ѿ��޸�");
			}else{
				System.out.println("û�и��˺ŵ���Ϣ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * ɾ��ѧ����Ϣ
	 */
	public void deleteStudent(String id) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flage = false;
		List<Student> list=new ArrayList<Student>();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			String line = null;
			//���ļ��е����ݶ��뵽������
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
			//�ڼ����в��Ҷ���Ҫɾ����ѧ����Ϣ
			for(Student s:list){
				if(s.getId().equals(id)){
					flage=true;
					System.out.println(s);
					list.remove(s);				
				}
			}
			//���ɾ��ѧ����Ϣ��ļ������ݣ����ڲ���
//			for(Student s:list){
//				System.out.println(s);
//			}
			//�������е���Ϣд���ļ�
			bw = new BufferedWriter(new FileWriter("student.txt"));
			for(Student s:list){
				bw.write(s.getId() + "=" + s.getName() + "=" + s.getSex() + "="
						+ s.getAge() + "=" + s.getCourse());
				bw.newLine();
				bw.flush();

			}
			
			if (flage == false) {
				System.out.println("��Ҫɾ����ѧ����Ϣ������");
				System.exit(0);
			}else{
				System.out.println("��ѧ����Ϣ�Ѿ�ɾ��");
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
	 * ɾ������Ա��Ϣ
	 */
	public void deleteUser(String id) {
		boolean flage=false;
		BufferedReader br=null;
		BufferedWriter bw=null;		
		//��ȡ�ļ������ı�����Ϣ���뼯�ϵ���
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
			//��������ɾ����Ҫɾ���Ĺ���Ա��Ϣ
			for(UserAccount ua:list){
				if(ua.getId().equals(id)){
					flage=true;
					list.remove(ua);
					break;
				}
			}
			//�������е���Ϣд���ı�
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
			System.out.println("���˺��Ѿ�ɾ��");
		}else{
			System.out.println("���˺���Ϣ������");
		}
	}
  
	
}

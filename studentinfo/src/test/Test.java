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
		System.out.println("-------------------��ӭʹ�ñ�ϵͳ��������¼-----------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("�˺ţ�");
		String id=sc.nextLine();
		System.out.print("���룺");
		String password=sc.nextLine();
		//�������Ե��÷����Ķ���
		Login login=new Login();
		UserDao userDao=new UserDao();
	    int isSuper=login.login(id, password);
	    
	    if(isSuper==2){
	    	boolean b=false;		
			System.out.println("------------------------����Ա����ӭ����¼--------------");
			while (true) {	
				System.out.println("1��ѯѧ����Ϣ");
				System.out.println("9�˳�ϵͳ");
				Scanner sc1 = new Scanner(System.in);
				int num = sc1.nextInt();
			    if (num == 1) {
					while (true) {
						System.out.println("1����ѧ���˺Ų�ѯ");
						System.out.println("2����ѧ��������ѯ");
						System.out.println("3������һ���˵�");
						Scanner sc2 = new Scanner(System.in);
						int findNum = sc2.nextInt();
						if (findNum == 1) {
							System.out.println("�������ѯ��id�ţ�");
							Scanner scf = new Scanner(System.in);
							String fid = scf.nextLine();
							Student s = userDao.findById(fid);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else if (findNum == 2) {
							System.out.println("�������ѯ��������");
							Scanner scf = new Scanner(System.in);
							String fname = scf.nextLine();
							Student s = userDao.findByName(fname);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else {
							break;
						}
					}// �ڶ���while                
				}else if(num==9){
					System.out.println("----------------------------------ллʹ�ñ�ϵͳ----------------------");
					System.exit(0);
				}
			}//��һ��while
	    }else if(isSuper==1){
	    	System.out.println("------------------------ϵͳ����Ա����ӭ����¼--------------");
	    	while(true){
				System.out.println("1��ѯѧ����Ϣ");
				System.out.println("2���ѧ����Ϣ");
				System.out.println("3����ѧ����Ϣ");
				System.out.println("4ɾ��ѧ����Ϣ");
				System.out.println("5����˺�");
				System.out.println("6�����˺�");
				System.out.println("7ɾ���˺�");
				System.out.println("8��ѯ�˺���Ϣ");
				System.out.println("9�˳�ѧ����Ϣ");
				Scanner scc = new Scanner(System.in);
				int num = scc.nextInt();
				if (num == 1) {
					while(true){
						System.out.println("0��ѯѧ����Ϣ");
						System.out.println("1����ѧ���˺Ų�ѯ");
						System.out.println("2����ѧ��������ѯ");
						System.out.println("3������һ���˵�");
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
							System.out.println("�������ѯ��id�ţ�");
							Scanner scf = new Scanner(System.in);
							String fid = scf.nextLine();
							Student s = userDao.findById(fid);
							if (s.getId() != null) {
								System.out.println(s);
							}
						} else if (numFind == 2) {
							System.out.println("�������ѯ��������");
							Scanner scf = new Scanner(System.in);
							String fname = scf.nextLine();
							Student s = userDao.findByName(fname);
							if (s.getId() != null) {
								System.out.println(s);
							}
						}else if(numFind==3){
							break;
						}
					}//�ڶ���while
				} else if (num == 2) {
					System.out.println("������ѧ����ѧ�ţ�");
					Scanner sc2 = new Scanner(System.in);
					String id2 = sc2.nextLine();
					System.out.println("������ѧ����������");
					String name2 = sc2.nextLine();
					System.out.println("������ѧ�����Ա�");
					String sex2 = sc2.nextLine();
					System.out.println("������ѧ������ͣ�");
					String age2 = sc2.nextLine();
					System.out.println("������ѧ���Ŀγ̣�");
					String course2 = sc2.nextLine();
					Student student = new Student();
					student.setId(id2);
					student.setName(name2);
					student.setSex(sex2);
					student.setAge(Integer.parseInt(age2));
					student.setCourse(course2);
					userDao.addStudent(student);
				} else if (num == 3) {
					System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
					Scanner sc3 = new Scanner(System.in);
					String id3 = sc3.nextLine();
					userDao.updateStudent(id3);
				} else if (num == 4) {
					System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
					Scanner sc4 = new Scanner(System.in);
					String id4 = sc4.nextLine();
					userDao.deleteStudent(id4);
				} else if (num == 5) {
					Scanner sc5 = new Scanner(System.in);
					System.out.println("���������Ա�˺ţ�");
					String id5 = sc5.nextLine();
					System.out.println("����������¼���룺");
					String password5 = sc5.nextLine();
					System.out.println("��������������:1Ϊ��������Ա��2Ϊ��ͨ����Ա");
					String isSuper5 = sc5.nextLine();
					System.out.println("���������Ա��������");
					String name5 = sc5.nextLine();
					UserAccount uAccount = new UserAccount();
					uAccount.setId(id5);
					uAccount.setPassword(password5);
					uAccount.setSuperUser(Integer.parseInt(isSuper5));
					uAccount.setName(name5);
					userDao.addUser(uAccount);
				} else if (num == 6) {
					System.out.println("��������Ҫ�޸ĵ��˺ţ�");
					Scanner sc6 = new Scanner(System.in);
					String id6 = sc6.nextLine();
					userDao.updateUser(id6);
				} else if (num == 7) {
					System.out.println("��������Ҫɾ�����˺ţ�");
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
					System.out.println("----------------------------------ллʹ�ñ�ϵͳ----------------------");
					System.exit(0);
				}
	    	}//��һ��while
	    }else{
	    	System.out.println("�����˺��������������");
	    }
		
	}
}

package userdao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	//登录的时候需要判断是普通管理员还是超级管理员
	public int login(String id,String password){
		int flage=0;
		BufferedReader br=null;
		try {
            br=new BufferedReader(new FileReader("user.txt"));
		    String line=null;
		    while((line=br.readLine())!=null){
		    	String []str=line.split("=");
		    	if(id.equals(str[0])&&password.equals(str[1])&&str[2].equals("1")){
		    		flage=1;
		    		//System.out.println("-------欢迎您，超级管理员------------------");
		    		break;
		    	}else if(id.equals(str[0])&&password.equals(str[1])&&str[2].equals("2")){
		    		flage=2;
		    		//System.out.println("------欢迎您，管理员-------------");
		    		break;
		    	}else{
		    		//System.out.println("您的账号名或者密码有误");
		    	}
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
		
		
		return flage;
	}
}

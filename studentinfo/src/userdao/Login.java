package userdao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	//��¼��ʱ����Ҫ�ж�����ͨ����Ա���ǳ�������Ա
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
		    		//System.out.println("-------��ӭ������������Ա------------------");
		    		break;
		    	}else if(id.equals(str[0])&&password.equals(str[1])&&str[2].equals("2")){
		    		flage=2;
		    		//System.out.println("------��ӭ��������Ա-------------");
		    		break;
		    	}else{
		    		//System.out.println("�����˺���������������");
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

package tencent;

import java.util.Scanner;

public class test {
	
    public static void main(String[] args) {
    	
    	Scanner sca=new Scanner(System.in);
    	
    	String  sc=sca.next();
    	
    test  t=new test();
    
    String  s=t.huiwenchuan(sc);
    System.out.println(s);
    System.out.println("��Ҫɾ�����ַ�������Ϊ��"+(sc.length()-s.length()));
   
  }
    
    //����һ���ַ�����ʹ�������Ļ��Ĵ�,���������ַ�����
    public   String  huiwenchuan(String  str){
    	
       
       String  str2="";
       String  str3="";
       
       //����ַ����ķ���
       for(int  i=str.length();i>0;i--){
    	   str2=str2+str.substring(i-1,i); 
       }
       
       //����������Ĺ���������
       for(int  i=0;i<str.length();i++){
    	   
    	   if(str.substring(i, i+1).equals(str2.substring(i, i+1))){
    		   str3=str3+str.substring(i, i+1);
    	   }
    	   
       }
    	return  str3;
    	
    }
   
}

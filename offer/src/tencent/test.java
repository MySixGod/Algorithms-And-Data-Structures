package tencent;

import java.util.Scanner;

public class test {
	
    public static void main(String[] args) {
    	
    	Scanner sca=new Scanner(System.in);
    	
    	String  sc=sca.next();
    	
    test  t=new test();
    
    String  s=t.huiwenchuan(sc);
    System.out.println(s);
    System.out.println("需要删除的字符串个数为："+(sc.length()-s.length()));
   
  }
    
    //输入一个字符串，使它变成最长的回文串,并输出最长的字符个数
    public   String  huiwenchuan(String  str){
    	
       
       String  str2="";
       String  str3="";
       
       //求出字符串的反序
       for(int  i=str.length();i>0;i--){
    	   str2=str2+str.substring(i-1,i); 
       }
       
       //求反序与正序的公共子序列
       for(int  i=0;i<str.length();i++){
    	   
    	   if(str.substring(i, i+1).equals(str2.substring(i, i+1))){
    		   str3=str3+str.substring(i, i+1);
    	   }
    	   
       }
    	return  str3;
    	
    }
   
}

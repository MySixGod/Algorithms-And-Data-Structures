package tencent;

public class ti2 {

	public static void main(String[] args) {
		
		ti2  t=new ti2();
		System.out.println(t.move("BDASJDADBNdbnabnmnkamn"));
		

	}
	
	//讲一个字符串大写的放到后面，相对位置不能改变
	public String  move(String  str){
		
		
		//将字符串全部小写
		String	str1=str.toLowerCase();
		//将字符串全部大写
		String	str2=str.toUpperCase();
		
		String  newStr="";
		
		for(int i=0;i<str.length();i++){
			
			
			if(str.subSequence(i, i+1) .equals( str1.subSequence(i, i+1))){
				
				newStr=newStr+str.subSequence(i, i+1);
			}
			
		}
		
		
		
            for(int i=0;i<str.length();i++){
				
			if(str.subSequence(i, i+1).equals(str2.subSequence(i, i+1))){
				
				newStr=newStr+str.subSequence(i, i+1);
				
			}
			
		}
		
		
		return  newStr;
		
	}

}

package tencent;

public class ti2 {

	public static void main(String[] args) {
		
		ti2  t=new ti2();
		System.out.println(t.move("BDASJDADBNdbnabnmnkamn"));
		

	}
	
	//��һ���ַ�����д�ķŵ����棬���λ�ò��ܸı�
	public String  move(String  str){
		
		
		//���ַ���ȫ��Сд
		String	str1=str.toLowerCase();
		//���ַ���ȫ����д
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

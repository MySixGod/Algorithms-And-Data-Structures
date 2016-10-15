package bishi;

public class test1 {
	
	public static void main(String[] args) {
		
		int i[]={1};
		String  str="abc";
		
		
		str="fgh";
		
		test1  t=new test1();
		
		t.change(str,i);
		
		System.out.println(str+i[0]);
		
	}




	
	public  void  change(String  str,int[]  i){
		
	
		
		str=null;
		
		i[0]=100;
		
		
	}
	
	
}

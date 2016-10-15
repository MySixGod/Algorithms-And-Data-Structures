package bishi;

public class ClassLoad {
	
	  private  static  ClassLoad  cl=new ClassLoad();
	  public   static  int  a=1;
	  public   static  int  b=0;
	  
	  public  ClassLoad(){
		  
		  a++;
		  b++;
		  
	  }
	
	  public  static ClassLoad getClassload(){
		  
		  return  cl;
		  
	  }
	
	public static void main(String[] args) {
		
		ClassLoad  c=ClassLoad.getClassload();
		
		System.out.println(c.a);
		System.out.println(c.b);
		
	}

}

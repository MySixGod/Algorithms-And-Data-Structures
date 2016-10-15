package bishi;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	
	public static void main(String[] args){
	
		Main  m=new Main();
		
		int[]  a={1,1,1,2,3,3,3,};
		
		m.change(a);
		
		m.cha("123");
	
	}
	
	
	public  <T>  T   cha( T  t)
	{
		
		return  t;
		
		
	}
	
	public  void  change(int[]  a){
		
		
		Set<Integer>  lists=new HashSet<Integer>();
		
		for(int i=0;i<a.length;i++){
			
			lists.add(a[i]);
			
		}
		

		int  temp = 0;		
		int  temp1=0;
		
        for(int i=0;i<a.length;i++){
			
			temp=temp+a[i];

		}
         
          for(Integer  in:lists){
			
			System.out.println(in);
			
		}
          
            System.out.println("±éÀúÍê³É");
		
		for(Integer  in:lists){
			
			temp1=temp1+in;
			
		}
		
		System.out.println((temp1*3-temp)/2);
			
	}
}

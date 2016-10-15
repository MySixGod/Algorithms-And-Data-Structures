package suanfa;


    //求最大子列和的问题
      
public class t1 {
	
	public static void main(String[] args) {
		
		int[] a={-2,4,3,4,3,-1,2,-1,-2,4};
		t1 t=new t1();
		System.out.println(t.he1(a));
		System.out.println(t.he2(a));
		System.out.println(t.he3(a));
	
	}
	
	//方法,时间复杂度为n^2
	public  int  he1(int[] a){
		
		int max=0;
		int temp=0;
		
		for(int i=0;i<a.length;i++){
			temp=0;
			
			for(int k=i;k<a.length;k++){
				temp=temp+a[k];
				if(temp>max){
					max=temp;					
				}	
			}		
		}
		return  max;	
	}
	
	
	//算法2时间复杂度为n^3
public  int  he2(int[] a){
		
		int max=0;
		int temp=0;
		
		for(int i=0;i<a.length;i++){
			
			for(int k=i;k<a.length;k++){
				temp=0;
				
				for(int n=i;n<k+1;n++){
					
					temp=temp+a[n];
					
					if(temp>max){
						max=temp;
						
					}				
				}
				
			}		
		}
		return  max;	
	}
	

      //第三种算法,时间复杂度为n
public  int  he3(int[] a){
	
	int temp=0;
	
	for(int i=0;i<a.length;i++){
		
		temp=temp+a[i];
		if(temp<0){
			temp=0;
		}
			
	}
	return  temp;	
}



     
}

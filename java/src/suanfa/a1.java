package suanfa;

public class a1 {
	
  //�����㷨���1��n
  //  n>=1
	
	public static void main(String[] args) {
		
		
		a1 a=new a1();
		a.f1(1000);
		a.f2(1000);
		
	}

	 public void  f1(int n){
		 
		 long time1=System.currentTimeMillis();
		 
		 for(int i=1;i<=n;i++){
			System.out.print(i+" ");
		 }
		 long time2=System.currentTimeMillis(); 
		 
		 long time=time2-time1;
		 System.out.println("�㷨һ��ʹ�õ�ʱ��Ϊ��"+time);
	 }
	
    public void  f2(int n){
    	long time1=System.currentTimeMillis();
    	  long time=0;
    	if(n>0){
    		System.out.print(n+" ");
    		f2(n-1);
    	}else{
    		
    		long time2=System.currentTimeMillis(); 
    		time=time2-time1;
    		System.out.println("�㷨����ʹ�õ�ʱ��Ϊ��"+time);
    		
    	}
	 }
    
	 
}

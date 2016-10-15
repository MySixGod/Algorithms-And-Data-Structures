package suanfa;

import java.util.LinkedList;

//冒泡排序法，输入一个int[]数组，将数组由小到大输出

public class Maopao   {


	
	
	public static void main(String[] args) {
		
		int  a[]=new int[10001];
		
		for(int i=10000;i>=0;i--){
			
			a[i]=i;
			
		}
		
		
		Maopao  m=new Maopao();
		
		long  start=System.currentTimeMillis();
		
	   int[] b=m.maopao(a);
	   long  end=System.currentTimeMillis();
	   System.out.println("方法一所用的时间为："+(end-start)+"ms");
	   
	   long  start2=System.currentTimeMillis();
	   
	   int[] b2=m.maopao2(a);
	   
	   long  end2=System.currentTimeMillis();
	   System.out.println("方法二所用的时间为："+(end2-start2)+"ms");
	   
//		for(int i=0;i<b.length;i++){
//			System.out.println(b[i]+" ");
//		}
//		System.out.println("-----------");
//		for(int i=0;i<b2.length;i++){
//			System.out.println(b2[i]+" ");
//		}
		
	}
	

	public  int[]   maopao(int[] a){
		
		int  temp=0;
		
		for(int i1=0;i1<100;i1++){
			
		for(int i=0;i<a.length;i++){
			
			for(int k=i+1;k<a.length;k++){
				
				if(a[i]>a[k]){
					
					temp=a[i];
					a[i]=a[k];
					a[k]=temp;
						
				}	
			}	
		}
	}
		
		
		return a;
	}
	
	
public  int[]   maopao2(int[] a){
		
		int  temp=0;
		
		for(int i1=0;i1<100;i1++){
		for(int i=0;i<a.length;i++){
			
			for(int k=i+1;k<a.length;k++){
				
				if(a[i]>a[k]){
					
					temp=a[i];
					a[i]=a[k];
					a[k]=temp;
						
				}	else{			
					break;	
					
				}
			}	
		}
}
		return a;
	}


	
}

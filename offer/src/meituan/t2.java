package meituan;
public class t2 {
	
//	��һ����ά����(n*n),д����ʵ�ִ����Ͻǵ����½������Խ��߷����ӡ��
//	����һ����λ����arr����Ŀ�еĲ���n���뷵�ؽ�����顣
//	����������
//	

	public int[] shuchu(int[][] arr ,int i){
		
		int  a[]=new int[i*i];
		int temp=0;

		
		//ѭ������
	   for(int k=i-1;k>=1-i;k--){
		   
		   for(int m=0;m<i;m++){
			   
			   for(int n=0;n<i;n++){
				   
				   if(m-n==k){
					   System.out.println(n+""+""+m+" ");
					   System.out.println("�ָ���-------------");
					   a[temp]=arr[n][m];
					   //System.out.println(arr[n][m]);
					   temp++;
					   
				   }
				      
			   }	   
		   }   
	   }
		
		
		
	
		return  a;
	}
	
	
	public static void main(String[] args) {
	
		t2 t=new t2();
		int arr[][]=new int[4][4];
		int temp=1;
		for(int i=1;i<=4;i++){
			for(int k=1;k<=4;k++){
				
				arr[i-1][k-1]=temp;
				
				temp++;
				
			}
			
		}
		
		for(int i=0;i<4;i++){
			for(int k=0;k<4;k++){
				
			System.out.print(arr[i][k]+"  ");
			
			if(k==3){
				System.out.println();
			}
				
			}	
		}
		
		
		
		int[] b =t.shuchu(arr, 4);
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+"   ");
		}
		
		
//		Node  first1=new Node("123");
//        
//		Node  first2=first1;
//			
//		first2.setDate("456");
//		
//		
//		System.out.println(first1.getDate()+"   ---     "+first2.getDate());
//		
//		System.out.println(first1==first2);
		
	}
	
	
	
	
}




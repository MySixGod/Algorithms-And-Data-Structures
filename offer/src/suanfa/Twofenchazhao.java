package suanfa;

public class Twofenchazhao {
	
	int  pos=0;
	
	public static void main(String[] args) {
		
		Twofenchazhao two=new Twofenchazhao();
		
		int[] i=new int[100];
		
		for(int k=0;k<100;k++){
			
			i[k]=k;
			
		}
		
		System.out.println(two.twofen(i, 24));
		
		System.out.println(two.pos);
		
	}
	
	
	
	//给定一个有序数组，查找k值
	public  int  twofen(int[] i,int k){
		
		int  mid=0;
		int left=0;
		int  right=i.length;
		
		while(true){
			pos++;
			mid=(left+right)/2;
			
			System.out.println(mid);
			
			
			if(i[mid]>k){
				
				right=mid-1;
				
			}
			if(i[mid]<k){
				
				left=mid+1;
			}

			if(i[mid]==k) {
				
				System.out.println(left+"---"+right);
				
				return i[mid];
				
			}
			
			
			
			if(left>right){
				
				return  0;
			}
			
		
			
		}
		
	}

}

package homework;

import jiedian.Node;
import jiedian.xunhuandanlianb;

//对于有n（n≥1）个节点的循环单链表L，假设所有节点值是递增有序的，设计一个算法就地删除所有值重复的节点。
public class T3d9 {
	
	
	//test
	public static void main(String[] args) {
		
		xunhuandanlianb xh=new xunhuandanlianb();
		xh.addNode("111");
		xh.cha("111",1);
	
		
		xh.cha("222",2);
		xh.cha("222",3);
	
		
		xh.cha("333",4);
		xh.cha("333",5);
		
		xh.cha("444",6);
		xh.cha("444",7);
	
		
		xh.disPlay();
		
		System.out.println(xh.size);
		
//		System.out.println("测试删除方法");
//		xh.delete(3);
//		xh.disPlay();
//		System.out.println("测试删除方法");
//		xh.delete(1);
//		xh.disPlay();
				
		T3d9 t=new T3d9();
		xunhuandanlianb xh2=t.delete2(xh);
		xh2.disPlay();
		
		
	}

	public  xunhuandanlianb  delete(xunhuandanlianb xh){
		
		Node   first=xh.first;
		
		for(int  index=1;index<xh.size;index++){
			
	       while(first.getDate().equals(first.getPoint().getDate())){
			
			xh.delete(index);
			
			System.out.println(first.getDate());
			System.out.println(first.getPoint().getDate());
			System.out.println(first.getDate().equals(first.getPoint().getDate()));
			
			if(xh.size==1){
				break;
			}
			
				
		}

	        first=first.getPoint();
	     
		}
		
		return  xh;
		
		
	}
	
	
	public  xunhuandanlianb  delete2(xunhuandanlianb xh){
		
		Node   first=xh.first;
		
		for(int  index=1;index<xh.size;index++){
			
			System.out.print(first.getDate()+"    ");
			System.out.println(first.getPoint().getDate());
		
			if(first.getDate().equals(first.getPoint().getDate())){
				
				xh.delete(index);
				
			}
			
			first=first.getPoint();
				
		}	
		return  xh;
		
		
	}
	
	public  xunhuandanlianb  delete3(xunhuandanlianb xh){
		
		Node   first=xh.first;
		
		for(int  index=0;index<xh.size;index++){
			
		    String	str=xh.getNode(index).getDate();
			
			for(int k=index+1;k<xh.size;k++){
				
				if(str.equals(xh.getNode(k).getDate())){
					
					System.out.println("第"+k+"次删除的节点为："+xh.getNode(k).getDate());
					xh.delete(k);
				
				}	
			}
			
			
		}   
		
		return  xh;
		
	}
	
}


      
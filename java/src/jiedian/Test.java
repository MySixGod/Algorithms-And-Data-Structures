package jiedian;



public class Test{
	
	      
	public static void main(String[] args) {
		
		
		
		Slianbiao s=new Slianbiao();
		s.addFirst("1", 0);
		s.addFirst("2", 1);
		s.addFirst("3", 2);
		s.addFirst("4", 3);
		s.addFirst("第二个2", 2);
		s.addFirst("3", 2);
		s.addFirst("3", 2);
		s.addFirst("3", 2);
	
		s.disPlay();
		
		System.out.println("-------------------分割线----------------");
		
		Test t=new Test();
		System.out.println("统计数字3出现的次数,次数为："+t.getNumber(s, "3"));
		
		System.out.println();
		System.out.println("测试删除值为str的第一个节点");
		
		System.out.println(s.getNode(5));
		
		s.deleteFirst(s, "第二个2");
		s.disPlay();
		
		
	}
	
	//测试循环单链表，测试成功
	public  void  test2(){
		
		xunhuandanlianb xh=new xunhuandanlianb();
		xh.addNode("循环单链表的头节点");
		xh.cha("插入的节点", 1);
		xh.cha("插入的第二个节点", 2);
		xh.cha("第三个节点", 3);
		xh.disPlay();
		
	}
	
	//测试双链表的添加方法
   public  void  test3(){
	   
	   System.out.println("---------------测试双链表-------------");
	   
	   Slianbiao sg=new Slianbiao();
		
	   sg.addFirst("添加的第一个双链表节点", 0);
	   System.out.println("双链表的长度为"+sg.size);
	   sg.addFirst("添加的第二个双链表节点", 1);
	   sg.addFirst("添加的第三个双链表节点", 2);
	   sg.addFirst("添加的第四个双链表节点", 3);
	   System.out.println("双链表的长度为"+sg.size);
	   sg.disPlay();
	   
		
	}
   
   //循环遍历一个双链表，计算其中值为x的节点个数
   
   public  int  getNumber(Slianbiao  s,String  str){
	   
	   int k=0;

	   for(int i=0;i<s.size;i++){
		   if(str.equals(s.getNode(i).getStr())){
			   k++; 
		   }   
	   } 
	   return k;
   }	
   
   
   public  int[]  getNumber(Slianbiao  s){
	   int a=0;
	   int[] k={};
	   String  temp=null;
	   temp=s.getNode(0).getStr();

	   for(int i=1;i<s.size;i++){

		   if(temp.compareTo(s.getNode(i).getStr())<0){
			   
			   temp=s.getNode(i+1).getStr();
			   
		   }  
	   } 
	   
	   for(int i=1;i<s.size;i++){
		   if(temp.equals((s.getNode(i).getStr()))){
			   k[a]=i;
			   a++;
			   
		   }  
	   } 
	   
	   return k;
   }	
}

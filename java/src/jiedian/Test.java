package jiedian;



public class Test{
	
	      
	public static void main(String[] args) {
		
		
		
		Slianbiao s=new Slianbiao();
		s.addFirst("1", 0);
		s.addFirst("2", 1);
		s.addFirst("3", 2);
		s.addFirst("4", 3);
		s.addFirst("�ڶ���2", 2);
		s.addFirst("3", 2);
		s.addFirst("3", 2);
		s.addFirst("3", 2);
	
		s.disPlay();
		
		System.out.println("-------------------�ָ���----------------");
		
		Test t=new Test();
		System.out.println("ͳ������3���ֵĴ���,����Ϊ��"+t.getNumber(s, "3"));
		
		System.out.println();
		System.out.println("����ɾ��ֵΪstr�ĵ�һ���ڵ�");
		
		System.out.println(s.getNode(5));
		
		s.deleteFirst(s, "�ڶ���2");
		s.disPlay();
		
		
	}
	
	//����ѭ�����������Գɹ�
	public  void  test2(){
		
		xunhuandanlianb xh=new xunhuandanlianb();
		xh.addNode("ѭ���������ͷ�ڵ�");
		xh.cha("����Ľڵ�", 1);
		xh.cha("����ĵڶ����ڵ�", 2);
		xh.cha("�������ڵ�", 3);
		xh.disPlay();
		
	}
	
	//����˫�������ӷ���
   public  void  test3(){
	   
	   System.out.println("---------------����˫����-------------");
	   
	   Slianbiao sg=new Slianbiao();
		
	   sg.addFirst("��ӵĵ�һ��˫����ڵ�", 0);
	   System.out.println("˫����ĳ���Ϊ"+sg.size);
	   sg.addFirst("��ӵĵڶ���˫����ڵ�", 1);
	   sg.addFirst("��ӵĵ�����˫����ڵ�", 2);
	   sg.addFirst("��ӵĵ��ĸ�˫����ڵ�", 3);
	   System.out.println("˫����ĳ���Ϊ"+sg.size);
	   sg.disPlay();
	   
		
	}
   
   //ѭ������һ��˫������������ֵΪx�Ľڵ����
   
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

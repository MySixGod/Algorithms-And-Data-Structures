package faceObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//���÷ּ������˼����༶���ֺܷ�ƽ����


public class hashmap {
	
	
	  public static void main(String[] args) {
		  
		  
		  List<student>  students=new ArrayList<student>();	
		  
		  student s1=new student("��1", 1, 100);
		  student s2=new student("��2", 1, 90);
		  student s3=new student("��3", 2, 80);
		  student s4=new student("��4", 2, 70);
		  student s5=new student("��5", 3, 60);
		  student s6=new student("��6", 3, 50);
		  
		  students.add(s1);
		  students.add(s2);
		  students.add(s3);
		  students.add(s4);
		  students.add(s5);
		  students.add(s6);
		
		  
		  hashmap h=new hashmap();
		  
		  Map<student, classroom> m=h.m(students);
		  
		  //����ѧ���Լ��������ڵİ༶�ĳɼ�
		  
		
		  Set<student> stus=m.keySet();
		 System.out.println(m.isEmpty());
		 System.out.println(m.size());
		 
		 Iterator  it=stus.iterator();
		 
		 if(it.hasNext()){
			 System.out.println("111");
			 student st=(student)it.next();
			 System.out.println("����"+st.getName()+" "+"�����İ༶Ϊ��"+st.getNo()+""+
			 "�ɼ�Ϊ��"+st.getScore()+"�����İ༶Ϊ��   ��֤"+m.get(st).getNo()+" "+"�༶���ܷ�Ϊ��"+m.get(st).getZongfen()+""
			 		+ "�༶��ƽ����Ϊ��"+m.get(st).getAve()+" "+"�༶������Ϊ��"+m.get(st).getNumber());
			 
			 
		 }	  
}
	  
	  
	  
	  public  Map<student, classroom>  m(List<student> students){
		  
		  Map<student, classroom> m=new HashMap<student, classroom>();
		 
		  //���ڻ�ʲô��û��
		  
//		  Set<student> cr=m.keySet();
//		  Iterator  it=cr.iterator();		  
		  //ѭ������������ѧ���İ༶
		  
	     for(student sts:students){
	    	 classroom  cl=new classroom(); 
	    	 m.put(sts, cl);
	     }
	
	     
	     //��m���Ƿ���ڴ���
	     for(student sts:students){
	    	 
	    	 if(sts.getNo()==m.get(sts).getNo()){
	    		 //���ڣ���ı�
	    		 
	    		 classroom  c=new classroom();
	    		 c.setNumber( m.get(sts).getNumber()+1);
	    		 c.setNo(sts.getNo());
	    		 c.setZongfen( m.get(sts).getZongfen()+sts.getScore());
	    		 c.setAve(m.get(sts).getZongfen()/m.get(sts).getNumber());
	    	
	    		 m.put(sts, c);
	    		 
	    	 }else{
	    		 classroom  c=new classroom();
	    		 c.setNumber(1);
	    		 c.setNo(sts.getNo());
	    		 c.setZongfen(sts.getScore());
	    		 c.setAve(sts.getScore());
	    		 m.put(sts, c);
	    	 }
	     }
				
		
		  return m;
		  	  
	  }
	

}

package faceObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//利用分拣存贮的思想求班级的总分和平均分


public class hashmap {
	
	
	  public static void main(String[] args) {
		  
		  
		  List<student>  students=new ArrayList<student>();	
		  
		  student s1=new student("陈1", 1, 100);
		  student s2=new student("陈2", 1, 90);
		  student s3=new student("陈3", 2, 80);
		  student s4=new student("陈4", 2, 70);
		  student s5=new student("陈5", 3, 60);
		  student s6=new student("陈6", 3, 50);
		  
		  students.add(s1);
		  students.add(s2);
		  students.add(s3);
		  students.add(s4);
		  students.add(s5);
		  students.add(s6);
		
		  
		  hashmap h=new hashmap();
		  
		  Map<student, classroom> m=h.m(students);
		  
		  //遍历学生以及他们所在的班级的成绩
		  
		
		  Set<student> stus=m.keySet();
		 System.out.println(m.isEmpty());
		 System.out.println(m.size());
		 
		 Iterator  it=stus.iterator();
		 
		 if(it.hasNext()){
			 System.out.println("111");
			 student st=(student)it.next();
			 System.out.println("姓名"+st.getName()+" "+"所属的班级为："+st.getNo()+""+
			 "成绩为："+st.getScore()+"所属的班级为：   验证"+m.get(st).getNo()+" "+"班级的总分为："+m.get(st).getZongfen()+""
			 		+ "班级的平均分为："+m.get(st).getAve()+" "+"班级的人数为："+m.get(st).getNumber());
			 
			 
		 }	  
}
	  
	  
	  
	  public  Map<student, classroom>  m(List<student> students){
		  
		  Map<student, classroom> m=new HashMap<student, classroom>();
		 
		  //现在还什么都没有
		  
//		  Set<student> cr=m.keySet();
//		  Iterator  it=cr.iterator();		  
		  //循环，如果有这个学生的班级
		  
	     for(student sts:students){
	    	 classroom  cl=new classroom(); 
	    	 m.put(sts, cl);
	     }
	
	     
	     //看m中是否存在袋子
	     for(student sts:students){
	    	 
	    	 if(sts.getNo()==m.get(sts).getNo()){
	    		 //存在，则改变
	    		 
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

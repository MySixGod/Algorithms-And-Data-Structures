package meituan;

import jiedian.danlianbiao;

public  class  Main{
    
    
    public  static  void  main(String  args[]){
        
        Main  m=new Main();
        System.out.println(m.diu(285));
        
    }
    
    
    public int  diu(int i){
    	
    	danlianbiao  list=new danlianbiao();
    	
    	for(int k=0;k<i;k++){
    		
    		list.cha(String.valueOf(k+1), k);
    		
    		
    	}
    	
    	//每次删除链表中的奇数位
    	
    	while(list.size>1){
    	for(int pos=0;pos<list.size;pos=pos+2){
    		
    		
    		list.deleteByPos(pos);
    		
//    		System.out.println(pos);
//    		list.size--;
    		
    		}
    	
    	}
    	
    	list.disPlay();
    	
    	//取出单链表
    	

        return  0;
   }
}
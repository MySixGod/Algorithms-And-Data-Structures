package jiedian;


//实现双链表的各种方法
public class Slianbiao {
	
	public int  size;
	public  int  pos;
	public  Sjiedian  first;
	Sjiedian newFirst=new Sjiedian();
	
	public Slianbiao(){this.first=null;}
	
	//添加头节点的方法
	public  void  addFirst(String  str,int index){
		
		if(index>size){System.out.println("您输入的index不合法！！");}
		
		if(index==0){
			
			if(size==0){
				//添加第一个头节点
				Sjiedian node=new Sjiedian();
				node.setStr(str);
				node.setFoward(null);
				node.setNext(null);
				first=node;
				newFirst=first;
				size++;
				return;
			}else{
				
				Sjiedian node=new Sjiedian();
				node.setStr(str);
				node.setFoward(null);
				node.setNext(first);
				first.setFoward(node);
				
				first=node;
				newFirst=first;
				size++;
				
			}	
		}
		
		if(index==size){
			//添加的是一个尾节点
			
			Sjiedian node=new Sjiedian();
			Sjiedian n2=first;
			node.setNext(null);
			node.setStr(str);
			for(int i=1;i<index;i++){
				
				n2=first.getNext();
				first=n2;
				
			}
			
			
			node.setFoward(first);
			n2.setNext(node);
		
			first=newFirst;
			size++;
			return;
		
		}
		
		//往双链表的中间插入
		if(index>0&&index<size){
			
			Sjiedian node=new Sjiedian();
			Sjiedian n1=null;
			Sjiedian n2=null;
			node.setStr(str);
			
			for(int i=1;i<index;i++){
				 n1=first;
				 n2=first.getNext();
				first=n2;
				
			}
			
			node.setFoward(n1);
			node.setNext(n2);
			n1.setNext(node);
			n2.setFoward(node);
			
			first=newFirst;
			size++;
	
		}

	}
	
	
	//有一个非空双链表L，设计一个算法删除第一个值为x的节点。
	public  void  deleteFirst(Slianbiao s,String str){
		
		   for(int i=0;i<s.size;i++){
			   
			   if(str.equals(s.getNode(i).getStr())){
				  //如果相等，则要删除此节点
				   Sjiedian node=s.getNode(i);
				   Sjiedian forward=node.getFoward();
				   Sjiedian next=node.getNext();
				   
				   
				   if(forward==null&&next==null){
					   System.out.println("if1");
					   s.first=null;   
					   s.size--;
					   break;
				   }
				   
				   //如果删除的是头节点
				   if(forward==null&&next!=null){
					   
					   System.out.println("if2");
					   s.getNode(i+1).setFoward(null);
					   s.first=s.getNode(i+1);
					   s.size--;
					   break;
				   }
				   
				   //如果删除的时尾节点
				   if(forward!=null&&next==null){
					   System.out.println("if3");
					   s.getNode(i).setFoward(null);
					   s.getNode(i-1).setNext(null);
					   s.size--;
					   break;
				   }
				   
				   //删除中间的节点
				   if(forward!=null&&next!=null){
					   
					   s.getNode(i+1).setFoward(s.getNode(i-1));
					   s.getNode(i-1).setNext(s.getNode(i+1));
					   s.size--;
					   break;
					   
				   }
				   
			   }   else{
				   System.out.println("没有值为"+str+"的节点");
			   }
		   } 
		   
	   }	
		
	//输入位置返回改节点对象
	public  Sjiedian  getNode(int  index){
		
		Sjiedian  first2=first;
		Sjiedian  scond=null;
		
		if(index==0){
			return  first;
			
		}
		
		for(int i=0;i<index;i++){
			
			scond=first.getNext();
			first=scond;
			
		}
		
		first=first2;
		return  scond;
		
	}
	
	
	
	
	public  void  disPlay(){

				//循环遍历所有的节点
				for(int  i=0;i<size;i++){
					
					System.out.println("第"+i+"个节点的信息为："+first.getStr());
					first=first.getNext();			
				}
				first=newFirst;
	}
}

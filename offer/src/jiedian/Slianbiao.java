package jiedian;


//ʵ��˫����ĸ��ַ���
public class Slianbiao {
	
	public int  size;
	public  int  pos;
	public  Sjiedian  first;
	Sjiedian newFirst=new Sjiedian();
	
	public Slianbiao(){this.first=null;}
	
	//���ͷ�ڵ�ķ���
	public  void  addFirst(String  str,int index){
		
		if(index>size){System.out.println("�������index���Ϸ�����");}
		
		if(index==0){
			
			if(size==0){
				//��ӵ�һ��ͷ�ڵ�
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
			//��ӵ���һ��β�ڵ�
			
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
		
		//��˫������м����
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
	
	
	//��һ���ǿ�˫����L�����һ���㷨ɾ����һ��ֵΪx�Ľڵ㡣
	public  void  deleteFirst(Slianbiao s,String str){
		
		   for(int i=0;i<s.size;i++){
			   
			   if(str.equals(s.getNode(i).getStr())){
				  //�����ȣ���Ҫɾ���˽ڵ�
				   Sjiedian node=s.getNode(i);
				   Sjiedian forward=node.getFoward();
				   Sjiedian next=node.getNext();
				   
				   
				   if(forward==null&&next==null){
					   System.out.println("if1");
					   s.first=null;   
					   s.size--;
					   break;
				   }
				   
				   //���ɾ������ͷ�ڵ�
				   if(forward==null&&next!=null){
					   
					   System.out.println("if2");
					   s.getNode(i+1).setFoward(null);
					   s.first=s.getNode(i+1);
					   s.size--;
					   break;
				   }
				   
				   //���ɾ����ʱβ�ڵ�
				   if(forward!=null&&next==null){
					   System.out.println("if3");
					   s.getNode(i).setFoward(null);
					   s.getNode(i-1).setNext(null);
					   s.size--;
					   break;
				   }
				   
				   //ɾ���м�Ľڵ�
				   if(forward!=null&&next!=null){
					   
					   s.getNode(i+1).setFoward(s.getNode(i-1));
					   s.getNode(i-1).setNext(s.getNode(i+1));
					   s.size--;
					   break;
					   
				   }
				   
			   }   else{
				   System.out.println("û��ֵΪ"+str+"�Ľڵ�");
			   }
		   } 
		   
	   }	
		
	//����λ�÷��ظĽڵ����
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

				//ѭ���������еĽڵ�
				for(int  i=0;i<size;i++){
					
					System.out.println("��"+i+"���ڵ����ϢΪ��"+first.getStr());
					first=first.getNext();			
				}
				first=newFirst;
	}
}

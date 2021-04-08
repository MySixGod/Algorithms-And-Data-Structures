package jiedian;

//循环单链表
public class xunhuandanlianb {
	
	 //定义一个投节点以及节点的位置
	
		public static Node  first;
		public  int  size;
		//节点的位置
		public  int  pos;
		public  xunhuandanlianb(){
			this.first=null;
		}
		
		//返回当前节点的长度
		public  int  getSize(){
			
			return size;
			
		}
		
		//添加一个头节点,头插法
		public  void  addNode(String  str){
			if(size==0){
				Node  fiNode=new Node(str);
				fiNode.setPoint(first);
				first=fiNode;
				fiNode.setPoint(first);
								
				size++;
			}else{
				Node  fiNode=new Node(str);
				fiNode.setPoint(first);
				first=fiNode;
				size++;	
			}
			
		}
		
		
	   //删除一个头结点，返回新的头结点
		
		public  Node  deleteFirst(){
			//当前的first是头部
			first=first.getPoint();
			size--;
			return  first;
		}
		
		//在index的位置插入str节点,从0的位置开始插入
		
		public  void  cha(String str,int  index){
			//判断下index是否合法
			Node  first2=first;
		    Node newNode=new Node(str);	
			
			if(index==0){
				
				newNode.setPoint(first);
				first=newNode;
				size++;
				return;
				
			}
		
			
			if(0<index&&index<=size){
								
				for(int i=1;i<size;i++){
					
					Node  n=first;
					Node scond=n.getPoint();
			        first=scond;
					
					if(i==index){
						
						newNode.setPoint(scond);
						n.setPoint(newNode);
						
						size++;
						break;
							
					}
				}
                 if(index==size){
					
					newNode.setPoint(first2);
					first.setPoint(newNode);
					first=first2;
					size++;
					return;
					
				}
						
			}else{
				System.out.println("您输入的index不合法");
			}
			
			first=first2;
			
		}
		
		//插入方法2
		public  void  cha2(String str,int  index){
			//判断下index是否合法
			
			Node  first2=first;
			
			if(index>size||index<0){
				
				System.out.println("您输入的index不合法,插入方法2");
				return;
				
			}
			
			Node newNode=new Node(str);	
			Node  n=first;
			Node scond=n.getPoint();
			
			if(index==0){
				
				newNode.setPoint(first);
				first=newNode;
				size++;
				return;
			}
			
			while(index!=pos){
				
				n=first;
				scond=n.getPoint();
		        first=scond;
				
				pos++;
			}
			
			newNode.setPoint(scond);
			n.setPoint(newNode);
				size++;
				first=first2;
		}
		
		
		//删除对应坐标的节点,从0开始
		public  void  delete(int  index){
			
			if(index>=size||index<0){
				System.out.println("您输入的index不合法111,size="+size+"index="+index);
				return;
			}
			
			//如果删除的是头节点
			if(index==0){
				first=first.getPoint();
				size--;
				return;
			}
			
			//如果删除的时尾节点
			if(index==size-1){
				
				xunhuandanlianb.getNode(index-1).setPoint(first);
				size--;
				
			}
		   
			else{
				
		            xunhuandanlianb.getNode(index-1).setPoint(xunhuandanlianb.getNode(index+1));
		            size--;
		     
			}

		}
		
		//输入位置返回改节点对象
		public static Node  getNode(int  index){
			
			Node  first2=first;
			Node  scond=null;
			
			if(index==0){
				return  first;
				
			}
			
			for(int i=0;i<index;i++){
				
				scond=first.getPoint();
				first=scond;
				
			}
			
			first=first2;
			return  scond;
			
		}
		
		
		
		//显示出所有的节点信息
		public  void  disPlay(){
			
		  Node first2=first;
		
			//循环遍历所有的节点
			for(int  i=0;i<size;i++){
				
				System.out.println("第"+i+"个节点的信息为："+first.getDate()+",下一个节点为："+first.getPoint().getDate());
				first=first.getPoint();
					
			}
			
			first=first2;			
		}
		
}

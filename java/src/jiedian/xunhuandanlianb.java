package jiedian;

//ѭ��������
public class xunhuandanlianb {
	
	 //����һ��Ͷ�ڵ��Լ��ڵ��λ��
	
		public static Node  first;
		public  int  size;
		//�ڵ��λ��
		public  int  pos;
		public  xunhuandanlianb(){
			this.first=null;
		}
		
		//���ص�ǰ�ڵ�ĳ���
		public  int  getSize(){
			
			return size;
			
		}
		
		//���һ��ͷ�ڵ�,ͷ�巨
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
		
		
	   //ɾ��һ��ͷ��㣬�����µ�ͷ���
		
		public  Node  deleteFirst(){
			//��ǰ��first��ͷ��
			first=first.getPoint();
			size--;
			return  first;
		}
		
		//��index��λ�ò���str�ڵ�,��0��λ�ÿ�ʼ����
		
		public  void  cha(String str,int  index){
			//�ж���index�Ƿ�Ϸ�
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
				System.out.println("�������index���Ϸ�");
			}
			
			first=first2;
			
		}
		
		//���뷽��2
		public  void  cha2(String str,int  index){
			//�ж���index�Ƿ�Ϸ�
			
			Node  first2=first;
			
			if(index>size||index<0){
				
				System.out.println("�������index���Ϸ�,���뷽��2");
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
		
		
		//ɾ����Ӧ����Ľڵ�,��0��ʼ
		public  void  delete(int  index){
			
			if(index>=size||index<0){
				System.out.println("�������index���Ϸ�111,size="+size+"index="+index);
				return;
			}
			
			//���ɾ������ͷ�ڵ�
			if(index==0){
				first=first.getPoint();
				size--;
				return;
			}
			
			//���ɾ����ʱβ�ڵ�
			if(index==size-1){
				
				xunhuandanlianb.getNode(index-1).setPoint(first);
				size--;
				
			}
		   
			else{
				
		            xunhuandanlianb.getNode(index-1).setPoint(xunhuandanlianb.getNode(index+1));
		            size--;
		     
			}

		}
		
		//����λ�÷��ظĽڵ����
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
		
		
		
		//��ʾ�����еĽڵ���Ϣ
		public  void  disPlay(){
			
		  Node first2=first;
		
			//ѭ���������еĽڵ�
			for(int  i=0;i<size;i++){
				
				System.out.println("��"+i+"���ڵ����ϢΪ��"+first.getDate()+",��һ���ڵ�Ϊ��"+first.getPoint().getDate());
				first=first.getPoint();
					
			}
			
			first=first2;			
		}
		
}

package suanfa;

public class MyList implements  InitList{
	
	
	private int  size;
	
	//��һ��Object������ʵ��
	Object[] o=new Object[size];
	
      
	public static void main(String[] args) {
		
		MyList m=new MyList();
		
		Object object=new Object();
		object=new String("abc");
		
		m.add(object);
		m.delete(0);
		System.out.println(m.isEmpty());
		
	}
	

	public boolean isEmpty() {
		
		if(size==0){
			return true;
		}else{
			return false;
		}
		
	}

	public int size() {
		
		return size;
	}

	public void add(Object  object) {
		size++;
		
		Object[] b=new Object[size];
		
		System.arraycopy(o, 0, 	b, 0, o.length);
		
	      b[size-1]=object;
		
		  o=b;
	      
	}

  //iΪ�ڼ�����i>=0
	public void delete(int i) {
		
		//��������ɾ�������꣬�Ϳ���ɾ����Ӧ��Ԫ��
		
		
		if(size<1){
			System.out.println("���Ա��Ѿ�Ϊ��");
		}else{
			size--;
			
			Object[] b=new Object[size];
			
			System.arraycopy(o, 0, b, 0, i);
			System.arraycopy(o, i+1, b, i, b.length-i);
			
			o=b;
			
		}
		
		
	}

	public Object find() {
		
		return null;
	}

	@Override
	public void change() {
		
		
	}
	
	
	
	

}

package suanfa;

public class MyList implements  InitList{
	
	
	private int  size;
	
	//用一个Object数组来实现
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

  //i为第几个，i>=0
	public void delete(int i) {
		
		//输入你想删除的坐标，就可以删除对应的元素
		
		
		if(size<1){
			System.out.println("线性表已经为空");
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

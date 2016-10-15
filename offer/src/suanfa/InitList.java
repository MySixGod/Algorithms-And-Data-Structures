package suanfa;

public interface InitList {
	
	
	//增加删除查找改，判断是否为空，返回它的大小
	
	boolean isEmpty();
	int  size();
	
	void add(Object o);
	void delete(int  i);
	Object  find();
	void  change();

}

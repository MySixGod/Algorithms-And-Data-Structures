package jiedian;



//双链表的节点
public class Sjiedian {
	
	public  Sjiedian  foward;
	public  Sjiedian  next;
	public  String  str;
	/**
	 * @return the foward
	 */
	public Sjiedian getFoward() {
		return foward;
	}
	/**
	 * @param foward the foward to set
	 */
	public void setFoward(Sjiedian foward) {
		this.foward = foward;
	}
	/**
	 * @return the next
	 */
	public Sjiedian getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Sjiedian next) {
		this.next = next;
	}
	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}
	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}
	public Sjiedian() {
		super();
	}
	
}

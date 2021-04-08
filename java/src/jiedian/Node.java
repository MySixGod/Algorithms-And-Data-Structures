package jiedian;


//java实现单链表

public class Node {
	
	private  String  date;
	private  Node  point;
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the point
	 */
	public Node getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(Node point) {
		this.point = point;
	}
	public Node(String  str) {
		this.date=str;
	}
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
}

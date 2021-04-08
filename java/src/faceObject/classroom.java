package faceObject;

public class classroom {
	
	private int  no;
	private  int  number;
	private int zongfen;
	private int  ave;
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the zongfen
	 */
	public int getZongfen() {
		return zongfen;
	}
	/**
	 * @param zongfen the zongfen to set
	 */
	public void setZongfen(int zongfen) {
		this.zongfen = zongfen;
	}
	/**
	 * @return the ave
	 */
	public int getAve() {
		return ave;
	}
	/**
	 * @param ave the ave to set
	 */
	public void setAve(int ave) {
		this.ave = ave;
	}
	public classroom(int no, int zongfen, int ave) {
		super();
		this.no = no;
		this.zongfen = zongfen;
		this.ave = ave;
	}
	public classroom() {
		
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	

}

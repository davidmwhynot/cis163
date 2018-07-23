package lab10;
public class DNode {
	private String data;
	private DNode next;
	private DNode prev;

	public DNode() {
		this.data = "";
		this.next = null;
		this.prev = null;
	}
	public DNode(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public DNode(String data, DNode next) {
		this.data = data;
		this.next = next;
		this.prev = null;
	}
	public DNode(String data, DNode next, DNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}


	public String getData() {
		return data;
	}
	public DNode getNext() {
		return next;
	}
	public DNode getPrev() {
		return prev;
	}

	public void setData(String s) {
		data = s;
	}
	public void setNext(DNode n) {
		next = n;
	}
	public void setPrev(DNode n) {
		prev = n;
	}
}

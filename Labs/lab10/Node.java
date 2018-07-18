package lab10;
public class Node {
	private String data;
	private Node next;

	public Node() {
		this.data = "";
		this.next = null;
	}
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}

	public void setData(String s) {
		data = s;
	}
	public void setNext(Node n) {
		next = n;
	}
}

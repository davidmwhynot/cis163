package lab10;
public class LinkedList {
	private int displayCount;
	private Node top;

	public LinkedList() {
		displayCount = 0;
		top = new Node();
	}
	public LinkedList(Node n) {
		displayCount = 0;
		top = n;
	}

	public void push(String data) {
		top = new Node(data, top);
		// if(top != null) {
		// 	Node temp = top;
		// 	Node last = null;
		// 	while(temp != null) {
		// 		last = temp;
		// 		temp = temp.getNext();
		// 	}
		// 	last.setNext(n);
		// } else {
		// 	top = n;
		// }
	}
	public String pop() {
		Node temp = top;
		top = top.getNext();
		return temp.getData();
		// if(top != null) {
		// 	Node temp = top;
		// 	Node last = null;
		// 	while(temp != null) {
		// 		if(temp.getNext() == null) {
		// 			last.setNext(null);
		// 			return temp;
		// 		}
		// 		last = temp;
		// 		temp = temp.getNext();
		// 	}
		// 	return null;
		// } else {
		// 	return null;
		// }
	}
	// public int getLen() {
	// 	// TODO
	// }
	// public void insertBefore(int index, String data) {
	// 	// TODO
	// }
	// public void insertAfter(int index, String data) {
	// 	// TODO
	// }
	// public String removeTop() {
	// 	// TODO
	// }
	// public boolean delAt(int index) {
	// 	// TODO
	// }

	public Node getTop() {
		return top;
	}
	public void setTop(Node n) {
		top = n;
	}
	public void display() {
		Node temp = top;
		System.out.println("================ " + ++displayCount + ": LIST ================");
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}

package lab10;
public class LinkedList {
	private int displayCount;
	private Node top;

	public LinkedList() {
		displayCount = 0;
		top = null;
	}
	public LinkedList(Node n) {
		displayCount = 0;
		top = n;
	}

	public void push(String data) {
		top = new Node(data, top);
	}
	public String pop() {
		Node temp = top;
		top = top.getNext();
		return temp.getData();
	}
	public int getLen() {
		// TODO
		int count = 0;
		Node temp = top;
		while(temp != null) {
			++count;
			temp = temp.getNext();
		}
		return count;
	}
	public void insertBefore(int index, String data) {
		if(index < 0 || index > this.getLen()) {
			throw new IllegalArgumentException();
		}
		if(top == null && index == 0) {
			top = new Node(data);
		} else if(top == null && index != 0) {
			throw new IllegalArgumentException();
		} else if(top != null && index == 0) {
			this.push(data);
		} else {
			Node temp = top;
			Node last = null;
			for(int i = 0; i < index; ++i) {
				last = temp;
				temp = temp.getNext();
			}
			last.setNext(new Node(data, temp));
		}
	}
	public void insertAfter(int index, String data) {
		if(index < 0 || index > this.getLen()) {
			throw new IllegalArgumentException();
		}
		if(top == null && index == 0) {
			top = new Node(data);
		} else if(top == null && index != 0) {
			throw new IllegalArgumentException();
		} else if(top != null && index == 0) {
			Node temp = top.getNext();
			top.setNext(new Node(data, temp));
		} else {
			Node temp = top;
			Node last = null;
			for(int i = 0; i <= index; ++i) {
				last = temp;
				temp = temp.getNext();
			}
			last.setNext(new Node(data, temp));
		}
	}
	public String removeTop() {
		return this.pop();
	}
	public boolean delAt(int index) {
		if(index < 0 || index >= this.getLen()) {
			return false;
			// throw new IllegalArgumentException();
		}
		if(top == null && index == 0) {
			return false;
			// throw new IllegalArgumentException();
		} else if(top == null && index != 0) {
			return false;
			// throw new IllegalArgumentException();
		} else if(top != null && index == 0) {
			Node temp = top.getNext();
			top.setNext(temp.getNext());
			return true;
		} else {
			Node temp = top;
			Node last = null;
			for(int i = 0; i < index; ++i) {
				last = temp;
				temp = temp.getNext();
			}
			last.setNext(temp.getNext());
			return true;
		}
	}

	public Node getTop() {
		return top;
	}
	public void setTop(Node n) {
		top = n;
	}
	public void display() {
		Node temp = top;
		System.out.println("\n\n ================ " + ++displayCount + ": LIST ================ ");
		while(temp != null) {
			System.out.println("\t\t$: " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println("\n");
	}
}

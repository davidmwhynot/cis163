package lab10;
public class DoublyLinkedList {
	private int displayCount;
	private DNode top;

	public DoublyLinkedList() {
		displayCount = 0;
		top = null;
	}
	public DoublyLinkedList(DNode n) {
		displayCount = 0;
		top = n;
	}

	public void push(String data) {
		if(top != null) {
			top = new DNode(data, top);
			top.getNext().setPrev(top);
		} else {
			top = new DNode(data, top);
		}
	}

	public String pop() {
		DNode temp = top;
		top = top.getNext();
		if(top != null) {
			top.setPrev(null);
		}
		return temp.getData();
	}

	public int getLen() {
		int count = 0;
		DNode temp = top;
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
			top = new DNode(data);
		} else if(top == null && index != 0) {
			throw new IllegalArgumentException();
		} else if(top != null && index == 0) {
			this.push(data);
		} else {
			DNode temp = top;
			for(int i = 0; i < index; ++i) {
				temp = temp.getNext();
			}
			DNode newNode = new DNode(data, temp, temp.getPrev());
			temp.getPrev().setNext(newNode);
			temp.setPrev(newNode);
		}
	}

	public void insertAfter(int index, String data) {
		// TODO
		if(index < 0 || index > this.getLen()) {
			throw new IllegalArgumentException();
		}
		if(top == null && index == 0) {
			top = new DNode(data);
		} else if(top == null && index != 0) {
			throw new IllegalArgumentException();
		} else if(top != null && index == 0) {
			DNode temp = top.getNext();
			top.setNext(new DNode(data, temp));
		} else {
			DNode temp = top;
			DNode last = null;
			for(int i = 0; i <= index; ++i) {
				last = temp;
				temp = temp.getNext();
			}
			last.setNext(new DNode(data, temp));
		}
	}

	public String removeTop() {
		// TODO
		return this.pop();
	}

	public boolean delAt(int index) {
		// TODO
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
			DNode temp = top.getNext();
			top.setNext(temp.getNext());
			return true;
		} else {
			DNode temp = top;
			DNode last = null;
			for(int i = 0; i < index; ++i) {
				last = temp;
				temp = temp.getNext();
			}
			last.setNext(temp.getNext());
			return true;
		}
	}

	public DNode getTop() {
		return top;
	}

	public void setTop(DNode n) {
		top = n;
	}

	public void display() {
		DNode temp = top;
		System.out.println("\n\n ================ " + ++displayCount + ": LIST ================ ");
		while(temp != null) {
			System.out.println("\t\t$: " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println("\n");
	}
}

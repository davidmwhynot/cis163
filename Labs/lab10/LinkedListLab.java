package lab10;
public class LinkedListLab {
	public static void main(String[] args) {
		System.out.println("Linked List Lab");

		LinkedList list = new LinkedList(new Node("node a"));

		list.display();
		list.push("node b");
		list.display();
		System.out.println("Popped data: " + list.pop());
		list.display();
		list.push("node c");
		list.push("node d");
		list.push("node e");
		list.display();
		list.push("node f");
		list.display();
		System.out.println("Popped data: " + list.pop());
		list.display();
		list.push("node g");
		// System.out.println("Current length = " + list.getLen());
		//
		// list.insertBefore(0, "apple");
		// list.insertBefore(0, "pear");
		// list.insertBefore(1, "peach");
		// list.insertBefore(1, "cherry");
		// list.insertBefore(3, "donut");
		//
		// list.insertAfter(0, "apple");
		// list.insertAfter(0, "pear");
		// list.insertAfter(1, "peach");
		// list.insertAfter(1, "cherry");
		// list.insertAfter(3, "donut");
		//
		// list.display();
		//
		// list.removeTop();
		//
		// list.delAt(4);
		// list.delAt(2);
		// list.delAt(0);
		//
		// list.removeTop();
		// list.removeTop();

		list.display();
	}
}

package lab10;
public class LinkedListLab {
	public static void main(String[] args) {
		System.out.println("\n\n\n ================================================================ Linked List Lab ================================================================ \n\n\n");
		System.out.println("\n\n ================================ Singly Linked List ================================ \n\n");

		LinkedList list = new LinkedList();

		log("Current length = " + list.getLen());

		list.display();

		list.push("node a");
		list.display();

		log("Popped data: " + list.pop());
		list.display();

		list.push("node b");
		list.push("node c");
		list.push("node d");
		list.push("node e");
		list.push("node f");
		list.display();

		log("Popped data: " + list.pop());
		list.display();

		list.push("node g");
		list.display();

		log("Current length = " + list.getLen());

		list.insertBefore(0, "apple");
		list.display();

		list.insertBefore(0, "pear");
		list.display();
		list.insertBefore(1, "peach");
		list.display();

		list.insertBefore(1, "cherry");
		list.display();
		list.insertBefore(3, "donut");
		list.display();

		list.insertAfter(0, "apple");
		list.display();
		list.insertAfter(0, "pear");
		list.display();
		list.insertAfter(1, "peach");
		list.display();
		list.insertAfter(1, "cherry");
		list.display();
		list.insertAfter(3, "donut");

		list.display();
		log("Current length = " + list.getLen());

		list.removeTop();
		list.display();

		list.delAt(4);
		list.display();
		list.delAt(2);
		list.display();
		list.delAt(0);
		list.display();

		list.removeTop();
		list.display();
		list.removeTop();

		list.display();



		System.out.println("\n\n ================================ Doubly Linked List ================================ \n\n");

		DoublyLinkedList list2 = new DoublyLinkedList();

		log("Current length = " + list2.getLen());

		list2.display();

		list2.push("node a");
		list2.display();

		log("Popped data: " + list2.pop());
		list2.display();

		list2.push("node b");
		list2.push("node c");
		list2.push("node d");
		list2.push("node e");
		list2.push("node f");
		list2.display();

		log("Popped data: " + list2.pop());
		list2.display();

		list2.push("node g");
		list2.display();

		log("Current length = " + list2.getLen());

		list2.insertBefore(0, "apple");
		list2.display();

		list2.insertBefore(0, "pear");
		list2.display();
		list2.insertBefore(1, "peach");
		list2.display();

		list2.insertBefore(1, "cherry");
		list2.display();
		list2.insertBefore(3, "donut");
		list2.display();

		list2.insertAfter(0, "apple");
		list2.display();
		list2.insertAfter(0, "pear");
		list2.display();
		list2.insertAfter(1, "peach");
		list2.display();
		list2.insertAfter(1, "cherry");
		list2.display();
		list2.insertAfter(3, "donut");

		list2.display();
		log("Current length = " + list2.getLen());

		list2.removeTop();
		list2.display();

		list2.delAt(4);
		list2.display();
		list2.delAt(2);
		list2.display();
		list2.delAt(0);
		list2.display();

		list2.removeTop();
		list2.display();
		list2.removeTop();

		list2.display();
	}
	public static void log(String s) {
		System.out.println("\t" + s);
	}
}
